package com.example.loveactuallymeandroidapp.utils.dataClass

import android.content.Context
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.loveactuallymeandroidapp.R
import com.mindorks.placeholderview.SwipePlaceHolderView
import com.mindorks.placeholderview.annotations.Layout
import com.mindorks.placeholderview.annotations.Resolve
import com.mindorks.placeholderview.annotations.View
import com.mindorks.placeholderview.annotations.swipe.*


@Layout(R.layout.profile_card)
class SwipeCard(private val context: Context, private val profile: Profiles1, private val swipeView: SwipePlaceHolderView){
    @View(R.id.profileImageView)
    private val profileImageView: ImageView? = null

    @View(R.id.nameAgeTxt)
    private val nameAgeTxt: TextView? = null

    @View(R.id.locationNameTxt)
    private val locationNameTxt: TextView? = null

    @Resolve
    private fun onResolved() {
        Glide.with(context).load(profile.imageUrl).into(profileImageView)
        nameAgeTxt!!.text = profile!!.name + ", " + profile.age
        locationNameTxt?.text=profile.location
    }

    @SwipeOut
    private fun onSwipedOut() {
        //Log.d("EVENT", "onSwipedOut")
        swipeView.addView(this)
    }

    @SwipeCancelState
    private fun onSwipeCancelState() {
       // Log.d("EVENT", "onSwipeCancelState")
    }

    @SwipeIn
    private fun onSwipeIn() {
        //Log.d("EVENT", "onSwipedIn")
    }

    @SwipeInState
    private fun onSwipeInState() {
       // Log.d("EVENT", "onSwipeInState")
    }

    @SwipeOutState
    private fun onSwipeOutState() {
       // Log.d("EVENT", "onSwipeOutState")
    }
}