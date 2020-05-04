package com.ianschoenrock.storage.users

import androidx.room.Entity
import androidx.room.PrimaryKey

    @Entity(tableName = "users")
    data class StoredUser (@PrimaryKey
                                 var id: Int,
                                 var avatarUrl: String,
                                 var login: String)
