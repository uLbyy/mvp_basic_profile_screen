package com.haslan.profilescreen.ui.profilescreen

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.haslan.profilescreen.R
import com.haslan.profilescreen.data.model.response.MovieItem
import kotlinx.android.synthetic.main.item_movie.view.*

class MoviesAdapter : RecyclerView.Adapter<MoviesAdapter.ViewHolder>() {

    private var movies: List<MovieItem> = emptyList()

    fun setMovies(movies: List<MovieItem>) {
        this.movies = movies
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movie = movies[position]

        holder.textTitle.text = movie.name

        Glide.with(holder.imageMovieBg.context)
            .load(movie.profilePictureUrl)
            .into(holder.imageMovieBg)

        holder.textLikeCount.text = movie.likeCount.toString()

        val resId = if (movie.isLiked) {
            R.drawable.ic_like
        } else {
            R.drawable.ic_unlike
        }

        Glide.with(holder.imageLike.context)
            .load(resId)
            .into(holder.imageLike)
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textTitle = view.text_title
        val imageMovieBg = view.image_movie_bg
        val textLikeCount = view.text_like_count
        val imageLike = view.image_like
    }

}