package com.example.example.moldashsyrympackage.services

import io.reactivex.Single
import com.example.example.moldashsyrympackage.models.Feed
import retrofit2.http.GET
import retrofit2.http.Query
import java.nio.channels.spi.AbstractSelectionKey

interface NewsService {

    @GET("v2/everything?sortBy=relevance&q=bitcoin&pageSize=100")
    fun getTopNews(@Query("apiKey") apiKey: String): Single<Feed>
}
