package com.ianschoenrock.githubshowcase.ui.followers

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ianschoenrock.githubshowcase.R
import com.ianschoenrock.networking.models.Item
import com.ianschoenrock.networking.models.followers.Follower

class FollowersAdapter: RecyclerView.Adapter<FollowersViewHolder>() {

    var followersList = listOf<Follower>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FollowersViewHolder {
        val inflator = LayoutInflater.from(parent.context).inflate(R.layout.base_list_item,parent, false)
        return FollowersViewHolder(inflator)
    }

    override fun getItemCount(): Int = followersList.count()

    override fun onBindViewHolder(holder: FollowersViewHolder, position: Int) {
        holder.setData(followersList[position])

    }

    fun setFollowers(followers: List<Follower>){
        followersList = followers
        notifyDataSetChanged()
    }
}