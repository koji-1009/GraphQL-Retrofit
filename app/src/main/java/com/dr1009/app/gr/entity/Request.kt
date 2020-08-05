package com.dr1009.app.gr.entity

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class GraphQLRequest(
    val query: String,
    val variables: String
)