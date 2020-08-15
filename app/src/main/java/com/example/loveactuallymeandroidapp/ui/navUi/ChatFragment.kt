package com.example.loveactuallymeandroidapp.ui.navUi

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.loveactuallymeandroidapp.R
import com.example.loveactuallymeandroidapp.adapter.ChatHorizontalAdapter
import com.example.loveactuallymeandroidapp.adapter.ChatVerticalAdapter
import com.example.loveactuallymeandroidapp.utlis.Chat1
import com.example.loveactuallymeandroidapp.utlis.Chat2
import kotlinx.android.synthetic.main.fragment_chat.view.*

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class ChatFragment : Fragment() {

    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }
    val list1= arrayListOf(
        Chat1(R.drawable.ex_img,"Cody Fisher","That’s hilarious, really · July 16"),
        Chat1(R.drawable.ex_img1,"Penna Fox","Why? · July 16"),
        Chat1(R.drawable.ex_img2,"Rose Martin","Hey · July 16"),
        Chat1(R.drawable.ex_img,"Hell Gay","Nice photo! Where are you? · July 16"),
        Chat1(R.drawable.ex_img2,"Rose Martin","Hey Handsome · July 16"),
        Chat1(R.drawable.ex_img2," Debi Kim","Hey dude! How’s it going? · July 16"))
    val list2= arrayListOf(
        Chat2(R.drawable.ex_img,"Cody Fisher"),
        Chat2(R.drawable.ex_img1,"Penna Fox"),
        Chat2(R.drawable.ex_img2,"Rose Martin"),
        Chat2(R.drawable.ex_img,"Hell Gay"),
        Chat2(R.drawable.ex_img2,"Rose Martin"),
        Chat2(R.drawable.ex_img2," Debi Kim"))

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val v= inflater.inflate(R.layout.fragment_chat, container, false)
        v.rv_v.layoutManager=LinearLayoutManager(v.context)
        v.rv_v.adapter=ChatVerticalAdapter(v.context,list1)
        v.rv_h.layoutManager=LinearLayoutManager(v.context,LinearLayoutManager.HORIZONTAL,false)
        v.rv_h.adapter=ChatHorizontalAdapter(v.context,list2)
        v.back1.setOnClickListener{
            Toast.makeText(v.context, "No use", Toast.LENGTH_SHORT).show()
        }
        return v
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ChatFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ChatFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}