package com.dardaniel.demo.data

import com.dardaniel.demo.data.model.QuoteModel
import com.dardaniel.demo.data.model.QuoteProvider
import com.dardaniel.demo.data.network.QuoteService
import javax.inject.Inject

class QuoteRepository @Inject constructor(
    private val api: QuoteService, private val quoteProvider: QuoteProvider
) {

    suspend fun getAllQuotes(): List<QuoteModel> {
        val response = api.getQuotes()
        quoteProvider.quotes = response
        return response
    }

}