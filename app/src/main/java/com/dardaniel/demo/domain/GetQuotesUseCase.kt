package com.dardaniel.demo.domain

import com.dardaniel.demo.data.QuoteRepository
import com.dardaniel.demo.data.model.QuoteModel
import javax.inject.Inject


class GetQuotesUseCase @Inject constructor(private val repository: QuoteRepository) {


    suspend operator fun invoke(): List<QuoteModel>? = repository.getAllQuotes()

}