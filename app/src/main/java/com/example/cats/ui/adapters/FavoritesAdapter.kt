package com.example.cats.ui.adapters

import android.content.Context
import android.support.design.widget.FloatingActionButton
import android.support.v7.app.AlertDialog
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.cats.App
import com.example.cats.R
import com.example.cats.common.DownloadAndSaveImageTask
import com.example.cats.db.CatsRepository
import com.example.cats.db.FavoriteCats
import javax.inject.Inject

class FavoritesAdapter (private val cats: List<FavoriteCats>) : RecyclerView.Adapter<FavoritesViewHolder>(){

    @Inject
    lateinit var catsRepository: CatsRepository

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoritesViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val itemView = inflater.inflate(R.layout.card_cats, parent, false)
        App.component.inject(this)
        return FavoritesViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: FavoritesViewHolder, position: Int) {
        Glide.with(holder.itemView.context)
            .load(cats[position].url)
            .apply(RequestOptions().placeholder(R.drawable.ic_filter_hdr_black_24dp))
            .error(R.drawable.ic_error_black_24dp)
            .into(holder.catImage)

        holder.itemView.setOnLongClickListener {
            AlertDialog.Builder(holder.itemView.context).apply {
                setMessage(holder.itemView.context.getString(R.string.want_delete))
                setPositiveButton(context.getString(R.string.no)) { _, _ -> }

                setNegativeButton(context.getString(R.string.yes)) { _, _ ->
                    catsRepository.removeFromFavorites(cats[position])

                    Toast.makeText(
                        holder.itemView.context,
                        holder.itemView.context.getString(R.string.delete),
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }.show()

            true
        }
        holder.downloadButton.setOnClickListener {
            DownloadAndSaveImageTask(holder.itemView.context).execute(cats[position].url)
        }

    }
    override fun getItemCount(): Int = cats.size

}

class FavoritesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    var catImage: ImageView = itemView.findViewById(R.id.cats_image)
    var downloadButton : FloatingActionButton = itemView.findViewById(R.id.btnDownload)
}