package com.toure.mehedi.style_generator_ai.ui.models

data class ImageUi(
    override val id: String,
    val name: String,
    override val description: String,
    val category: String,
    val negativePrompt: String? = null,
    val imageUrl: String,
    val aspectRatio: Float,
    val thumbnailUrl: String? = null,
    val tags: List<String> = emptyList(),
    val gender: Gender? = null,
    val style: String? = null,
    val isPremium: Boolean = false,
    val createdAt: Long = System.currentTimeMillis()
) : ExploreCard {
    override val title: String
        get() = name
}

val sampleImageUis = listOf(
    ImageUi(
        id = "product_1",
        name = "Classic Black T-Shirt",
        description = "Timeless black t-shirt perfect for any casual outfit",
        category = "CLOTHING",
        imageUrl = "https://gjmcvtxbeisgwgrvotnz.supabase.co/storage/v1/object/public/image_test/clothe1.jpg",
        aspectRatio = 1f,
        tags = listOf("casual", "basic", "black", "unisex"),
        gender = Gender.UNISEX,
        style = "Casual",
    ),
    ImageUi(
        id = "product_2",
        name = "Summer Dress",
        description = "Light and breezy summer dress for warm days",
        category = "CLOTHING",
        imageUrl = "https://gjmcvtxbeisgwgrvotnz.supabase.co/storage/v1/object/public/image_test/clothe2.jpg",
        aspectRatio = 1f,
        tags = listOf("summer", "dress", "women", "colorful"),
        gender = Gender.WOMEN,
        style = "Summer",
    ),
    ImageUi(
        id = "product_3",
        name = "Leather Jacket",
        description = "Edgy leather jacket to elevate any look",
        category = "CLOTHING",
        imageUrl = "https://gjmcvtxbeisgwgrvotnz.supabase.co/storage/v1/object/public/image_test/clothe3.jpg",
        aspectRatio = 1f,
        tags = listOf("jacket", "leather", "edgy", "men"),
        gender = Gender.MEN,
        style = "Street",
        isPremium = true
    ),
    ImageUi(
        id = "product_4",
        name = "Running Sneakers",
        description = "High-performance sneakers for all your athletic needs",
        category = "SHOES",
        imageUrl = "https://gjmcvtxbeisgwgrvotnz.supabase.co/storage/v1/object/public/image_test/clothe4.jpg",
        aspectRatio = 1f,
        tags = listOf("shoes", "sneakers", "sport", "unisex"),
        gender = Gender.UNISEX,
        style = "Sport",
    ),
    ImageUi(
        id = "product_5",
        name = "Designer Handbag",
        description = "Elegant handbag perfect for any occasion",
        category = "BAG",
        imageUrl = "https://gjmcvtxbeisgwgrvotnz.supabase.co/storage/v1/object/public/image_test/clothe5.jpg",
        aspectRatio = 1f,
        tags = listOf("bag", "handbag", "elegant", "women"),
        gender = Gender.WOMEN,
        style = "Luxury",
        isPremium = true
    ),
    ImageUi(
        id = "product_6",
        name = "Gold Necklace",
        description = "Delicate gold necklace with minimalist design",
        category = "JEWELRY",
        imageUrl = "https://gjmcvtxbeisgwgrvotnz.supabase.co/storage/v1/object/public/image_test/clothe6.jpg",
        aspectRatio = 1f,
        tags = listOf("jewelry", "necklace", "gold", "elegant"),
        gender = Gender.WOMEN,
        style = "Minimalist",
    ),
    ImageUi(
        id = "product_7",
        name = "Baseball Cap",
        description = "Classic baseball cap for casual style",
        category = "ACCESSORY",
        imageUrl = "https://gjmcvtxbeisgwgrvotnz.supabase.co/storage/v1/object/public/image_test/clothe7.jpg",
        aspectRatio = 1f,
        tags = listOf("accessory", "cap", "casual", "unisex"),
        gender = Gender.UNISEX,
        style = "Casual",
    ),
    ImageUi(
        id = "product_8",
        name = "Silk Scarf",
        description = "Premium silk scarf for sophisticated elegance",
        category = "ACCESSORY",
        imageUrl = "https://gjmcvtxbeisgwgrvotnz.supabase.co/storage/v1/object/public/image_test/clothe8.jpg",
        aspectRatio = 1f,
        tags = listOf("accessory", "scarf", "silk", "women"),
        gender = Gender.WOMEN,
        style = "Elegant",
        isPremium = true
    )
)