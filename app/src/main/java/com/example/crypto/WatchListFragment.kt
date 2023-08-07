package com.example.crypto

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class WatchListFragment : Fragment() {

    private lateinit var viewModel: WatchListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this).get(WatchListViewModel::class.java)

        return inflater.inflate(R.layout.fragment_watch_list, container, false)
    }
}