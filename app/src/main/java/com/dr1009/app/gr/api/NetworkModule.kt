package com.dr1009.app.gr.api

import com.apollographql.apollo.ApolloClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@Module
@InstallIn(ApplicationComponent::class)
object NetworkModule {

    @Provides
    fun provideApolloClient(): ApolloClient = ApolloClient.builder()
        .serverUrl("https://api.github.com/graphql")
        .build()
}