package com.example.loveactuallymeandroidapp.ui.navUi

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.loveactuallymeandroidapp.R
import com.example.loveactuallymeandroidapp.adapter.SwipeViewAdapter
import com.example.loveactuallymeandroidapp.dataClass.Users
import com.example.loveactuallymeandroidapp.ui.other.LikeYouActivity
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.huxq17.swipecardsview.SwipeCardsView
import kotlinx.android.synthetic.main.bottom_sheet_layout.view.*
import kotlinx.android.synthetic.main.fragment_home.view.*


class HomeFragment : Fragment(), View.OnClickListener {

    lateinit var modelList: ArrayList<Users>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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

        val swipe = frag.swipeCardsView
        swipe.retainLastCard(false)
        swipe.enableSwipe(true)
        modelList = ArrayList()
       // getData()
        swipe.setCardsSlideListener(object : SwipeCardsView.CardsSlideListener {
            override fun onShow(index: Int) {
                // Toast.makeText(context, "Show${index}", Toast.LENGTH_SHORT).show()
            }

            override fun onCardVanish(index: Int, type: SwipeCardsView.SlideType?) {
                val container1 = frag.findViewById<ViewGroup>(R.id.container_toast_like)
                val layout = layoutInflater.inflate(R.layout.item_toast, container1)

                when (type) {
                    SwipeCardsView.SlideType.LEFT -> {
                        layout.findViewById<ImageView>(R.id.item_swipe_left_indicator).visibility =
                            View.VISIBLE
                        layout.findViewById<ImageView>(R.id.item_swipe_right_indicator).visibility =
                            View.GONE
                        with(Toast(context)) {
                            setGravity(Gravity.TOP or Gravity.START, 0, 250)
                            duration = Toast.LENGTH_SHORT
                            view = layout
                            show()
                        }
                    }
                    SwipeCardsView.SlideType.RIGHT -> {
                        layout.findViewById<ImageView>(R.id.item_swipe_right_indicator).visibility =
                            View.VISIBLE
                        layout.findViewById<ImageView>(R.id.item_swipe_left_indicator).visibility =
                            View.GONE
                        with(Toast(context)) {
                            setGravity(Gravity.TOP or Gravity.END, -80, 250)
                            duration = Toast.LENGTH_SHORT
                            view = layout
                            show()
                        }
                    }
                    else -> {
                        Toast.makeText(context, "None${index}", Toast.LENGTH_SHORT).show()
                    }
                }
            }

            override fun onItemClick(cardImageView: View?, index: Int) {
                Toast.makeText(context, "Clicked", Toast.LENGTH_SHORT).show()
            }

        })

        val cardAdapter = SwipeViewAdapter(modelList)
        swipe.setAdapter(cardAdapter)
        return frag
    }

//    private fun getData() {
//        modelList.add(
//            Users(
//                "Preetish",
//                "",
//                "",
//                //"https://firebasestorage.googleapis.com/v0/b/loveactuallymeandroidapp.appspot.com/o/profile%20verification.jpg?alt=media&token=8b4e5865-396a-40c3-9cd0-e0edf9e23cd4",
//                ""
//            )
//        )
//        modelList.add(
//            Users(
//                "Gopal",
//                "",
//                "",
//                ""
//            )
//        )
//        modelList.add(
//            (Users(
//                "Kishore",
//                "",
//                "",
//                ""
//            ))
//        )
//        modelList.add(
//            (Users(
//                "Dharmendar",
//                "",
//                "",
//                ""
//            ))
//        )
//        modelList.add(
//            (Users(
//                "Rajneesh",
//                "",
//                "",
//                ""
//            ))
//        )
//        modelList.add(
//            (Users(
//                "Muraee",
//                "",
//                "",
//                ""
//            ))
//        )
//    }

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