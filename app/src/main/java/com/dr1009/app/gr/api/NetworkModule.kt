package com.dr1009.app.gr.api

import com.apollographql.apollo.ApolloClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit

@Module
@InstallIn(ApplicationComponent::class)
object NetworkModule {

    @Provides
    fun provideOkHttp(): OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(HttpLoggingInterceptor())
        .addInterceptor {
            val original = it.request()
            val builder = original.newBuilder()
                .header("Authorization", "bearer $TOKEN")
                .method(original.method, original.body)

            it.proceed(builder.build())
        }
        .build()

    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
        .baseUrl(END_POINT)
        .client(okHttpClient)
        .build()

    @Provides
    fun provideRetrofitService(retrofit: Retrofit): RetrofitService = retrofit
        .create(RetrofitService::class.java)

    @Provides
    fun provideApolloClient(okHttpClient: OkHttpClient): ApolloClient = ApolloClient.builder()
        .okHttpClient(okHttpClient)
        .serverUrl(END_POINT + "graphql")
        .build()

    // https://docs.github.com/en/graphql/guides/forming-calls-with-graphql#the-graphql-endpoint
    private const val END_POINT = "https://api.github.com/"

    // set your token
    private const val TOKEN = ""
}