package com.salihakca2.zmovieapp.ui.fragment

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.salihakca2.zmovieapp.R
import com.salihakca2.zmovieapp.databinding.FragmentSplashBinding
import com.salihakca2.zmovieapp.prefs.SessionManager
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class SplashFragment : Fragment() {
    private lateinit var binding: FragmentSplashBinding

    @Inject
    lateinit var sessionManager: SessionManager

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_splash,container,false)

        Handler(Looper.getMainLooper()).postDelayed({
            if (sessionManager.getIsFirstRun()){
                findNavController().navigate(R.id.action_splashFragment_to_mainTabBarFragment)
            }else {
                findNavController().navigate(R.id.homePageFragment)
            }
        },3000)
        return binding.root
    }

}