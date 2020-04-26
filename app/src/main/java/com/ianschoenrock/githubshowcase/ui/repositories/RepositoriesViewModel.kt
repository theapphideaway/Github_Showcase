package com.ianschoenrock.githubshowcase.ui.repositories

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ianschoenrock.networking.models.Repository
import com.ianschoenrock.networking.services.RepositoryService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch

class RepositoriesViewModel : ViewModel() {

    val repository = RepositoryService()

    val repositories = MutableLiveData<Repository>()

    fun getRepositories() {
        MainScope().launch(Dispatchers.Main) {
            val repositoriesResponse = repository.getRepositories()
                .getRepositoriesResponseAsync("Android").await()

            repositories.postValue(repositoriesResponse)
        }
    }
}