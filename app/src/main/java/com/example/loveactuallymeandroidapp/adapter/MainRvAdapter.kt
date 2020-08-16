package com.example.loveactuallymeandroidapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.loveactuallymeandroidapp.R
import com.example.loveactuallymeandroidapp.utlis.dataClass.Section

class MainRvAdapter(private val sectionList: ArrayList<Section>):RecyclerView.Adapter<MainRvAdapter.SettingViewHolder>() {
    inner class SettingViewHolder(view: View):RecyclerView.ViewHolder(view){
        val sectionTextView:TextView=view.findViewById(R.id.head_tv)
        val childRv:RecyclerView=view.findViewById(R.id.child_rv_set)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SettingViewHolder {
        val itemLayout=LayoutInflater.from(parent.context)
            .inflate(R.layout.item_section_row,parent,false)
        return SettingViewHolder(itemLayout)
    }

    override fun getItemCount(): Int =sectionList.size

    override fun onBindViewHolder(holder: SettingViewHolder, position: Int) {
        val items=sectionList[position].sectionItem
        with(holder){
            sectionTextView.text=sectionList[position].sectionName
            childRv.adapter=ChildRvAdapter(items)
        }

    }
}