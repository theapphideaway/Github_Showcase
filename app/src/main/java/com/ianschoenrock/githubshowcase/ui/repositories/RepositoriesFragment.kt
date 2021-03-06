package com.ianschoenrock.githubshowcase.ui.repositories

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ianschoenrock.githubshowcase.R

class RepositoriesFragment : Fragment() {

    lateinit var repositoriesViewModel: RepositoriesViewModel
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_repositories, container, false).apply {
            recyclerView = findViewById(R.id.repository_rv)
            initializeRepositoryList()
        }
    }

    private fun initializeRepositoryList(){

        repositoriesViewModel = ViewModelProvider(this@RepositoriesFragment).get(RepositoriesViewModel::class.java)
        val baseAdapter = RepositoryAdapter(repositoriesViewModel)
        recyclerView.adapter = baseAdapter
        recyclerView.layoutManager = LinearLayoutManager(context)
        repositoriesViewModel.repositories.observe(viewLifecycleOwner, Observer{repos ->
            repos?.let{
                baseAdapter.setRepositories(repos.items)
            }
        })
        repositoriesViewModel.getRepositories()
    }

}