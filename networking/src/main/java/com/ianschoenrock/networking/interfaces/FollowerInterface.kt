package com.ianschoenrock.networking.interfaces

import com.ianschoenrock.networking.models.followers.Follower
import kotlinx.coroutines.Deferred
import retrofit2.http.GET

interface FollowerInterface {
    @GET("followers")
    fun getFollowersResponseAsync(): Deferred<List<Follower>>
}