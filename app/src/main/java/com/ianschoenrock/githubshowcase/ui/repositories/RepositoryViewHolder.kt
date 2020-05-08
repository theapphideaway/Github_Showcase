package com.ianschoenrock.githubshowcase.ui.repositories

import android.graphics.Color
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.ianschoenrock.networking.models.Item
import com.ianschoenrock.storage.repositories.StoredRepository
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.base_list_item.view.*

class RepositoryViewHolder (itemView: View): RecyclerView.ViewHolder(itemView) {
    fun setData(item: Item, viewModel: RepositoriesViewModel){
        itemView.title_tv.text = item.name
        if(item.owner != null){
            Picasso.get().load(item.owner!!.avatar_url).into(itemView.imageView2)
        }
        itemView.favorites_btn.setOnClickListener {
            if(item.isSelected){
                itemView.favorites_btn.colorFilter = null
                item.isSelected = false
            } else{
                itemView.favorites_btn.setColorFilter(Color.rgb(255, 80, 80))
                item.isSelected = true
                val storedRepo = StoredRepository(item.id, item.owner!!.avatar_url,
                    item.name, item.description.toString(), item.language)
                viewModel.insertRepository(storedRepo)
            }
        }
    }
}