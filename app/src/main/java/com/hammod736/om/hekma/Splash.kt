package com.hammod736.om.hekma

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.google.firebase.firestore.FirebaseFirestore
import com.hammod736.om.hekma.databinding.SplashBinding
import com.hammod736.om.hekma.languages.BaseActivity
import com.hammod736.om.hekma.ui.homePage.Container

class Splash : BaseActivity(){
    private lateinit var binding: SplashBinding
    private lateinit var db : FirebaseFirestore
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = SplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
        Handler().postDelayed({
            startActivity(Intent(this,Container::class.java))
            finish()
        },2500)
    }
}