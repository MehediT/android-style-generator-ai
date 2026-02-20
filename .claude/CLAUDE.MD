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

**Android Style Generator AI** is a Jetpack Compose Android application that provides tools for design system management and style generation. The app uses:
- **Jetpack Compose** for UI
- **Hilt** for dependency injection
- **Navigation Compose** for screen routing
- **MVVM pattern** with ViewModels for state management

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

## Architecture & Code Structure

### Project Layout
```
app/src/main/java/com/toure/mehedi/style_generator_ai/
├── MainActivity.kt              # Entry point, sets up theme and navigation
├── StyleGeneratorApplication.kt # Application class with Hilt setup
├── navigation/
│   ├── Routes.kt               # Sealed class defining all screen routes
│   └── NavGraph.kt             # Navigation composition with all routes
├── ui/
│   ├── MainScaffold.kt         # Root scaffold with dynamic top bar
│   ├── screens/
│   │   ├── home/               # Home screen (main entry point)
│   │   │   ├── HomeScreen.kt
│   │   │   ├── HomeViewModel.kt
│   │   │   └── components/     # Home-specific sub-components
│   │   ├── designsystem/       # Design system showcase
│   │   ├── stylegenerator/     # Style generator tool
│   │   └── settings/           # Settings screen
│   ├── components/
│   │   ├── Button.kt           # Reusable components
│   │   └── topbars/            # Screen-specific top app bars
│   ├── theme/                  # Centralized design system
│   │   ├── Color.kt            # All color definitions
│   │   ├── Dimension.kt        # Spacing and border radius system
│   │   ├── Elevation.kt        # Shadow/elevation values
│   │   ├── Type.kt             # Typography (fonts, sizes, styles)
│   │   └── Theme.kt            # Material3 theme composition
│   └── showcase/               # Design system showcase/demo
```

### Navigation Flow
Routes are defined in `Routes.kt` as sealed classes:
- **Home** - Main screen (entry point)
- **DesignSystem** - Design system showcase
- **StyleGenerator** - Style generator tool
- **Settings** - App settings

Navigation is handled in `NavGraph.kt`. Each screen receives `paddingValues` from the `MainScaffold` Scaffold to avoid content overlap with the top bar.

### Screen Pattern (MVVM)
Each screen follows this pattern:
1. **Screen Composable** (`*Screen.kt`) - UI composition, receives callbacks for navigation
2. **ViewModel** (`*ViewModel.kt`) - State management and business logic
3. **Sub-components** (`components/`) - Screen-specific reusable components

Example: `HomeScreen.kt` + `HomeViewModel.kt`

### Top Bar Pattern
Each screen-specific top bar is in `components/topbars/`. The `MainScaffold` uses navigation state to dynamically select the appropriate top bar. Screens requiring back navigation pass `onNavigateBack` callback to their top bar.

## Design System & Theme

### Colors (`ui/theme/Color.kt`)
- **Primary**: `PinterestRed`, `PinterestRedHover`
- **Background**: `BackgroundWhite`, `CharcoalBlack`
- **Neutral**: `LightGray`, `MediumGray`, `PureWhite`
- **Status**: `Success`, `Warning`, `Error`, `Info`
- **Overlays**: `OverlayDark`, `OverlayLight`

### Dimensions (`ui/theme/Dimension.kt`)
**Spacing system** (8px scale):
- `xxs = 4.dp`, `xs = 8.dp`, `s = 12.dp`, `m = 16.dp`, `l = 24.dp`, `xl = 32.dp`, `xxl = 48.dp`, `xxxl = 64.dp`

**Border Radius**:
- `small = 4.dp`, `medium = 8.dp`, `large = 12.dp`, `xLarge = 16.dp`, `round = 50%`

Usage:
```kotlin
Modifier.padding(Spacing.m)
Modifier.clip(RoundedCornerShape(BorderRadius.medium.dp))
Box(backgroundColor = PinterestRed)
```

## Key Development Patterns

### Adding a New Screen
1. Create screen files: `ui/screens/myscreen/MyScreen.kt` and `MyScreenViewModel.kt`
2. Add route to `Routes.kt`
3. Add composable entry in `NavGraph.kt`
4. Add top bar entry to `MainScaffold.kt` if needed
5. Create `components/topbars/MyScreenTopBar.kt` if the screen has a custom top bar

### Using Strings (No Hardcoding)
Add strings to `app/src/main/res/values/strings.xml`:
```xml
<string name="my_string">My String Value</string>
```

Access in code:
```kotlin
stringResource(id = R.string.my_string)
```

### Using Dimensions & Colors
```kotlin
// Colors
Text(color = PinterestRed)
Surface(color = BackgroundWhite)

// Spacing
Spacer(modifier = Modifier.height(Spacing.m))
Box(modifier = Modifier.padding(Spacing.l))

// Border radius
Card(shape = RoundedCornerShape(BorderRadius.medium.dp))
```

### Dependency Injection with Hilt
The app uses Hilt for DI. The `@HiltViewModel` annotation on ViewModels enables automatic injection:
```kotlin
@HiltViewModel
class MyViewModel @Inject constructor(
    // dependencies here
) : ViewModel() {}
```

Apply `@AndroidEntryPoint` to Activities (already on `MainActivity`).

## Testing

### Unit Tests
Unit tests go in `app/src/test/` and test business logic without Android framework:
```bash
./gradlew test
```

### Instrumented Tests
Instrumented tests (on device/emulator) go in `app/src/androidTest/` and can test Android-specific behavior:
```bash
./gradlew connectedAndroidTest
```

## Build Configuration

- **Target SDK**: 36 (Android 15)
- **Min SDK**: 27 (Android 8.1)
- **Java/Kotlin Target**: 11
- **Compose**: Enabled
- **Hilt**: Enabled
- **KSP**: Enabled (for Hilt annotation processing)

Key plugins in `build.gradle.kts`:
- `android.application`
- `kotlin.android`
- `kotlin.compose`
- `hilt.android`
- `ksp` (Kotlin Symbol Processing)
