package com.example.loveactuallymeandroidapp.ui.navUi

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment

import com.example.loveactuallymeandroidapp.R
import com.example.loveactuallymeandroidapp.adapter.SwipeViewAdapter
import com.example.loveactuallymeandroidapp.dataClass.Users
import com.example.loveactuallymeandroidapp.ui.other.LikeYouActivity
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.huxq17.swipecardsview.SwipeCardsView
import com.lorentzos.flingswipe.SwipeFlingAdapterView
import kotlinx.android.synthetic.main.bottom_sheet_layout.view.*
import kotlinx.android.synthetic.main.fragment_home.view.*
import kotlinx.android.synthetic.main.item_card_view_profile.view.*


class HomeFragment : Fragment(), View.OnClickListener {
    private var arrayAdapter: ArrayAdapter<String>? = null
    private var i = 0
    private var al = ArrayList<String>()
    //var rowItems: MutableList<Profile>? = null
    lateinit var modelList: ArrayList<Users>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        al.add("Preetish")
        al.add("Gopal")
        al.add("Rajneesh")
        al.add("Kishore")
        al.add("Dharmerdar")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val frag = inflater.inflate(R.layout.fragment_home, container, false)
        val filterButton = frag.findViewById<ImageView>(R.id.filter_img)
        filterButton.setOnClickListener {
            val bottomSheetDialog = BottomSheetDialog(requireContext())
            bottomSheetDialog.setContentView(R.layout.bottom_sheet_layout)
            bottomSheetDialog.setCanceledOnTouchOutside(true)
            val btn: Button? = bottomSheetDialog.findViewById(R.id.button)
            val btn1: Button? = bottomSheetDialog.findViewById(R.id.button2)
            val btn2: Button? = bottomSheetDialog.findViewById(R.id.button3)

            btn?.setOnClickListener(this)
            btn1?.setOnClickListener(this)
            btn2?.setOnClickListener(this)
            bottomSheetDialog.show()
        }
        val likeButton = frag.findViewById<ImageView>(R.id.like_img)
        likeButton.setOnClickListener {
            startActivity(Intent(context, LikeYouActivity::class.java))
        }
//        arrayAdapter = ArrayAdapter(requireContext(), R.layout.item_card_view_profile, R.id.helloText,al)
//        frag.frame.adapter = arrayAdapter
//        frag.frame.setFlingListener(object : SwipeFlingAdapterView.onFlingListener {
//            override fun removeFirstObjectInAdapter() {
//                al.add("XML $i")
//                al.removeAt(0)
//                arrayAdapter?.notifyDataSetChanged()
//            }
//
//            override fun onLeftCardExit(p0: Any?) {
//                Toast.makeText(requireContext(), "Left", Toast.LENGTH_SHORT).show()
//                frag.item_swipe_left_indicator.visibility=View.VISIBLE
//                frag.item_swipe_right_indicator.visibility=View.GONE
//            }
//
//            override fun onRightCardExit(p0: Any?) {
//                Toast.makeText(requireContext(), "Right", Toast.LENGTH_SHORT).show()
//                frag.item_swipe_right_indicator.visibility=View.VISIBLE
//                frag.item_swipe_left_indicator.visibility=View.GONE
//            }
//
//            override fun onAdapterAboutToEmpty(p0: Int) {
//                arrayAdapter?.notifyDataSetChanged()
//                Log.d("LIST", "notified")
//                i++
//            }
//
//            override fun onScroll(scroll: Float) {
////                Toast.makeText(requireContext(), "On Scroll", Toast.LENGTH_SHORT).show()
//                if (scroll==24.0f){
//
//                }
//            }
//        })
        val swipe = frag.swipeCardsView
        swipe.retainLastCard(true)
        swipe.enableSwipe(true)
        getData()
//        swipe.slideCardOut(SwipeCardsView.SlideType.LEFT)
//        swipe.slideCardOut(SwipeCardsView.SlideType.RIGHT)
        swipe.setCardsSlideListener(object : SwipeCardsView.CardsSlideListener {
            override fun onShow(index: Int) {

            }

            override fun onCardVanish(index: Int, type: SwipeCardsView.SlideType?) {

            }

            override fun onItemClick(cardImageView: View?, index: Int) {
                Toast.makeText(context, "Clicked", Toast.LENGTH_SHORT).show()
            }

        })
        modelList= ArrayList()
        modelList.add(
            Users(
                "Preetish",
                "",
                "",
                //"https://firebasestorage.googleapis.com/v0/b/loveactuallymeandroidapp.appspot.com/o/profile%20verification.jpg?alt=media&token=8b4e5865-396a-40c3-9cd0-e0edf9e23cd4",
                ""
            )
        )
        modelList.add(
            Users(
                "Gopal",
                "",
                "",
                ""
            )
        )
        modelList. add ((Users(
            "Kishore",
            "",
            "",
            "")
                )
        )

        val cardAdapter= SwipeViewAdapter(modelList)
        swipe.setAdapter(cardAdapter)
        return frag
    }


    private fun getData() {

    }

    override fun onClick(view: View) {
        if (view.id == R.id.button) {
            view.setBackgroundColor(resources.getColor(R.color.pink))
            view.button.setTextColor(Color.WHITE)
        }
        if (view.id == R.id.button2) {
            view.setBackgroundColor(resources.getColor(R.color.pink))
            view.button2.setTextColor(Color.WHITE)
        }
        if (view.id == R.id.button3) {
            view.setBackgroundColor(resources.getColor(R.color.pink))
            view.button3.setTextColor(Color.WHITE)
        }
    }
}