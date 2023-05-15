package com.hammod736.om.hekma.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.hammod736.om.hekma.databinding.WisdomItemBinding
import com.hammod736.om.hekma.models.Wisdom

class WisdomAdapter (private val allWisdom : ArrayList<Wisdom>) : RecyclerView.Adapter<WisdomAdapter.ViewHolder>() {
    var onClick : ((Wisdom,card : CardView,text : TextView) -> Unit)? = null

    inner class ViewHolder (val binding:WisdomItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = WisdomItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val wisdom = allWisdom[position]
        holder.binding.apply {
            wisdomBody.text = wisdom.body
            wisdomCard.setOnClickListener {
                onClick!!.invoke(wisdom,wisdomCard,wisdomBody)
            }
        }
    }
    override fun getItemCount(): Int = allWisdom.size

}