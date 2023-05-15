package com.hammod736.om.hekma.ui.homePage.ContainerPages.wisdomData

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hammod736.om.hekma.R
import com.hammod736.om.hekma.databinding.AboutWisdomBinding

class AboutWisdom : AppCompatActivity() {
    private lateinit var binding : AboutWisdomBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = AboutWisdomBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val text = intent.getStringExtra("wisdom").toString()
        binding.text.text = text
    }
}