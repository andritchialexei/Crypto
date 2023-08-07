package com.example.crypto

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.crypto.databinding.ActivityMainBinding
import com.example.crypto.ui.crypto.CryptoFragment
import com.example.crypto.ui.watchlist.WatchListFragment
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val mainPagerAdapter = MainPagerAdapter(this)

        binding.pager.adapter = mainPagerAdapter
        TabLayoutMediator(binding.tabLayout, binding.pager) { tab, position ->
            val tabList = listOf("Crypto", "WatchList")
            tab.text = tabList[position]
        }.attach()
    }

    private class MainPagerAdapter(fm: FragmentActivity) : FragmentStateAdapter(fm) {
        val cryptoFragment: CryptoFragment = CryptoFragment()
        val watchListFragment: WatchListFragment = WatchListFragment()

        override fun createFragment(position: Int): Fragment {
            return if (position == 0) {
                cryptoFragment
            } else watchListFragment
        }

        override fun getItemCount(): Int {
            return 2
        }
    }
}