package com.example.loveactuallymeandroidapp.ui.profile


import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.loveactuallymeandroidapp.MainActivity
import com.example.loveactuallymeandroidapp.R
import kotlinx.android.synthetic.main.activity_more_details.*
import kotlinx.android.synthetic.main.activity_more_details.tv

class MoreDetailsActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_more_details)
        supportActionBar?.hide()
        if (intent.extras!=null){
            val imageUri= Uri.parse(intent.getStringExtra("image1"))
            profile_photo1.setImageURI(imageUri)
            imageView1.setImageURI(imageUri)
        }
        val userName=intent.getStringExtra("name")
        tv.text="Hello\n${userName}"
        getStartedButton.setOnClickListener {
//            Toast.makeText(this, "Main Screen will be implemented Soon", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this,MainActivity::class.java))
        }
        back1.setOnClickListener {
            finish()
        }

        imageView2.setOnClickListener(this)
        imageView3.setOnClickListener(this)
        imageView4.setOnClickListener(this)
        imageView5.setOnClickListener(this)
        imageView6.setOnClickListener(this)
        imageView7.setOnClickListener(this)
        imageView8.setOnClickListener(this)
        imageView9.setOnClickListener(this)
    }
    companion object{
        const val GALLERY_PICKER=1;

    }
    private  var int=0
    override fun onClick(v: View) {
        if (v.id==R.id.imageView2){
                galleryPick()
            int=1

        }
        if (v.id==R.id.imageView3){
            galleryPick()
            int=2

        }
        if (v.id==R.id.imageView4){
            galleryPick()
            int=3
        }
        if (v.id==R.id.imageView5){
            galleryPick()
            int=4

        }
        if (v.id==R.id.imageView6){
            galleryPick()
            int=5

        }
        if (v.id==R.id.imageView7){
            galleryPick()
            int=6

        }
        if (v.id==R.id.imageView8){
            galleryPick()
            int=7

        }
        if (v.id==R.id.imageView9){
            galleryPick()
            int=8

        }
    }
    private fun galleryPick(){
        val intent=Intent()
        intent.type = "image/*"
        intent.action = Intent.ACTION_GET_CONTENT
        startActivityForResult(Intent.createChooser(intent,"Pick An Image"), GALLERY_PICKER)
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode== GALLERY_PICKER &&resultCode==RESULT_OK&&data!=null){
            val imageData= data.data!!
            when(int){
                1->{
                    imageView2.setImageURI(imageData)
                }
                2->{
                    imageView3.setImageURI(imageData)
                }
                3->{
                    imageView4.setImageURI(imageData)
                }
                4->{
                    imageView5.setImageURI(imageData)
                }
                5->{
                    imageView6.setImageURI(imageData)
                }
                6->{
                    imageView7.setImageURI(imageData)
                }
                7->{
                    imageView8.setImageURI(imageData)
                }
                8->{
                    imageView9.setImageURI(imageData)
                }
            }

        }
        super.onActivityResult(requestCode, resultCode, data)
    }
}