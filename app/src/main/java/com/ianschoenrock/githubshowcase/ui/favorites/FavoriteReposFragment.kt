package com.ianschoenrock.githubshowcase.ui.favorites

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.ianschoenrock.githubshowcase.R

class FavoriteReposFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_favorit_repos, container, false)
    }

}
