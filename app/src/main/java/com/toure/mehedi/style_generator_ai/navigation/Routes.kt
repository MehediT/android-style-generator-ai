package com.toure.mehedi.style_generator_ai.navigation

sealed class Routes(val route: String) {
    data object Explore : Routes("explore")
    data object Recommendations : Routes("recommendations")
    data object FashionProductDetail : Routes("fashion_product_detail")
}
