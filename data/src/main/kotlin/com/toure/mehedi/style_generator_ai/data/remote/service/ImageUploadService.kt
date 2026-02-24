package com.toure.mehedi.style_generator_ai.data.remote.service

import android.util.Log
import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.request.forms.MultiPartFormDataContent
import io.ktor.client.request.forms.formData
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.client.statement.bodyAsText
import io.ktor.http.Headers
import io.ktor.http.HttpHeaders
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.json.JSONObject
import javax.inject.Inject

class ImageUploadService @Inject constructor() {

    private val httpClient = HttpClient(Android)

    suspend fun uploadImage(imageBytes: ByteArray): String = withContext(Dispatchers.IO) {
        Log.d(TAG, "Uploading image (${imageBytes.size} bytes)")

        val responseText = httpClient.post(UPLOAD_URL) {
            setBody(
                MultiPartFormDataContent(
                    formData {
                        append(
                            key = "file",
                            value = imageBytes,
                            headers = Headers.build {
                                append(HttpHeaders.ContentType, "image/jpeg")
                                append(HttpHeaders.ContentDisposition, "filename=\"image.jpg\"")
                            }
                        )
                    }
                )
            )
        }.bodyAsText()

        val url = JSONObject(responseText)
            .getJSONObject("data")
            .getString("url")
            .replace("tmpfiles.org/", "tmpfiles.org/dl/")

        Log.d(TAG, "Uploaded image URL: $url")
        url
    }

    companion object {
        private const val TAG = "ImageUploadService"
        private const val UPLOAD_URL = "https://tmpfiles.org/api/v1/upload"
    }
}
