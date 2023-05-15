package com.hammod736.om.hekma.ui.homePage.ContainerPages

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hammod736.om.hekma.databinding.SettingsBinding
import com.hammod736.om.hekma.ui.homePage.Container
import com.zeugmasolutions.localehelper.Locales
import java.util.Locale

class SettingsW : Fragment() {
    private lateinit var _binding : SettingsBinding
    private val binding get() = _binding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        _binding = SettingsBinding.inflate(inflater,container,false)
        val a = requireActivity() as Container
        if (Locale.getDefault().displayLanguage.toString() == "العربية"){
            binding.apply {
                back1.rotation = 180F
                back2.rotation = 180F
                back3.rotation = 180F
                imageView2.rotation = 180F
                binding.arabicRadio.isChecked = true
            }
        }else{
            binding.apply {
                back1.rotation = 0F
                back2.rotation = 0F
                back3.rotation = 0F
                imageView2.rotation = 0F
                binding.englishRadio.isChecked = true

            }
        }
        binding.darkSwitch.setOnCheckedChangeListener{ compoundButton, b ->
        }
        binding.englishRadio.setOnCheckedChangeListener {compoundButton, b ->
            if (b){
                a.updateLocale(Locales.English)
            }
        }
        binding.arabicRadio.setOnCheckedChangeListener { compoundButton, b ->
            if (b){
                a.updateLocale(Locales.Arabic)
            }
        }
        return binding.root
    }
}