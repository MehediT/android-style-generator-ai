package com.toure.mehedi.style_generator_ai.navigation

sealed class Routes(val route: String) {
    data object Home : Routes("home")
    data object DesignSystem : Routes("design_system")
    data object StyleGenerator : Routes("style_generator")
    data object Settings : Routes("settings")
}
