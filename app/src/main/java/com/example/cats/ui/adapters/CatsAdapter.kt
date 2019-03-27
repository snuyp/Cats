package com.example.cats.ui.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.cats.R
import com.example.cats.mvp.model.Cats
import java.util.ArrayList

class CatsAdapter (private val cats : ArrayList<Cats>) : RecyclerView.Adapter<RatesViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RatesViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val itemView = inflater.inflate(R.layout.card_cats, parent, false)
        return RatesViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: RatesViewHolder, position: Int) {
        Glide.with(holder.itemView.context)
            .load(cats[position].url)
            .apply(RequestOptions().placeholder(R.drawable.ic_filter_hdr_black_24dp))
            .error(R.drawable.ic_error_black_24dp)
            .into(holder.catImage)
    }
    override fun getItemCount(): Int = cats.size
}
class RatesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
{
    var catImage : ImageView = itemView.findViewById(R.id.cats_image)
}