package com.example.loveactuallymeandroidapp.ui.navUi

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.loveactuallymeandroidapp.R
import com.example.loveactuallymeandroidapp.adapter.SwipeViewAdapter
import com.example.loveactuallymeandroidapp.dataClass.Users
import com.example.loveactuallymeandroidapp.ui.other.LikeYouActivity
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.huxq17.swipecardsview.SwipeCardsView
import kotlinx.android.synthetic.main.bottom_sheet_layout.view.*
import kotlinx.android.synthetic.main.fragment_home.view.*
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList


class HomeFragment : Fragment(), View.OnClickListener {

    private val auth by lazy {
        FirebaseAuth.getInstance()
    }
    private lateinit var id: String
    private lateinit var age:String
    private var usersList: List<Users>? = null
    var cardAdapter: SwipeViewAdapter? = null
    private var swipeList:List<Users>?=null
    lateinit var bottomSheetDialog:BottomSheetDialog
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val frag = inflater.inflate(R.layout.fragment_home, container, false)
        val filterButton = frag.findViewById<ImageView>(R.id.filter_img)
        filterButton.setOnClickListener {
            bottomSheetDialog=BottomSheetDialog(requireContext())
            bottomSheetDialog.setContentView(R.layout.bottom_sheet_layout)
            bottomSheetDialog.setCanceledOnTouchOutside(true)
            val btn: Button? = bottomSheetDialog.findViewById(R.id.button)
            val btn1: Button? = bottomSheetDialog.findViewById(R.id.button2)
            val btn2: Button? = bottomSheetDialog.findViewById(R.id.button3)
            val btn3:Button?=bottomSheetDialog.findViewById(R.id.apply)
            btn?.setOnClickListener(this)
            btn1?.setOnClickListener(this)
            btn2?.setOnClickListener(this)
            btn3?.setOnClickListener(this)
            bottomSheetDialog.show()
        }

        val likeButton = frag.findViewById<ImageView>(R.id.like_img)
        likeButton.setOnClickListener {
            startActivity(Intent(context, LikeYouActivity::class.java))
        }


        usersList = ArrayList()
        swipeList=ArrayList()

        val swipe = frag.swipeCardsView
        swipe.retainLastCard(false)
        swipe.enableSwipe(true)

        id=auth.currentUser!!.uid
        val dbRef = FirebaseDatabase.getInstance().reference.child("Users").child(id)
        dbRef.addValueEventListener(object :ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                val dob = snapshot.child("Date_of_Birth").getValue(String::class.java)
                val df=SimpleDateFormat("dd/MM/yyyy")
                val birthDate=df.parse(dob!!)
                age=calculateAge(birthDate!!).toString()
            }

            override fun onCancelled(error: DatabaseError) {

            }
        })

        val ref = FirebaseDatabase.getInstance().reference.child("Users")
        ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {


                (usersList as ArrayList).clear()
                for (snap in snapshot.children) {
                    val user = snap.getValue(Users::class.java)
                    if (id!=user!!.getUid()) {
                        (usersList as ArrayList).add(user)
                    }
                }
                cardAdapter = SwipeViewAdapter(usersList as ArrayList<Users>,age)
                swipe.setAdapter(cardAdapter)
            }

            override fun onCancelled(error: DatabaseError) {}
        })
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
//                        Toast.makeText(context,"Swipe${index}", Toast.LENGTH_SHORT).show()
//                        for (i in (usersList as ArrayList).indices) {
//                            if (i == index) {
//                                (usersList as ArrayList).removeAt(i)
//                                val r=FirebaseDatabase.getInstance().reference.child("UsersCopy")
//                                    .child((usersList as ArrayList)[i].getUid().toString()).removeValue().addOnCompleteListener {
//                                        if (it.isSuccessful){
//                                            val p=FirebaseDatabase.getInstance().reference.child("LikeYou").child((usersList as ArrayList)[i].toString())
//                                                .addValueEventListener(object :ValueEventListener{})
//                                        }
//                                    }
//                            }
//                        }
                    }
                    else -> {
                        Toast.makeText(context, "None${index}", Toast.LENGTH_SHORT).show()
                    }
                }
            }

            override fun onItemClick(cardImageView: View?, index: Int) {
//                Toast.makeText(context, "Clicked${index}", Toast.LENGTH_SHORT).show()

            }

        })


        return frag
    }
    private fun calculateAge(birthDate: Date): Int {
        val birth = Calendar.getInstance()
        birth.time = birthDate
        val today = Calendar.getInstance()
        var yearDifference = (today[Calendar.YEAR]
                - birth[Calendar.YEAR])
        if (today[Calendar.MONTH] < birth[Calendar.MONTH]) {
            yearDifference--
        } else {
            if (today[Calendar.MONTH] == birth[Calendar.MONTH]
                && today[Calendar.DAY_OF_MONTH] < birth[Calendar.DAY_OF_MONTH]
            ) {
                yearDifference--
            }
        }
        return yearDifference
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
        if (view.id==R.id.apply){
            bottomSheetDialog.dismiss()
        }
    }
}