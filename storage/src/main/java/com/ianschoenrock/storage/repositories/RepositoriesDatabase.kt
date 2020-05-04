package com.ianschoenrock.storage.repositories

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [StoredRepository::class], version = 1, exportSchema = false)
abstract class RepositoriesDatabase: RoomDatabase() {

    abstract fun repositoriesDao(): RepositoriesDao

    companion object{
        private var favoriteRoomInstance: RepositoriesDatabase? = null
        fun getDatabase(context: Context): RepositoriesDatabase?{
            if(favoriteRoomInstance == null){
                synchronized(RepositoriesDatabase::class.java){
                    if (favoriteRoomInstance == null){
                        favoriteRoomInstance = Room.databaseBuilder(context.applicationContext,
                            RepositoriesDatabase::class.java, "repositories_database").build()
                    }
                }
            }
            return favoriteRoomInstance
        }
    }
}