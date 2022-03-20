package com.dardaniel.demo.domain

import com.dardaniel.demo.data.QuoteRepository
import com.dardaniel.demo.data.database.entities.toDatabase
import com.dardaniel.demo.domain.model.Quote
import javax.inject.Inject


class GetQuotesUseCase @Inject constructor(private val repository: QuoteRepository) {

    suspend operator fun invoke(): List<Quote> {
        val quotes = repository.getAllQuotesFromApi()

        return if (quotes.isNotEmpty()) {
            repository.clearQuotes()
            repository.insertQuote(quotes.map { it.toDatabase() })
            quotes
        } else {
            repository.getAllQuotesFromDatabase()
        }

    }

}