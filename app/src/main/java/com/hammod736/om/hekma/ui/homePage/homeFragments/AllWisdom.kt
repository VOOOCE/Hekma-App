package com.hammod736.om.hekma.ui.homePage.homeFragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityOptionsCompat
import androidx.core.util.Pair
import com.hammod736.om.hekma.R
import com.hammod736.om.hekma.adapters.WisdomAdapter
import com.hammod736.om.hekma.databinding.AllWisdomsBinding
import com.hammod736.om.hekma.db.DataBase
import com.hammod736.om.hekma.ui.homePage.ContainerPages.wisdomData.AboutWisdom

class AllWisdom : Fragment() {
    private lateinit var _binding : AllWisdomsBinding
    private val binding get() = _binding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
       _binding = AllWisdomsBinding.inflate(inflater,container,false)
        return binding.root
    }
}