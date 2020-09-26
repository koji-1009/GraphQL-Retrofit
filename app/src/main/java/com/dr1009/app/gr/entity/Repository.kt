package com.dr1009.app.gr.entity

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class RepositoryResponse(
    val data: RepositoryData
)

@JsonClass(generateAdapter = true)
data class RepositoryData(
    val viewer: RepositoryViewer
)

@JsonClass(generateAdapter = true)
data class RepositoryViewer(
    val repositories: RepositoryNodes
)

@JsonClass(generateAdapter = true)
data class RepositoryNodes(
    val nodes: List<RepositoryFragment>
)

@JsonClass(generateAdapter = true)
data class RepositoryFragment(
    val id: String,
    val name: String,
    val url: String,
    val description: String?,
    val createdAt: String,
)
