package com.ianschoenrock.githubshowcase.ui.followers

import android.graphics.Color
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.ianschoenrock.networking.models.followers.Follower
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.base_list_item.view.*

class FollowersViewHolder (itemView: View): RecyclerView.ViewHolder(itemView) {
    fun setData(follower: Follower){
        itemView.title_tv.text = follower.login
        if(follower.avatar_url != null){
            Picasso.get().load(follower.avatar_url).into(itemView.imageView2)
        }
        itemView.favorites_btn.setOnClickListener {
            if(follower.isSelected){
                itemView.favorites_btn.colorFilter = null

                follower.isSelected = false
            } else{
                itemView.favorites_btn.setColorFilter(Color.rgb(255, 80, 80))
                follower.isSelected = true
            }
        }
    }
}