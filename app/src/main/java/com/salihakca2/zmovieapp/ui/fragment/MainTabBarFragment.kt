package com.salihakca2.zmovieapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.salihakca2.zmovieapp.R
import com.salihakca2.zmovieapp.databinding.FragmentMainTabBarBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainTabBarFragment : Fragment() {

    private lateinit var binding: FragmentMainTabBarBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_main_tab_bar,container,false)
        setUpTabBar()
        return binding.root
    }

    private fun setUpTabBar() {
        binding.bottomNavBar.setItemSelected(R.id.nav_movie,true)
        binding.bottomNavBar.setOnItemSelectedListener {
        when(it){

            R.id.nav_movie -> childFragmentManager.primaryNavigationFragment?.findNavController()?.navigate(R.id.homePageFragment)
            R.id.nav_release -> childFragmentManager.primaryNavigationFragment?.findNavController()?.navigate(R.id.releasePageFragment)
            R.id.nav_tv -> childFragmentManager.primaryNavigationFragment?.findNavController()?.navigate(R.id.tvPageFragment)
            R.id.nav_tdmb -> childFragmentManager.primaryNavigationFragment?.findNavController()?.navigate(R.id.topRatedFragment)
        }
        }
    }

}