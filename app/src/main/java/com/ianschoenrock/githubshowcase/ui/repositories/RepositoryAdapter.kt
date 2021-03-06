package com.ianschoenrock.githubshowcase.ui.repositories

import com.ianschoenrock.githubshowcase.R

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ianschoenrock.githubshowcase.ui.followers.FollowersViewHolder
import com.ianschoenrock.networking.models.Item
import com.ianschoenrock.networking.models.followers.Follower

class RepositoryAdapter(private val viewModel: RepositoriesViewModel): RecyclerView.Adapter<RepositoryViewHolder>() {

    var repositoryList = listOf<Item>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepositoryViewHolder {
        val inflater = LayoutInflater.from(parent.context).inflate(R.layout.base_list_item, parent, false)
        return RepositoryViewHolder(inflater)
    }

    override fun getItemCount()= repositoryList.count()

    override fun onBindViewHolder(holder: RepositoryViewHolder, position: Int) {
        holder.setData(repositoryList[position], viewModel)
        holder.itemView.setOnClickListener {
            println("You clicked: $position")
        }
    }

    fun setRepositories(repositories: List<Item>){
        repositoryList = repositories
        notifyDataSetChanged()
    }

}