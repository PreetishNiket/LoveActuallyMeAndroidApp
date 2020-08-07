package com.example.loveactuallymeandroidapp.ui.profile

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.loveactuallymeandroidapp.R
import kotlinx.android.synthetic.main.activity_profile.*

class ProfileActivity : AppCompatActivity() {
    companion object{
        const val GALLERY_PICKER_CODE=1;
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        add_photo.setOnClickListener {
            val intent=Intent()
            intent.type = "image/*"
            intent.action = Intent.ACTION_GET_CONTENT
            startActivityForResult(Intent.createChooser(intent,"Pick An Image"), GALLERY_PICKER_CODE)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode== GALLERY_PICKER_CODE&&resultCode== Activity.RESULT_OK&&data!=null){
            val imageData=data.data
            profile_iv.setImageURI(imageData)
            profile_iv.handler.postDelayed({
                val intent=Intent(this,ProfileDetailsActivity::class.java)
                intent.putExtra("image",imageData.toString())
                startActivity(intent)
            },500)
        }
        super.onActivityResult(requestCode, resultCode, data)
    }
}