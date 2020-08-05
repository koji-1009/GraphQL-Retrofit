package com.dr1009.app.gr.repository

import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.coroutines.toDeferred
import com.dr1009.app.gr.RepositoriesQuery
import com.dr1009.app.gr.type.OrderDirection
import com.dr1009.app.gr.type.RepositoryOrderField
import javax.inject.Inject

class GraphQLRepository @Inject constructor(
    private val client: ApolloClient
) {
    suspend fun repositories() = client.query(
        RepositoriesQuery(
            repositoriesCount = 20,
            orderBy = RepositoryOrderField.CREATED_AT,
            orderDirection = OrderDirection.ASC
        )
    ).toDeferred().await()
}