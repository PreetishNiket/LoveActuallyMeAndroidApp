package com.example.loveactuallymeandroidapp.utlis

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView


class DefaultItemDecorator(private val VerticalSpacing:Int) :RecyclerView.ItemDecoration(){
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        outRect.bottom=VerticalSpacing
    }
}