package com.toure.mehedi.style_generator_ai.ui.screens.imagedetail

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.toure.mehedi.style_generator_ai.ui.models.Gender
import com.toure.mehedi.style_generator_ai.ui.theme.AppTheme

@Composable
fun ImageDetailInfo(
    name: String,
    isPremium: Boolean,
    category: String,
    style: String?,
    gender: Gender?,
    description: String,
    tags: List<String>,
    modifier: Modifier = Modifier,
) {

}

@Preview(showBackground = true)
@Composable
private fun ImageDetailInfoPrev() {
    AppTheme {
        ImageDetailInfo(
            name = "Classic Black T-Shirt",
            isPremium = true,
            category = "CLOTHING",
            style = "Casual",
            gender = Gender.UNISEX,
            description = "Timeless black t-shirt perfect for any casual outfit",
            tags = listOf("casual", "basic", "black", "unisex")
        )
    }
}
