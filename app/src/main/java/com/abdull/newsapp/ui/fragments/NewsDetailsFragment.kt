package com.abdull.newsapp.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.abdull.newsapp.R
import com.abdull.newsapp.databinding.FragmentNewsDetailsBinding
import com.bumptech.glide.Glide
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewsDetailsFragment : Fragment(R.layout.fragment_news_details) {

    private val args by navArgs<NewsDetailsFragmentArgs>()

    private lateinit var binding : FragmentNewsDetailsBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentNewsDetailsBinding.bind(view)

        Glide.with(view).load(args.article.urlToImage).into(binding.ivDetailsImage)

        binding.tvDetailsTitle.text = args.article.title
        binding.tvDetailsAuthor.text = getString(R.string.author, args.article.author)
        binding.tvDetailsDescription.text = args.article.content
        binding.tvDetailsPublishedAt.text = getString(R.string.published_at, args.article.publishedAt)


    }
}