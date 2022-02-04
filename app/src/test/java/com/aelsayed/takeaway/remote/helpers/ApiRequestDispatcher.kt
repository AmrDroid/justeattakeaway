package com.aelsayed.takeaway.remote.helpers

import com.aelsayed.takeaway.remote.ApiConstants.NO_RES_URI
import com.aelsayed.takeaway.remote.ApiConstants.URI
import com.aelsayed.takeaway.remote.NO_RESULT
import com.aelsayed.takeaway.remote.RESTAURANTS
import okhttp3.mockwebserver.Dispatcher
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.RecordedRequest
import java.net.HttpURLConnection


internal class ApiRequestDispatcher : Dispatcher() {

    override fun dispatch(request: RecordedRequest): MockResponse {

        return when (request.path) {

            URI -> {
                MockResponse()
                    .setResponseCode(HttpURLConnection.HTTP_OK)
                    .setBody(RESTAURANTS)
            }


            NO_RES_URI -> {
                MockResponse()
                    .setResponseCode(HttpURLConnection.HTTP_OK)
                    .setBody(NO_RESULT)
            }

            else -> throw IllegalArgumentException("Unknown Request Path ${request.path.toString()}")
        }
    }

}