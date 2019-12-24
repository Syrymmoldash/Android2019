package com.example.example.moldashsyrympackage

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_article.view.*
import com.example.example.moldashsyrympackage.models.Article

class ArticleAdapter(private val dataset: List<Article>,private val listener: OnItemArticleListener): RecyclerView.Adapter<ArticleAdapter.ArticleViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        return ArticleViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_article,parent, false))
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        holder.bind(dataset[position])
    }


    inner class ArticleViewHolder(v: View): RecyclerView.ViewHolder(v){
        fun bind(p: Article){
            itemView.titleTextView.text = p.title
            itemView.descriptionTextView.text = p.description
            itemView.created_at.text = p.publishedAt

            Glide.with(itemView)
                .load(p.urlToImage)
                .placeholder(R.drawable.loading)
                .into(itemView.mainImage)

            itemView.setOnClickListener {
                listener.startArticleDetailsActivity(p)
            }

        }
    }

}