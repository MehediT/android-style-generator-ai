# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Rules

- Do exactly what is asked, nothing more
  - If a component is requested, implement only that component
- When in doubt about scope, ask before doing
- After every file modification, always run `git add .`
- Never hardcode strings, always use `R.string` XML resources from `app/src/main/res/values/strings.xml`
- Never hardcode sizes or colors, always use the values defined in `ui/theme/`:
  - Colors: `Color.kt`
  - Dimensions & spacing: `Dimension.kt` (use `Spacing` and `BorderRadius` objects)
  - Elevation: `Elevation.kt`
  - Typography: `Type.kt`

## Project Overview

**Android Style Generator AI** is a Jetpack Compose Android application for fashion product browsing with AI-powered try-on. The app uses:
- **Jetpack Compose** for UI
- **Hilt** for dependency injection
- **Navigation Compose** for screen routing
- **MVVM pattern** with ViewModels and `StateFlow`
- **Coil 3** for async image loading
- **Supabase** as the backend

## Build & Run Commands

### Build
```bash
./gradlew build                 # Full build with tests
./gradlew assembleDebug         # Build debug APK
./gradlew assembleRelease       # Build release APK
```

### Run
```bash
./gradlew installDebug          # Build and install debug APK to device
```

### Tests
```bash
./gradlew test                  # Run all unit tests
./gradlew test --tests "*UnitTest"  # Run specific unit test file
./gradlew connectedAndroidTest  # Run instrumented tests on connected device
```

### Code Quality
```bash
./gradlew lint                  # Run Android linter
```

## Module Structure

The project is split into three Gradle modules:

```
androidstylegeneratorai/
├── app/          # UI layer — Compose screens, ViewModels, theme, navigation
├── domain/       # Pure Kotlin — business models, repository interfaces, use cases
└── data/         # Implementation layer — API, DTOs, repository impls, DI modules
```

- `domain` has no Android dependencies; `data` depends on `domain`; `app` depends on both.
- Hilt DI modules live in `data/src/main/kotlin/.../di/` (`ClientModule`, `RepositoryModule`).
- Supabase config: `data/.../config/SupabaseAppConfig.kt`.

## Architecture & Code Structure

### App Module Layout
```
app/src/main/java/com/toure/mehedi/style_generator_ai/
├── MainActivity.kt
├── StyleGeneratorApplication.kt
├── navigation/
│   ├── Routes.kt               # Sealed class with all routes
│   └── NavGraph.kt             # Navigation composition
├── ui/
│   ├── MainScaffold.kt         # Root scaffold with dynamic top bar selection
│   ├── models/                 # UI-layer data models
│   │   ├── FashionProduct.kt
│   │   ├── ExploreCard.kt      # Interface implemented by FashionProduct & PromotionCard
│   │   ├── Gender.kt
│   │   └── FashionProductMapper.kt  # domain → UI model mapping
│   ├── screens/
│   │   ├── explore/            # Fashion product browsing (staggered grid)
│   │   │   ├── ExploreScreen.kt
│   │   │   ├── ExploreViewModel.kt
│   │   │   └── components/
│   │   │       ├── FashionProductCard.kt
│   │   │       ├── FashionProductTitle.kt
│   │   │       └── PromotedContent.kt
│   │   ├── fashionproductdetail/
│   │   │   ├── FashionProductDetailScreen.kt
│   │   │   └── components/
│   │   │       ├── FashionProductDetailImage.kt
│   │   │       ├── FashionProductDetailInfo.kt
│   │   │       ├── FashionProductTags.kt
│   │   │       ├── FashionProductPremiumBadge.kt
│   │   │       └── FashionProductMetaChips.kt
│   │   ├── designsystem/
│   │   ├── stylegenerator/
│   │   └── settings/
│   ├── components/
│   │   ├── ShimmerCard.kt      # Animated shimmer loading placeholder
│   │   └── topbars/
│   │       ├── HomeTopBar.kt   # Search/notification badges + destination chips
│   │       ├── FashionProductDetailTopBar.kt
│   │       ├── SearchBadge.kt
│   │       ├── NotificationBadge.kt
│   │       └── DestinationChip.kt
│   └── theme/
│       ├── Color.kt
│       ├── Dimension.kt
│       ├── Elevation.kt
│       ├── Type.kt
│       └── Theme.kt
```

### Navigation Flow
Routes are defined in `Routes.kt` as sealed classes:
- **Explore** - Main fashion product browsing screen (entry point)
- **Recommendations** - "For You" recommendations screen
- **FashionProductDetail** - Product detail with "Test on me" button

`NavGraph.kt` shares the `ExploreViewModel` instance between `Explore` and `FashionProductDetail` screens so the selected product is available on the detail screen without navigation arguments.

### Screen Pattern (MVVM)
Each screen follows this pattern:
1. **Screen Composable** (`*Screen.kt`) - UI, receives callbacks for navigation
2. **ViewModel** (`*ViewModel.kt`) - `StateFlow<UiState>` for state management
3. **Sub-components** (`components/`) - Screen-specific reusable components

### Top Bar Pattern
Each screen-specific top bar is in `components/topbars/`. `MainScaffold` dynamically selects the top bar by current route. Screens requiring back navigation pass `onNavigateBack` to their top bar.

### Cross-Screen State Sharing
When two screens share data (e.g., selected product from Explore → Detail), use a shared ViewModel instance retrieved from the back-stack entry rather than navigation arguments:
```kotlin
// In NavGraph.kt
val backStackEntry = remember(navEntry) { navController.getBackStackEntry(Routes.Explore.route) }
val sharedVm: ExploreViewModel = hiltViewModel(backStackEntry)
```

## Design System & Theme

### Colors (`ui/theme/Color.kt`)
- **Primary**: `PinterestRed`, `PinterestRedHover`
- **Background**: `BackgroundWhite`, `CharcoalBlack`
- **Neutral**: `LightGray`, `MediumGray`, `PureWhite`
- **Status**: `Success`, `Warning`, `Error`, `Info`
- **Overlays**: `OverlayDark`, `OverlayLight`
- **Dark mode**: `DarkBackground`, `DarkSurface`, `DarkSurfaceElevated`, `DarkSurfaceVariant`, `DarkOnSurface`, `DarkOnSurfaceVariant`, `DarkOutline`, `DarkOutlineVariant`

### Dimensions (`ui/theme/Dimension.kt`)
**Spacing system** (8px scale):
- `xxs = 4.dp`, `xs = 8.dp`, `s = 12.dp`, `m = 16.dp`, `l = 24.dp`, `xl = 32.dp`, `xxl = 48.dp`, `xxxl = 64.dp`

**Border Radius**:
- `tiny = 4.dp`, `small = 6.dp`, `medium = 8.dp`, `large = 12.dp`, `xLarge = 16.dp`, `round = 50%`

Usage:
```kotlin
Modifier.padding(Spacing.m)
Modifier.clip(RoundedCornerShape(BorderRadius.medium.dp))
```

## Key Development Patterns

### Adding a New Screen
1. Create screen files: `ui/screens/myscreen/MyScreen.kt` and `MyScreenViewModel.kt`
2. Add route to `Routes.kt`
3. Add composable entry in `NavGraph.kt`
4. Add top bar entry to `MainScaffold.kt` if needed
5. Create `components/topbars/MyScreenTopBar.kt` if the screen has a custom top bar

### Async Image Loading (Coil 3)
```kotlin
AsyncImage(
    model = imageUrl,
    contentDescription = null,
    onLoading = { /* show shimmer */ },
    onSuccess = { /* hide shimmer */ },
    onError = { /* handle error */ }
)
```

### Shimmer Loading Placeholder
Use `ShimmerCard` (`ui/components/ShimmerCard.kt`) for loading states. It is a custom animated shimmer that replaces the deprecated accompanist-placeholder library.

### Staggered Grid Layout
`ExploreScreen` uses `LazyVerticalStaggeredGrid` for a Pinterest-style layout. Promotion cards are injected every 3rd item by inserting `PromotionCard` instances into the `ExploreCard` list.

### Using Strings (No Hardcoding)
Add strings to `app/src/main/res/values/strings.xml`:
```xml
<string name="my_string">My String Value</string>
```
```kotlin
stringResource(id = R.string.my_string)
```

### Dependency Injection with Hilt
```kotlin
@HiltViewModel
class MyViewModel @Inject constructor(
    private val useCase: MyUseCase
) : ViewModel() {}
```
Apply `@AndroidEntryPoint` to Activities (already on `MainActivity`). DI modules for data sources live in `data/.../di/`.

### Adding a Use Case / Repository
1. Define model in `domain/.../model/`
2. Define repository interface in `domain/.../repository/`
3. Create use case in `domain/.../usecase/`
4. Implement repository in `data/.../repository/`
5. Bind implementation in `data/.../di/RepositoryModule.kt`
6. Map domain → UI model in `app/.../ui/models/`

## Build Configuration

- **Target SDK**: 36 (Android 15)
- **Min SDK**: 27 (Android 8.1)
- **Java/Kotlin Target**: 11
- **Compose**: Enabled
- **Hilt + KSP**: Enabled
- **Key dependencies**: Coil 3 (`coil.compose`, `coil.network.okhttp`), Material Icons Extended, Accompanist Permissions