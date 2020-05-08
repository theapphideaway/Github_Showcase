package com.ianschoenrock.githubshowcase.ui.followers

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ianschoenrock.networking.models.followers.Follower
import com.ianschoenrock.networking.services.FollowerService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch

class FollowersViewModel : ViewModel() {

    val followers = MutableLiveData<List<Follower>>()

    fun getFollowers(user: String) {
        val follower = FollowerService(user)
        MainScope().launch(Dispatchers.Unconfined) {
            val followersResponse = follower.getFollowers()
                .getFollowersResponseAsync().await()
            followers.postValue(followersResponse)
        }
    }
}