package com.example.retrofit

import android.app.Activity
import android.app.AlertDialog
import android.view.LayoutInflater
import android.view.View

class ModalLoader(val activity: Activity ) {
    lateinit var modal:AlertDialog

   fun startLoader(){
      val builder:AlertDialog.Builder =AlertDialog.Builder(activity)

       val inflater:LayoutInflater= LayoutInflater.from(activity)

       builder.setView(View.inflate(activity,R.layout.loader_item,null))

       builder.setCancelable(false);

       modal=builder.create()

       modal.show()
   }
    fun endLoader(){
        modal.dismiss()
    }
}