package com.example.fruitapp.io.swagger.client.auth

import okhttp3.MediaType
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.OkHttpClient
import okhttp3.Request
import kotlin.Throws
import org.apache.oltu.oauth2.common.exception.OAuthSystemException
import org.apache.oltu.oauth2.common.exception.OAuthProblemException
import org.apache.oltu.oauth2.client.response.OAuthClientResponse
import org.apache.oltu.oauth2.client.request.OAuthClientRequest
import okhttp3.RequestBody
import org.apache.oltu.oauth2.client.HttpClient
import org.apache.oltu.oauth2.client.response.OAuthClientResponseFactory
import java.io.IOException

class OAuthOkHttpClient : HttpClient {
    private var client: OkHttpClient

    constructor() {
        client = OkHttpClient()
    }

    constructor(client: OkHttpClient) {
        this.client = client
    }

    @Throws(OAuthSystemException::class, OAuthProblemException::class)
    override fun <T : OAuthClientResponse?> execute(
        request: OAuthClientRequest,
        headers: Map<String, String>,
        requestMethod: String,
        responseClass: Class<T>
    ): T {
        var mediaType = "application/json".toMediaTypeOrNull()
        val requestBuilder = Request.Builder().url(request.locationUri)
        if (headers != null) {
            for ((key, value) in headers) {
                if (key.equals("Content-Type", ignoreCase = true)) {
                    mediaType = value.toMediaTypeOrNull()
                } else {
                    requestBuilder.addHeader(key, value)
                }
            }
        }
        val body = if (request.body != null) RequestBody.create(mediaType, request.body) else null
        requestBuilder.method(requestMethod, body)
        return try {
            val response = client.newCall(requestBuilder.build()).execute()
            OAuthClientResponseFactory.createCustomResponse(
                response.body!!.string(),
                response.body!!.contentType().toString(),
                response.code,
                responseClass
            )
        } catch (e: IOException) {
            throw OAuthSystemException(e)
        }
    }

    override fun shutdown() {
        // Nothing to do here
    }
}