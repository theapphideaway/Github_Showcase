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
import com.ianschoenrock.githubshowcase.R

class FollowersFragment : Fragment() {

    private lateinit var followersViewModel: FollowersViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//        followersViewModel =
//            ViewModelProvider(this).get(followersViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_followers, container, false)
        val textView: TextView = root.findViewById(R.id.text_favorites)
        return root
    }
}