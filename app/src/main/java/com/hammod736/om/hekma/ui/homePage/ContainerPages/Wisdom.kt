package com.hammod736.om.hekma.ui.homePage.ContainerPages

import android.content.Intent
import android.graphics.drawable.GradientDrawable.Orientation
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityOptionsCompat
import com.hammod736.om.hekma.adapters.WisdomAdapter
import com.hammod736.om.hekma.databinding.WisdomBinding
import com.hammod736.om.hekma.db.DataBase
import com.hammod736.om.hekma.ui.homePage.search.SearchWisdom
import java.util.*

class Wisdom : Fragment() {
    private lateinit var _binding : WisdomBinding
    private val binding get() = _binding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        _binding = WisdomBinding.inflate(inflater,container,false)

        val db = DataBase()
        val adapter = WisdomAdapter(db.getData())
        if (Locale.getDefault().language.toString() == "en"){
            binding.search.rotation = 270F
        }
        binding.recycler.apply {
            binding.recycler.adapter = adapter
            adapter.onClick = { wisdom,card,text->

//                val intent = Intent(requireContext(), AboutWisdom::class.java)
//                intent.putExtra("wisdom",wisdom.body)
//                val option = ActivityOptionsCompat.makeSceneTransitionAnimation(requireActivity(), Pair.create(card,"image_Big"),
//                    Pair.create(text,"title_Big"))
//                startActivity(intent,option.toBundle())
            }
            set3DItem(true)
            setAlpha(true)
            setInfinite(true)
            setIsScrollingEnabled(true)
        }
        binding.searchBtn.setOnClickListener{
            val intent = Intent(requireContext(), SearchWisdom::class.java)
            val option = ActivityOptionsCompat.makeSceneTransitionAnimation(requireActivity(),androidx.core.util.Pair.create(binding.search,"image_Big"))
            startActivity(intent,option.toBundle())
        }
        return binding.root
    }
}