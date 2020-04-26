package com.ianschoenrock.githubshowcase.ui.followers

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ianschoenrock.githubshowcase.R
import com.ianschoenrock.githubshowcase.ui.repositories.RepositoriesViewModel
import com.ianschoenrock.githubshowcase.ui.repositories.RepositoryAdapter

class FollowersFragment : Fragment() {

    private lateinit var followersViewModel: FollowersViewModel
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_followers, container, false).apply {
        recyclerView = findViewById(R.id.follower_rv)
        initializeFollowersList()
        }
    }

    private fun initializeFollowersList(){
        followersViewModel = ViewModelProvider(this@FollowersFragment).get(
            FollowersViewModel::class.java)
        val baseAdapter = FollowersAdapter()
        recyclerView.adapter = baseAdapter
        recyclerView.layoutManager = LinearLayoutManager(context)
        followersViewModel.followers.observe(viewLifecycleOwner, Observer{repos ->
            repos?.let{
                baseAdapter.setFollowers(repos)
            }
        })
        followersViewModel.getFollowers("theapphideaway")
    }
}