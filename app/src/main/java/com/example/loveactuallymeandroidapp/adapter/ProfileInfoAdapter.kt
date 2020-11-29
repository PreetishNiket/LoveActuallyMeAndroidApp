package com.example.loveactuallymeandroidapp.adapter

import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.RecyclerView
import com.example.loveactuallymeandroidapp.R
import com.example.loveactuallymeandroidapp.dataClass.EdiTxt
import com.example.loveactuallymeandroidapp.dataClass.ProfileInfo

class ProfileInfoAdapter(private val list: ArrayList<ProfileInfo>) :RecyclerView.Adapter<RecyclerView.ViewHolder>() {
//    ,private val btn:Button
    private lateinit var values:ArrayList<EdiTxt>

    companion object{
        const val TYPE_ITEM = 1
        const val TYPE_HEAD = 0
    }
    inner class InfoViewHolder(view: View):RecyclerView.ViewHolder(view){
            val title:TextView=view.findViewById(R.id.title_tv)
            val details:EditText=view.findViewById(R.id.details)
    }
    inner class HeaderViewHolder(view: View):RecyclerView.ViewHolder(view){
            val info:EditText=view.findViewById(R.id.info_et)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when(viewType){
            TYPE_ITEM ->{
                val itemLayout=LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_item,parent,false)
                InfoViewHolder(itemLayout)
            }
            TYPE_HEAD ->{
                val itemLayout=LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_head,parent,false)
                HeaderViewHolder(itemLayout)
            }
            else ->throw IllegalArgumentException("Invalid View Type")
        }
    }

    override fun getItemCount()= list.size

    override fun onBindViewHolder(holder:  RecyclerView.ViewHolder, position: Int) {
        if (holder is InfoViewHolder){
            holder.title.text= list[position].title
            holder.details.hint=list[position].details

//           values= arrayListOf(EdiTxt(holder.details.text.toString()))
//            for (i in values){
//                holder.details.setText(values.get(i).toString())
//            }
           holder.details.addTextChangedListener(object :TextWatcher{
               override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

               }

               override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

               }

               override fun afterTextChanged(p0: Editable?) {

               }
           })
        }
        if (holder is HeaderViewHolder){
                holder.info.hint=list[0].details
        }

    }
    override fun getItemViewType(position: Int): Int {
        if (isMyHeader(position)) {
            return TYPE_HEAD
        }
        return TYPE_ITEM
    }
    private fun isMyHeader(position: Int): Boolean {
        return position == 0
    }
    fun updateData(){
//        btn.setOnClickListener {
//
//        }
    }
}