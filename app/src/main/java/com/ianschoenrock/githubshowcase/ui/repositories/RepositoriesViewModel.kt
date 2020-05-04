package com.ianschoenrock.githubshowcase.ui.repositories

import android.app.Application
import android.os.AsyncTask
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ianschoenrock.networking.models.Repository
import com.ianschoenrock.networking.services.RepositoryService
import com.ianschoenrock.storage.repositories.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch

class RepositoriesViewModel(application: Application): AndroidViewModel(application) {

    val repository = RepositoryService()

    val repositories = MutableLiveData<Repository>()

    val repositoriesStored: LiveData<List<StoredRepository>>
    private val repositoriesDao: RepositoriesDao

    init {
        val favoritesDb = RepositoriesDatabase.getDatabase(application)
        repositoriesDao = favoritesDb!!.repositoriesDao()
        repositoriesStored = repositoriesDao.allRepositories
    }

//    fun deleteAll(){
//        DeleteAsyncTask(repositoriesDao).execute()
//    }



    fun getRepositories() {
        MainScope().launch(Dispatchers.Main) {
            val repositoriesResponse = repository.getRepositories()
                .getRepositoriesResponseAsync("Android").await()

            repositories.postValue(repositoriesResponse)
        }
    }

    fun insertRepository(repo: StoredRepository){
        MainScope().launch(Dispatchers.Main) {
            repositoriesDao.insert(repo)
        }
    }

    fun deleteRepository(repo: StoredRepository){
        MainScope().launch(Dispatchers.Main) {
            repositoriesDao.deleteAll()
        }
    }

    companion object {
        private class InsertAsyncTask(private val favoritesDao: RepositoriesDao) :
            AsyncTask<StoredRepository, Void, Void>() {
            override fun doInBackground(vararg repos: StoredRepository): Void? {
                favoritesDao.insert(repos[0])
                return null
            }

        }

//        private class DeleteAsyncTask(private val favoritesDao: FavoritesDao) :
//            AsyncTask<StoredRepository, Void, Void>() {
//            override fun doInBackground(vararg repos: StoredRepository): Void? {
//                favoritesDao.deleteAll()
//                return null
//            }
//
//        }


    }
}