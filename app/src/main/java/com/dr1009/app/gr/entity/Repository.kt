package com.dr1009.app.gr.entity

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class RepositoryResponse(
    val fragments: RepositoryFragments
)

@JsonClass(generateAdapter = true)
data class RepositoryFragments(
    val repositoryFragment: RepositoryFragment
)

@JsonClass(generateAdapter = true)
data class RepositoryFragment(
    val id: String,
    val name: String,
    val description: String?
)
