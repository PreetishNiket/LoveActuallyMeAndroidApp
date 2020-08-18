package com.example.loveactuallymeandroidapp.ui.other

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.loveactuallymeandroidapp.R
import com.example.loveactuallymeandroidapp.adapter.LikeYouAdapter
import com.example.loveactuallymeandroidapp.utils.dataClass.LikeYou
import kotlinx.android.synthetic.main.activity_like_you.*

class LikeYouActivity : AppCompatActivity() {
    val list= arrayListOf(
        LikeYou(
            R.drawable.ex_img,
            "Cody Fisher",
            "Active Now"
        ),
        LikeYou(
            R.drawable.ex_img1,
            "Penna Fox",
            "Active Now"
        ),
        LikeYou(
            R.drawable.ex_img2,
            "Rose Martin",
            "Active Now"
        ),
        LikeYou(
            R.drawable.ex_img,
            "Hell Gay",
            "Active Now"
        ),
        LikeYou(
            R.drawable.ex_img,
            "Hannah Cody",
            "Active Now"
        ),
        LikeYou(
            R.drawable.ex_img,
            "Martha Baker",
            "Active Now"
        ),
        LikeYou(
            R.drawable.ex_img,
            "User Name",
            "Active Now"
        ),
        LikeYou(
            R.drawable.ex_img,
            "User Name",
            "Active Now"
        ),
        LikeYou(
            R.drawable.ex_img,
            "User Name",
            "Active Now"
        ),
        LikeYou(
            R.drawable.ex_img,
            "User Name",
            "Active Now"
        )
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_like_you)
        supportActionBar?.hide()
        like_you_rv.layoutManager=GridLayoutManager(this,2,LinearLayoutManager.VERTICAL,false)
        like_you_rv.adapter=LikeYouAdapter(applicationContext,list)
        back1.setOnClickListener {
            finish()
        }
    }
}