package com.ianschoenrock.storage.users

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UsersDao {

    @Insert
    fun insert(repo: StoredUser)

    @get:Query("SELECT * FROM users")
    val allUsers: LiveData<List<StoredUser>>

    @Query("DELETE FROM users")
    fun deleteAll()

}