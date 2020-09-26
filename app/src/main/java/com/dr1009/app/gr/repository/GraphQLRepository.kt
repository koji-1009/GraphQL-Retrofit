package com.dr1009.app.gr.repository

import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.coroutines.toDeferred
import com.dr1009.app.gr.RepositoriesQuery
import javax.inject.Inject

class GraphQLRepository @Inject constructor(
    private val client: ApolloClient
) {
    suspend fun repositories() = client
        .query(RepositoriesQuery())
        .toDeferred()
        .await()
        .data?.viewer?.repositories?.nodes
        .orEmpty()
        .filterNotNull()
}