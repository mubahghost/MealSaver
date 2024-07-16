package com.codecx.mealsaver.utils

import android.app.ProgressDialog
import android.content.Context

class ProgressUtil(val mContext: Context):ProgressDialog(mContext) {
    fun showProgress(message:String,isCancelable:Boolean=false){
        setCancelable(isCancelable)
        setMessage(message)
        show()
    }

    fun dismissDialog(){
        if(this.isShowing){
            dismiss()
        }
    }
}