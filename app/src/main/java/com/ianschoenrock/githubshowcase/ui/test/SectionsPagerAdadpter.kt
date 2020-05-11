package com.ianschoenrock.githubshowcase.ui.test

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.ianschoenrock.githubshowcase.R
import com.ianschoenrock.githubshowcase.ui.favorites.FavoriteReposFragment
import com.ianschoenrock.githubshowcase.ui.favorites.FavoriteUsersFragment


class SectionsPagerAdapter( fm: FragmentManager)
    : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return when (position){
            0-> FavoriteUsersFragment()
            else-> FavoriteReposFragment()
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            0 -> "Users"
            else ->  "Repositories"
        }
    }

    override fun getCount(): Int {
        return 2
    }
}