package com.dr1009.app.gr.api

import com.dr1009.app.gr.entity.GraphQLBody
import com.dr1009.app.gr.entity.RepositoryResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface RetrofitService {

    @POST(value = "graphql")
    suspend fun repositories(@Body body: GraphQLBody): RepositoryResponse
}