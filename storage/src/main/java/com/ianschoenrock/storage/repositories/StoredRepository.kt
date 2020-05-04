package com.ianschoenrock.storage.repositories

import androidx.room.Entity
import androidx.room.PrimaryKey

    @Entity(tableName = "repositories")
    data class StoredRepository (@PrimaryKey
                                 var id: Int,
                                 var avatarUrl: String,
                                 var name: String,
                                 var description: String,
                                 var language: String)