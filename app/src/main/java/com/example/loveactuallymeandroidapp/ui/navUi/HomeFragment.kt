package com.example.loveactuallymeandroidapp.ui.navUi

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast

import com.example.loveactuallymeandroidapp.BottomSheetFragment
import com.example.loveactuallymeandroidapp.R
import com.example.loveactuallymeandroidapp.ui.LikeYouActivity
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.android.synthetic.main.bottom_sheet_layout.*
import kotlinx.android.synthetic.main.bottom_sheet_layout.view.*


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class HomeFragment : Fragment(), View.OnClickListener {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val frag = inflater.inflate(R.layout.fragment_home, container, false)
        val filterButton = frag.findViewById<ImageView>(R.id.filter_img)
        filterButton.setOnClickListener {
            val bottomSheetDialog=BottomSheetDialog(requireContext())
            bottomSheetDialog.setContentView(R.layout.bottom_sheet_layout)
            bottomSheetDialog.setCanceledOnTouchOutside(true)
            val btn:Button? =bottomSheetDialog.findViewById(R.id.button)
            val btn1:Button?=bottomSheetDialog.findViewById(R.id.button2)
            val btn2:Button?=bottomSheetDialog.findViewById(R.id.button3)

            btn?.setOnClickListener(this)
            btn1?.setOnClickListener(this)
            btn2?.setOnClickListener(this)
            bottomSheetDialog.show()
        }
        val likeButton=frag.findViewById<ImageView>(R.id.like_img)
        likeButton.setOnClickListener {
            startActivity(Intent(context, LikeYouActivity::class.java))
        }
        return frag
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HomeFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onClick(view: View) {
        if (view.id==R.id.button){
            view.setBackgroundColor(resources.getColor(R.color.pink))
            view.button.setTextColor(Color.WHITE)
        }
        if (view.id==R.id.button2){
            view.setBackgroundColor(resources.getColor(R.color.pink))
            view.button2.setTextColor(Color.WHITE)
        }
        if (view.id==R.id.button3){
            view.setBackgroundColor(resources.getColor(R.color.pink))
            view.button3.setTextColor(Color.WHITE)
        }
    }
}