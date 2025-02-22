package com.example.keddit

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.keddit.databinding.MainfragmentBinding
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class MainFragment : Fragment() {
    private var _binding: MainfragmentBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: NewsAdapter
    private var itemList: MutableList<SimplifiedNews> = mutableListOf()
    private var isLoading = false
    private var currentPage = 1

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = MainfragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = NewsAdapter(itemList)
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        binding.recyclerView.adapter = adapter

        binding.recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                val layoutManager = recyclerView.layoutManager as LinearLayoutManager
                val totalItemCount = layoutManager.itemCount
                val lastVisibleItem = layoutManager.findLastVisibleItemPosition()
                if (!isLoading && totalItemCount <= (lastVisibleItem + 3)) {
                    currentPage++
                    fetchPosts()
                    isLoading = true
                }
            }
        })

        fetchPosts()
    }

    private fun fetchPosts() {
        RetroConnection.api.getPosts()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ redditResponse ->
                val posts = redditResponse.data.children.map { child ->
                    SimplifiedNews(
                        image = child.data.thumbnail,
                        title = child.data.title,
                        author = child.data.author,
                        time = child.data.created_utc.toLong(),
                        numComments = child.data.num_comments
                    )
                }

                posts.forEach { post ->
                    Log.d("DEBUG", "Title: ${post.title}, Author: ${post.author}")
                }

                itemList.addAll(posts)
                adapter.notifyDataSetChanged()
                isLoading = false
            }, { error ->
                Log.e("DEBUG", "Network error", error)
                isLoading = false
            })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
