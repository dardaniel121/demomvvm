package com.dardaniel.demo.domain.model

import com.dardaniel.demo.data.database.entities.QuoteEntity
import com.dardaniel.demo.data.model.QuoteModel

data class Quote(val quote: String, val author: String)


fun QuoteModel.toDomain() = Quote(quote, author)
fun QuoteEntity.toDomain() = Quote(quote, author)