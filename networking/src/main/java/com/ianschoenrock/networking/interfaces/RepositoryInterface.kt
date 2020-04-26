package com.ianschoenrock.networking.interfaces

import com.ianschoenrock.networking.models.Repository
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface RepositoryInterface {
    @GET("repositories")
    fun getRepositoriesResponse(
        @Query("q") searchItem: String
    ): Deferred<Repository>
}