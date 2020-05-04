package com.ianschoenrock.storage.users

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [StoredUser::class], version = 1, exportSchema = false)
abstract class UsersDatabase: RoomDatabase()  {

    abstract fun usersDao(): UsersDao

    companion object{
        private var userRoomInstance: UsersDatabase? = null
        fun getDatabase(context: Context): UsersDatabase?{
            if(userRoomInstance == null){
                synchronized(UsersDatabase::class.java){
                    if (userRoomInstance == null){
                        userRoomInstance = Room.databaseBuilder<UsersDatabase>(context.applicationContext,
                            UsersDatabase::class.java, "users_database").build()
                    }
                }
            }
            return userRoomInstance
        }
    }
}
