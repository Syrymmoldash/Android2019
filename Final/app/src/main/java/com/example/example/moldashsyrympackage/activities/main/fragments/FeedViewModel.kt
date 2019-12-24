package com.example.example.moldashsyrympackage.activities.main.fragments

import android.graphics.Bitmap
import androidx.lifecycle.ViewModel
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import com.example.example.moldashsyrympackage.Constants
import com.example.example.moldashsyrympackage.models.Feed
import com.example.example.moldashsyrympackage.services.NewsService
import com.example.example.moldashsyrympackage.services.ServiceCreator

class FeedViewModel : ViewModel() {

    private val newsService = ServiceCreator.createService<NewsService>()

    fun getFeed(fragmentType: String): Single<Feed>? {
        return newsService?.getTopNews(Constants.apiKey)?.subscribeOn(Schedulers.io())?.observeOn(AndroidSchedulers.mainThread())
    }

}
