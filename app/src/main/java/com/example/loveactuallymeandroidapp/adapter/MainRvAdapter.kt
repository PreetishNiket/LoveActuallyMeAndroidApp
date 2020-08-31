package com.example.loveactuallymeandroidapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.loveactuallymeandroidapp.R
import com.example.loveactuallymeandroidapp.dataClass.Section

class MainRvAdapter(private val context:Context,private val sectionList: ArrayList<Section>):RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    companion object{
        const val TYPE_ITEM = 1
        const val TYPE_FOOT = 2
    }
    inner class SettingItemViewHolder(view: View):RecyclerView.ViewHolder(view){
        val sectionTextView:TextView=view.findViewById(R.id.head_tv)
        val childRv:RecyclerView=view.findViewById(R.id.child_rv_set)
    }
    inner class SettingFooterViewHolder(view: View):RecyclerView.ViewHolder(view){
            val logOutBtn:Button=view.findViewById(R.id.sign_up_button)
            val deleteBtn:Button=view.findViewById(R.id.delete_button)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):RecyclerView.ViewHolder {
        return when(viewType){
            TYPE_ITEM->{
                val itemLayout=LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_section_row,parent,false)
                SettingItemViewHolder(itemLayout)
            }
            TYPE_FOOT->{
                val itemLayout=LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_footer_settings,parent,false)
                SettingFooterViewHolder(itemLayout)
            }
            else ->throw IllegalArgumentException("Invalid View Type")
        }
    }

    override fun getItemCount(): Int =sectionList.size+1

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is SettingItemViewHolder){
            val itemHolder: SettingItemViewHolder = holder
            val items=sectionList[position].sectionItem
            with(itemHolder){
                sectionTextView.text=sectionList[position].sectionName
                childRv.adapter=ChildRvAdapter(items)
            }
        }
        if (holder is SettingFooterViewHolder){
            val footerHolder: SettingFooterViewHolder = holder
            footerHolder.logOutBtn.setOnClickListener {
                Toast.makeText(context, "Log out", Toast.LENGTH_SHORT).show()
            }
           footerHolder.deleteBtn.setOnClickListener {
               Toast.makeText(context, "Delete Account", Toast.LENGTH_SHORT).show()
           }
        }
    }

    override fun getItemViewType(position: Int): Int {
        if (isMyFooter(position)) {
            return TYPE_FOOT
        }
        return TYPE_ITEM
    }

    private fun isMyFooter(position: Int): Boolean {
        return position == sectionList.size
    }
}