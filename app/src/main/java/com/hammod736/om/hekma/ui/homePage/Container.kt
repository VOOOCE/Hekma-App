package com.hammod736.om.hekma.ui.homePage

import android.content.Intent
import android.graphics.Color
import android.graphics.ColorFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.Toast
import android.widget.Toolbar
import androidx.core.app.ActivityOptionsCompat
import androidx.core.util.Pair
import androidx.core.view.isVisible
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.hammod736.om.hekma.R
import com.hammod736.om.hekma.databinding.ContainerBinding
import com.hammod736.om.hekma.languages.BaseActivity
import com.hammod736.om.hekma.ui.homePage.search.SearchWisdom
import com.zeugmasolutions.localehelper.LocaleHelperActivityDelegate
import com.zeugmasolutions.localehelper.Locales
import java.util.*

class Container : BaseActivity() {
    private lateinit var binding : ContainerBinding
    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var listener: NavController.OnDestinationChangedListener
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ContainerBinding.inflate(layoutInflater)
        setContentView(binding.root)
        if (Locale.getDefault().language.toString() == "en"){
            binding.navigateIcon.rotation = 360F
        }else if(Locale.getDefault().language.toString() == "ar"){
            binding.navigateIcon.rotation = 0F
        }
        val nav = supportFragmentManager.findFragmentById(R.id.fragment) as NavHostFragment
        navController = nav.navController
        appBarConfiguration = AppBarConfiguration(setOf(R.id.wisdom,R.id.settings,R.id.profile,R.id.aboutUs),binding.mainDrawer as DrawerLayout)
        binding.navigateIcon.setOnClickListener {
            binding.mainDrawer.open()
        }
        listener = NavController.OnDestinationChangedListener { controller, destination, arguments ->
        }
        binding.navigationView.setupWithNavController(navController)


        binding.notifications.setOnClickListener {
            updateLocale(Locales.English)
        }
    }

    override fun onSupportNavigateUp(): Boolean{
        val navController = findNavController(R.id.fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}