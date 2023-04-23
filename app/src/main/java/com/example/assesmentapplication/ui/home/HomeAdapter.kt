package com.example.assesmentapplication.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.assesmentapplication.databinding.HomeLayoutItemBinding
import com.example.assesmentapplication.model.response.MovieInformation

class HomeAdapter(private var feeds: MutableList<MovieInformation>,
    private val itemClickListener: OnItemClickListener) : RecyclerView.Adapter<HomeAdapter.MovieListViewHolder>() {

    private val items: MutableList<MovieInformation> = arrayListOf()

    inner class MovieListViewHolder(val binding: HomeLayoutItemBinding) :
        ViewHolder(binding.root) {

        fun bind(feed: MovieInformation, clickListener: OnItemClickListener) {
            binding.root.setOnClickListener {
                clickListener.onItemClicked(feed)
            }
            binding.movieInformation = feed
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieListViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        // Inflate the custom layout
        val binding = HomeLayoutItemBinding.inflate(inflater, parent, false)
        // Return a new holder instance
        return MovieListViewHolder(binding)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: MovieListViewHolder, position: Int) {
        val feed = feeds[position]
        holder.bind(feed, itemClickListener)
    }
}

interface OnItemClickListener {
    fun onItemClicked(feeds: MovieInformation)
}