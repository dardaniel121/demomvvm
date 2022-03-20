package com.dardaniel.demo.data

import com.dardaniel.demo.data.database.dao.QuoteDao
import com.dardaniel.demo.data.database.entities.QuoteEntity
import com.dardaniel.demo.data.model.QuoteModel
import com.dardaniel.demo.data.network.QuoteService
import com.dardaniel.demo.domain.model.Quote
import com.dardaniel.demo.domain.model.toDomain
import javax.inject.Inject

class QuoteRepository @Inject constructor(
    private val api: QuoteService,
    private val quoDao: QuoteDao
) {

    suspend fun getAllQuotesFromApi(): List<Quote> {
        val response: List<QuoteModel> = api.getQuotes()
        return response.map { it.toDomain() }
    }

    suspend fun getAllQuotesFromDatabase(): List<Quote> {
        val response: List<QuoteEntity> = quoDao.getAllQuotes()
        return response.map { it.toDomain() }
    }

    suspend fun insertQuote(quotes: List<QuoteEntity>) {
        quoDao.insertAll(quotes)
    }

    suspend fun clearQuotes() {
        quoDao.deleteAllQuotes()
    }
}