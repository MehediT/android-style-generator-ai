package com.toure.mehedi.style_generator_ai.data.remote.service

import android.util.Log
import javax.inject.Inject

class TryOnServiceApi @Inject constructor() {
    suspend fun tryOn(imageBytes: ByteArray, productId: String): String {
        Log.d("TryOnServiceApi", "Trying on product $productId with image $imageBytes")
        TODO("Implement API call")
    }
}
