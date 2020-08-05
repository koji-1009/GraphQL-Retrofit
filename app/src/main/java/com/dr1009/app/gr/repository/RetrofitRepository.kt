package com.dr1009.app.gr.repository

import com.dr1009.app.gr.api.RetrofitService
import com.dr1009.app.gr.entity.GraphQLRequest
import javax.inject.Inject

class RetrofitRepository @Inject constructor(
    private val service: RetrofitService
) {
    // TODO add query
    suspend fun repositories() = service.repositories(
        GraphQLRequest(
            query = "",
            variables = ""
        )
    )
}