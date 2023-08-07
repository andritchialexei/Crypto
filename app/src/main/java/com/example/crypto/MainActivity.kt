package com.example.crypto

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mainPagerAdapter = MainPagerAdapter(this)
        val viewPager = findViewById<ViewPager2>(R.id.pager)
        val tabLayout = findViewById<TabLayout>(R.id.tab_layout)

        viewPager.adapter = mainPagerAdapter
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
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