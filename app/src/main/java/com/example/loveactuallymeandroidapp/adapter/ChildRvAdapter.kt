package com.example.loveactuallymeandroidapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.loveactuallymeandroidapp.R

class ChildRvAdapter(private val items:ArrayList<String>):RecyclerView.Adapter<ChildRvAdapter.ChildViewHolder>() {
    inner class ChildViewHolder(view: View):RecyclerView.ViewHolder(view){
        val tv:TextView=view.findViewById(R.id.item_tv)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChildViewHolder {
        val itemLayout=LayoutInflater.from(parent.context)
            .inflate(R.layout.item_section_child,parent,false)
        return ChildViewHolder(itemLayout)
    }

    override fun getItemCount(): Int =items.size

    override fun onBindViewHolder(holder: ChildViewHolder, position: Int) {
        with(holder){
            tv.text=items[position]
        }
    }
}