package com.example.loveactuallymeandroidapp.adapter

import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.graphics.Color
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.crowdfire.cfalertdialog.CFAlertDialog
import com.example.loveactuallymeandroidapp.R
import com.example.loveactuallymeandroidapp.dataClass.Section
import com.example.loveactuallymeandroidapp.ui.auth.SignUpActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class MainRvAdapter(private val context:Context,private val sectionList: ArrayList<Section>):RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    companion object{
        const val TYPE_ITEM = 1
        const val TYPE_FOOT = 2
    }
    private val auth by lazy {
        FirebaseAuth.getInstance()
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
                val builder=CFAlertDialog.Builder(context)
                    .setDialogBackgroundColor(Color.parseColor("#303030"))
                    .setDialogStyle(CFAlertDialog.CFAlertStyle.ALERT)
                    .setTitle("Are You Sure?").setTextColor(Color.parseColor("#EC6273")).setTextGravity(Gravity.CENTER_HORIZONTAL)
                    .setCancelable(true)
                    .addButton("LOG OUT",Color.parseColor("#FFFFFF"),Color.parseColor("#EC6273")
                    ,CFAlertDialog.CFAlertActionStyle.POSITIVE,
                        CFAlertDialog.CFAlertActionAlignment.JUSTIFIED
                    ) { dialog, i ->
                        Toast.makeText(context, "Log out", Toast.LENGTH_SHORT).show()
                        auth.signOut()
                        val intent=Intent(context,SignUpActivity::class.java)
                        intent.flags=Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP
                        context.startActivity(intent)
                        dialog.dismiss()
                    }
                    .addButton("CANCEL",Color.parseColor("#FFFFFF"),Color.parseColor("#db3a2c")
                        ,CFAlertDialog.CFAlertActionStyle.NEGATIVE,
                        CFAlertDialog.CFAlertActionAlignment.JUSTIFIED
                    ) { dialog, i ->
                        Toast.makeText(context, "Cancel", Toast.LENGTH_SHORT).show()
                        dialog.dismiss()
                    }
                builder.show()
            }
           footerHolder.deleteBtn.setOnClickListener {
               Toast.makeText(context, "Delete Account", Toast.LENGTH_SHORT).show()
               val builder=CFAlertDialog.Builder(context)
                   .setDialogBackgroundColor(Color.parseColor("#303030"))
                   .setDialogStyle(CFAlertDialog.CFAlertStyle.ALERT)
                   .setTitle("So Soon!!").setTextColor(Color.parseColor("#EC6273")).setTextGravity(Gravity.CENTER_HORIZONTAL)
                   .setCancelable(true)
                   .addButton("DELETE",Color.parseColor("#FFFFFF"),Color.parseColor("#EC6273")
                       ,CFAlertDialog.CFAlertActionStyle.POSITIVE,
                       CFAlertDialog.CFAlertActionAlignment.JUSTIFIED
                   ) { dialog, i ->
//
                       FirebaseDatabase.getInstance().reference.child("Users").child(auth.currentUser!!.uid).removeValue()
                       auth.currentUser!!.delete().addOnCompleteListener {
                           val intent = Intent(context, SignUpActivity::class.java)
                           intent.flags =
                               Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP
                           context.startActivity(intent)
                       }
                       dialog.dismiss()
                   }
                   .addButton("No Stay",Color.parseColor("#FFFFFF"),Color.parseColor("#db3a2c")
                       ,CFAlertDialog.CFAlertActionStyle.NEGATIVE,
                       CFAlertDialog.CFAlertActionAlignment.JUSTIFIED
                   ) { dialog, i ->
                       dialog.dismiss()
                   }
               builder.show()
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