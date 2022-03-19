package com.dardaniel.demo.domain

import com.dardaniel.demo.data.QuoteRepository
import com.dardaniel.demo.data.model.QuoteModel
import com.dardaniel.demo.data.model.QuoteProvider

class GetRandomQuoteUseCase {

    operator fun invoke(): QuoteModel? {
        val quotes: List<QuoteModel> = QuoteProvider.quotes
        if (!quotes.isNullOrEmpty()) {
            val randomNumber: Int = (quotes.indices).random()
            return quotes[randomNumber]
        }
        return null
    }
}