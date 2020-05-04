package com.ianschoenrock.storage.repositories

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface RepositoriesDao {

    @Insert
    fun insert(repo: StoredRepository)

    @get:Query("SELECT * FROM repositories")
    val allRepositories: LiveData<List<StoredRepository>>

    @Query("DELETE FROM repositories")
    fun deleteAll()

}