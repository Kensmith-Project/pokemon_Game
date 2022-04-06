package com.example.week7experimentalproject.Interface

import android.view.View
//an interface that sets states for our views
interface IItemClickListener {
    fun onClick(view: View, position:Integer)
}