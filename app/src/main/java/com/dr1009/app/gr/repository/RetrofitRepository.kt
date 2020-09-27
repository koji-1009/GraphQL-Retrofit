package com.dr1009.app.gr.repository

import com.dr1009.app.gr.api.RetrofitService
import com.dr1009.app.gr.entity.GraphQLBody
import javax.inject.Inject

class RetrofitRepository @Inject constructor(
    private val service: RetrofitService
) {
    suspend fun repositories() = service.repositories(
        GraphQLBody(
            query = "query { viewer { repositories(first: 20) { nodes { ...RepositoryFragment } } } } fragment RepositoryFragment on Repository { id name url description createdAt }",
            variables = "{}"
        )
    ).data.viewer.repositories.nodes
}