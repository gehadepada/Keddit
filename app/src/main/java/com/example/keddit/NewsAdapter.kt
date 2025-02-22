package com.example.keddit

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.keddit.databinding.NewsItemBinding

class NewsAdapter(private val itemList: List<SimplifiedNews>) : RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image: ImageView = itemView.findViewById(R.id.imageView)
        val title: TextView = itemView.findViewById(R.id.textView)
        val author: TextView = itemView.findViewById(R.id.xauthor)
        val time: TextView = itemView.findViewById(R.id.xtime)
        val comments: TextView = itemView.findViewById(R.id.comment)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.news_item, parent, false)
        return NewsViewHolder(view)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val item = itemList[position]


        // Use Glide to load images
        Glide.with(holder.image.context)
            .load(item.image)
            .into(holder.image)

        holder.title.text = item.title
        holder.author.text = item.author
        holder.time.text = item.time.toString() // Format as needed
        holder.comments.text = item.numComments.toString()
    }

    override fun getItemCount(): Int = itemList.size
}
