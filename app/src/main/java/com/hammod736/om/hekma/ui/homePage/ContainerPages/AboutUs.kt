package com.hammod736.om.hekma.ui.homePage.ContainerPages

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hammod736.om.hekma.R
import com.hammod736.om.hekma.databinding.AboutUsBinding

class AboutUs : Fragment() {
    private lateinit var _binding : AboutUsBinding
    private val binding get() = _binding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
       _binding = AboutUsBinding.inflate(inflater,container,false)

        return binding.root
    }

}