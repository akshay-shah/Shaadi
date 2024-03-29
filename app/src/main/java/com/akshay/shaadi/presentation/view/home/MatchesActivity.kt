package com.akshay.shaadi.presentation.view.home

import android.os.Bundle
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.ProgressBar
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.akshay.shaadi.R
import com.akshay.shaadi.domain.getmatches.GetMatchesUseCase
import com.akshay.shaadi.domain.getmatches.Profile
import com.akshay.shaadi.presentation.view.home.adapter.ProfileAdapter
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class MatchesActivity : DaggerAppCompatActivity() {


    @Inject
    lateinit var getMatchesUseCase: GetMatchesUseCase
    private val profileAdapter: ProfileAdapter = ProfileAdapter()
    private lateinit var recyclerView: RecyclerView
    private lateinit var progressBar: ProgressBar
    private lateinit var mViewModel: MatchesActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
        mViewModel.getMatches().observe(this, Observer<List<Profile>> {
            if (it.isNotEmpty()) {
                profileAdapter.list = it
                profileAdapter.notifyDataSetChanged()
            } else {
                Toast.makeText(this, "Error Loading Data", Toast.LENGTH_SHORT).show()
            }
        })
        mViewModel.dataLoading.observe(this, Observer {
            if (it) {
                showProgressBar()
            } else
                hideProgressBar()
        })

    }

    private fun init() {
        recyclerView = findViewById<RecyclerView>(R.id.recyclerViewMatches)
        progressBar = findViewById<ProgressBar>(R.id.progressBar)
        recyclerView.apply {
            adapter = profileAdapter
            layoutManager = LinearLayoutManager(this@MatchesActivity)
        }
        mViewModel = ViewModelProvider(
            this,
            MatchesActivityViewModelFactory(getMatchesUseCase)
        ).get(
            MatchesActivityViewModel::class.java
        )
    }

    private fun showProgressBar() {
        recyclerView.visibility = GONE
        progressBar.visibility = VISIBLE
    }

    private fun hideProgressBar() {
        progressBar.visibility = GONE
        recyclerView.visibility = VISIBLE
    }
}
