package com.dardaniel.demo.data

import com.dardaniel.demo.data.model.QuoteModel
import com.dardaniel.demo.data.model.QuoteProvider
import com.dardaniel.demo.data.network.QuoteService

class QuoteRepository {

    private val api = QuoteService()

    suspend fun getAllQuotes(): List<QuoteModel> {
        val response = api.getQuotes()
        QuoteProvider.quotes = response
        return response
    }

}