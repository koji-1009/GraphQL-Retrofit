package com.dr1009.app.gr.repository

import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.coroutines.toDeferred
import com.dr1009.app.gr.SampleQuery
import javax.inject.Inject

class GraphQLRepository @Inject constructor(
    private val client: ApolloClient
) {
    suspend fun sample() = client.query(SampleQuery()).toDeferred().await()
}