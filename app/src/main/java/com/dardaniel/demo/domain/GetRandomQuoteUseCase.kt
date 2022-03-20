package com.dardaniel.demo.domain

import com.dardaniel.demo.data.QuoteRepository
import com.dardaniel.demo.data.model.QuoteModel
import com.dardaniel.demo.domain.model.Quote
import javax.inject.Inject


class GetRandomQuoteUseCase @Inject constructor(private val quoteRepository: QuoteRepository) {

    suspend operator fun invoke(): Quote? {
        val quotes = quoteRepository.getAllQuotesFromDatabase()
        if (!quotes.isNullOrEmpty()) {
            val randomNumber: Int = (quotes.indices).random()
            return quotes[randomNumber]
        }
        return null
    }
}