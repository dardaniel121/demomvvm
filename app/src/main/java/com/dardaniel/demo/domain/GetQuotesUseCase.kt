package com.dardaniel.demo.domain

import com.dardaniel.demo.data.QuoteRepository
import com.dardaniel.demo.data.model.QuoteModel

class GetQuotesUseCase {

    private val repository = QuoteRepository()

    suspend operator fun invoke(): List<QuoteModel>? = repository.getAllQuotes()

}