package com.tharin.locations.data.remote

import com.tharin.locations.data.mappers.toLocationItem
import com.tharin.locations.data.utils.URLConstants
import com.tharin.locations.domain.model.LocationItem
import com.tharin.locations.domain.remote.RandomLocationClient
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.utils.io.errors.IOException

class RandomLocationClientImpl(
    private val httpClient: HttpClient
): RandomLocationClient {

    override suspend fun getRandomLocation(): LocationItem {
        try {
            val response = httpClient.get(URLConstants.RANDOM_LOCATION_URL) {
                contentType(ContentType.Application.Json)
            }.body<ApiResponse>()
            return response.randomLocation.toLocationItem()
        } catch (e: IOException) {
            throw e
        }
    }

}