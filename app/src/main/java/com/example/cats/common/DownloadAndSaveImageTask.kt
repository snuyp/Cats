package com.example.cats.common

import android.content.Context
import android.graphics.Bitmap
import android.os.AsyncTask
import android.os.Environment
import android.util.Log
import android.widget.Toast
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
import com.bumptech.glide.request.RequestOptions
import com.example.cats.R
import java.io.File
import java.io.FileOutputStream
import java.lang.ref.WeakReference
import java.sql.Timestamp

class DownloadAndSaveImageTask(context: Context) : AsyncTask<String, Unit, Unit>() {
    private var mContext: WeakReference<Context> = WeakReference(context)
    var  isDownloaded: Boolean = false
    override fun doInBackground(vararg params: String?) {
        val url = params[0]
        val timeStamp = Timestamp(System.currentTimeMillis())
        val requestOptions = RequestOptions().override(100)
            .downsample(DownsampleStrategy.CENTER_INSIDE)
            .skipMemoryCache(true)
            .diskCacheStrategy(DiskCacheStrategy.NONE)

        mContext.get()?.let {
            val bitmap = Glide.with(it)
                .asBitmap()
                .load(url)
                .apply(requestOptions)
                .submit()
                .get()

            try {
                var file = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)

                if (!file.exists()) {
                    file.mkdir()
                }
                file = File(file, "kat $timeStamp.jpg")
                val out = FileOutputStream(file)
                bitmap.compress(Bitmap.CompressFormat.JPEG, 85, out)
                out.flush()
                out.close()
                Log.i("Seiggailion", "Image saved.")
                isDownloaded = true
            }catch (e: Exception) {
                isDownloaded = false
                Log.i("Seiggailion", "Failed to save image.")
            }
        }

    }

    override fun onPostExecute(result: Unit?) {
        if(isDownloaded) {
            mContext.get()?.let {
                Toast.makeText(it, it.getString(R.string.download), Toast.LENGTH_SHORT).show()
            }
        } else {
            mContext.get()?.let {
                Toast.makeText(it, it.getString(R.string.failed_to_save_image), Toast.LENGTH_SHORT).show()
            }
        }
    }
}