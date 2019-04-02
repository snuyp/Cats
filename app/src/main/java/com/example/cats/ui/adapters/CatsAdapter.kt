package com.example.cats.ui.adapters


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
import com.example.cats.mvp.model.Cats
import java.util.*
import javax.inject.Inject

class CatsAdapter(private val cats: ArrayList<Cats>) : RecyclerView.Adapter<CatsViewHolder>(){

    @Inject
    lateinit var catsRepository: CatsRepository

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatsViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val itemView = inflater.inflate(R.layout.card_cats, parent, false)
        App.component.inject(this)
        return CatsViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CatsViewHolder, position: Int) {
        Glide.with(holder.itemView.context)
            .load(cats[position].url)
            .apply(RequestOptions().placeholder(R.drawable.ic_filter_hdr_black_24dp))
            .error(R.drawable.ic_error_black_24dp)
            .into(holder.catImage)

        holder.itemView.setOnClickListener {
            AlertDialog.Builder(holder.itemView.context).apply {
                setMessage(context.getString(R.string.add_favorites))
                setPositiveButton(context.getString(R.string.no)) { _, _ -> }

                setNegativeButton(context.getString(R.string.yes)) { _, _ ->
                    catsRepository.insertCatsIntoFavorites(cats[position])
                    Toast.makeText(
                        holder.itemView.context,
                        context.getString(R.string.added_to_favorites) + " " + cats[position].id,
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }.show()
        }

        holder.downloadButton.setOnClickListener {
            DownloadAndSaveImageTask(holder.itemView.context).execute(cats[position].url)
        }
    }
    override fun getItemCount(): Int = cats.size
}

class CatsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    var catImage: ImageView = itemView.findViewById(R.id.cats_image)
    var downloadButton : FloatingActionButton = itemView.findViewById(R.id.btnDownload)
}