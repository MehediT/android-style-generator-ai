package com.toure.mehedi.style_generator_ai.navigation

sealed class Routes(val route: String) {
    data object Explore : Routes("explore")
    data object Recommendations : Routes("recommendations")
    data object ImageDetail : Routes("fashion_product_detail")
    data object GeneratedImage : Routes("generated_image")
}
