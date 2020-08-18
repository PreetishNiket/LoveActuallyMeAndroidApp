package com.example.loveactuallymeandroidapp.ui.navUi

import android.content.Context
import android.content.Intent
import android.content.res.Resources
import android.graphics.Color
import android.graphics.Point
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.*
import android.widget.Button
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.example.loveactuallymeandroidapp.R
import com.example.loveactuallymeandroidapp.ui.other.LikeYouActivity
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.mindorks.placeholderview.SwipeDecor
import com.mindorks.placeholderview.SwipePlaceHolderView
import kotlinx.android.synthetic.main.bottom_sheet_layout.view.*
import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment : Fragment(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val frag = inflater.inflate(R.layout.fragment_home, container, false)
        val filterButton = frag.findViewById<ImageView>(R.id.filter_img)
        filterButton.setOnClickListener {
           bottomSheet()
        }
        val likeButton=frag.findViewById<ImageView>(R.id.like_img)
        likeButton.setOnClickListener {
            startActivity(Intent(context, LikeYouActivity::class.java))
        }

        return frag
    }

//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        val bottomMargin: Int =
//        val windowSize: Point = getDisplaySize(requireActivity().windowManager)
//        swipeView.getBuilder<>().setDisplayViewCount(3)
//            .setSwipeDecor(
//                SwipeDecor()
//                    .setViewWidth(windowSize.x)
//                    .setViewHeight(windowSize.y - bottomMargin)
//                    .setViewGravity(Gravity.TOP)
//                    .setPaddingTop(20)
//                    .setRelativeScale(0.01f)
//                    .setSwipeInMsgLayoutId(R.layout.tinder_swipe_in_msg_view)
//                    .setSwipeOutMsgLayoutId(R.layout.tinder_swipe_out_msg_view)
//            )
//    }

    override fun onClick(view: View) {
        if (view.id== R.id.button){
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
    private fun bottomSheet(){
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
}