package com.example.example.moldashsyrympackage.activities.details

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_article.*
import com.example.example.moldashsyrympackage.R
import com.example.example.moldashsyrympackage.models.Article

class ArticleActivity : AppCompatActivity() {

    private var article: Article? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_article)


        article = intent.getSerializableExtra("article") as? Article

        article?.let {article ->
            newsTitle.text = article.title
            newsCreationDate.text = article.publishedAt
            descriptionTextView.text = article.content

            Glide.with(this)
                .load(article.urlToImage)
                .placeholder(R.drawable.loading)
                .into(mainImage)
        }
    }
}
