package com.abdull.newsapp.ui.fragments

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import android.widget.AbsListView
import android.widget.SearchView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.abdull.newsapp.R
import com.abdull.newsapp.adapter.NewsAdapter
import com.abdull.newsapp.databinding.FragmentNewsBinding
import com.abdull.newsapp.ui.NewsViewModel
import com.abdull.newsapp.util.Constants.PAGE_SIZE
import com.abdull.newsapp.util.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewsFragment : Fragment(R.layout.fragment_news) {

    private lateinit var binding: FragmentNewsBinding
    private val viewModel: NewsViewModel by viewModels()

    lateinit var newsAdapter: NewsAdapter

    private var queryText : String? = "android"

    override fun onCreate(savedInstanceState: Bundle?) {
        setHasOptionsMenu(true)
        super.onCreate(savedInstanceState)

    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentNewsBinding.bind(view)
        setupRecyclerView()
        newsAdapter.setOnItemClickListener {
            val action = NewsFragmentDirections.actionNewsFragmentToNewsDetailsFragment(it)
            findNavController().navigate(action)
        }

        viewModel.news.observe(viewLifecycleOwner, Observer {resource ->
            when(resource){
                is Resource.Success -> {
                    hideProgressBar()
                    resource.data?.let { articles ->
                        newsAdapter.diff.submitList(articles)

                    }
                }
                is Resource.Error -> {
                    hideProgressBar()
                    resource.message?.let {
                        Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
                    }
                }
                is Resource.Loading -> {
                    showProgressBar()
                }
            }
        })

    }

    private fun hideProgressBar(){
        binding.loadingProgressBar.visibility = View.INVISIBLE
        isLoading = false
    }

    private fun showProgressBar(){
        binding.loadingProgressBar.visibility = View.VISIBLE
        isLoading = true
    }
    private fun setupRecyclerView() {
        newsAdapter = NewsAdapter()

        binding.rvNews.apply {
            adapter = newsAdapter
            layoutManager = LinearLayoutManager(activity)
            addItemDecoration((DividerItemDecoration(context, DividerItemDecoration.VERTICAL)))
            addOnScrollListener(scrollingListener)

        }
    }

    var isLoading = false
    var isScrolling = false


    val scrollingListener = object : RecyclerView.OnScrollListener(){
        override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
            super.onScrollStateChanged(recyclerView, newState)
            if(newState == AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL){
                isScrolling = true
            }
        }

        override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
            super.onScrolled(recyclerView, dx, dy)

            val layoutManager = recyclerView.layoutManager as LinearLayoutManager
            val firstItemPosition = layoutManager.findFirstVisibleItemPosition()
            val totalVisible = layoutManager.childCount
            val totalItemsCount = layoutManager.itemCount

            val atLastItem = firstItemPosition + totalVisible >= totalItemsCount
            val notAtStart = firstItemPosition >= 0
            val totalMoreThanVisible = totalItemsCount >= PAGE_SIZE

            val startPagination = !isLoading && atLastItem &&
                    notAtStart && totalMoreThanVisible && isScrolling

            if(startPagination){
                viewModel.newsPage++
                viewModel.getNews(queryText)
                isScrolling = false
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.nav_menu, menu)

        val search = menu.findItem(R.id.nav_search)
        val searchView = search?.actionView as SearchView
        searchView.queryHint = "Search..."
        searchView

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
//                queryText = query
//                viewModel.newsPage = 1
//                viewModel.getNews(query)
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                queryText = newText
                viewModel.newsPage = 1
                viewModel.getNews(newText)
                return true
            }
        })

        super.onCreateOptionsMenu(menu, inflater)
    }
}