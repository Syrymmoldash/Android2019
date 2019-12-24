package com.example.example.moldashsyrympackage.activities.main.fragments

import android.content.Intent
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.feed_fragment.*
import com.example.example.moldashsyrympackage.ArticleAdapter
import com.example.example.moldashsyrympackage.OnItemArticleListener

import com.example.example.moldashsyrympackage.R
import com.example.example.moldashsyrympackage.activities.details.ArticleActivity
import com.example.example.moldashsyrympackage.models.Article

const val FRAGMENT_TYPE = "fragment_type"

class FeedFragment : Fragment(), OnItemArticleListener {

    companion object {
        fun newInstance(fragmentType: String) = FeedFragment().apply {
            arguments = Bundle().apply {
                putString(FRAGMENT_TYPE, fragmentType)
            }
        }
    }

    private lateinit var viewModel: FeedViewModel
    private var fragmentType: String? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.feed_fragment, container, false)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            fragmentType = it.getString(FRAGMENT_TYPE)
        }
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recList?.layoutManager = LinearLayoutManager(context)
        viewModel = ViewModelProviders.of(this).get(FeedViewModel::class.java)


        fragmentType?.let {
            progressBar?.visibility = ProgressBar.VISIBLE
            viewModel.getFeed(it)?.subscribe { feed ->
                recList?.adapter = ArticleAdapter(feed.articles, this)
                progressBar?.visibility = ProgressBar.GONE
            }
        }
    }

    override fun startArticleDetailsActivity(article: Article) {
        activity?.startActivity(Intent(activity, ArticleActivity::class.java).putExtra("article", article))
    }
}

object FragmentType{
    const val TOP = "top"
}
