package com.hammod736.om.hekma.ui.homePage.search

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.app.ActivityOptionsCompat
import androidx.core.util.Pair
import com.hammod736.om.hekma.R
import com.hammod736.om.hekma.databinding.MainSearchPageBinding
import com.hammod736.om.hekma.databinding.SearchWisdomBinding
import com.hammod736.om.hekma.databinding.SettingsBinding
import com.hammod736.om.hekma.ui.homePage.Container
import com.hammod736.om.hekma.ui.homePage.ContainerPages.SettingsW
import com.hammod736.om.hekma.ui.homePage.search.searchFragments.MainSearchPage
import com.zeugmasolutions.localehelper.Locales
import java.util.Locale

class SearchWisdom : AppCompatActivity() {
    private lateinit var binding : SearchWisdomBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = SearchWisdomBinding.inflate(layoutInflater)
        setContentView(binding.root)
        if (Locale.getDefault().language.toString() == "en"){
            binding.backImage.rotation = 180F
            binding.search.rotation = 270F
        } else if(Locale.getDefault().language.toString() == "ar"){
            binding.backImage.rotation = 0F
            binding.search.rotation = 0F
        }
        binding.textSearch.requestFocus()
        binding.goBack.setOnClickListener {
            this.onBackPressed()
        }
    }

}