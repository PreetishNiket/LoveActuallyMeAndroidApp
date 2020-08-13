package com.example.loveactuallymeandroidapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.bottom_sheet_layout.*

open class BottomSheetFragment: BottomSheetDialogFragment(), View.OnClickListener {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view= inflater.inflate(R.layout.bottom_sheet_layout, container, false)
        val btn:Button=view.findViewById(R.id.button)
        val btn1:Button=view.findViewById(R.id.button)
        val btn2:Button=view.findViewById(R.id.button)
        btn.setOnClickListener(this)
        btn2.setOnClickListener(this)
        btn2.setOnClickListener(this)
        return view
    }

    override fun onClick(v: View) {

    }
}