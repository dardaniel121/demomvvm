package com.dardaniel.demo.domain

import com.dardaniel.demo.data.model.QuoteModel
import com.dardaniel.demo.data.model.QuoteProvider
import javax.inject.Inject


class GetRandomQuoteUseCase @Inject constructor(private val quoteProvider: QuoteProvider) {

    operator fun invoke(): QuoteModel? {
        val quotes: List<QuoteModel> = quoteProvider.quotes
        if (!quotes.isNullOrEmpty()) {
            val randomNumber: Int = (quotes.indices).random()
            return quotes[randomNumber]
        }
        return null
    }
}