package com.dardaniel.demo.data.network

import com.dardaniel.demo.data.model.QuoteModel
import retrofit2.Response

import retrofit2.http.GET

interface QuoteApiClient {

    @GET("/.json")
    suspend fun getAllQuotes(): Response<List<QuoteModel>>

}