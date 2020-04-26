package com.ianschoenrock.githubshowcase.ui.repositories

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.ianschoenrock.networking.models.Item
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.base_list_item.view.*

class RepositoryViewHolder (itemView: View): RecyclerView.ViewHolder(itemView) {
    fun setData(item: Item){
        itemView.title_tv.text = item.name
        if(item.owner != null){
            Picasso.get().load(item.owner!!.avatar_url).into(itemView.imageView2)
        }
    }
}