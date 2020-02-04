package com.example.databindingwithkotlin

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.content_confirm_dialog.view.*
import android.content.ContextWrapper


/**
 * inflating a layout from ViewGroup
 */
fun ViewGroup.inflate(@LayoutRes layoutRes: Int, attachToRoot: Boolean = false): View {
    return LayoutInflater.from(context).inflate(layoutRes, this, attachToRoot)
}

/**
 * Intent function to go to any activity
 */

fun <T> Context.openActivity(it: Class<T>, extras: Bundle.() -> Unit = {}) {
    var intent = Intent(this, it)
    intent.putExtras(Bundle().apply(extras))
    startActivity(intent)
}

/**
 * Extension function to Toast class, you can call this from any class
 */

fun Context.toast(message: CharSequence) =
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()

/**
 * Show custom alert for confirm dialog
 */
fun Activity.showConfirmDialog(str_msg: String, str_action: String) {
    val dialogBuilder = AlertDialog.Builder(this)
    val inflater = this.getLayoutInflater()
    @SuppressLint("InflateParams")
    val dialogView = inflater.inflate(R.layout.content_confirm_dialog, null)
    dialogBuilder.setView(dialogView)

    val btn_yes = dialogView.btn_yes
    val btn_no = dialogView.btn_no
    val iv_close_dialog = dialogView.iv_cancel_dialog
    val txt_dialog_title = dialogView.txt_dialog_content
    val txt_dialog_title2 = dialogView.txt_dialog_content2
    val alertDialog = dialogBuilder.create()
    txt_dialog_title.setText(str_msg)

    //In Android, AlertDialog insert into another container, to avoid that , we need to make back ground transparent

   // alertDialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
    alertDialog.show()

    btn_yes.setOnClickListener {
        this.toast("Clicked on Yes")
        alertDialog.dismiss()
    }

    btn_no.setOnClickListener {
        this.toast("Clicked on No")
        alertDialog.dismiss()
    }
    iv_close_dialog.setOnClickListener {
        this.toast("Clicked on Close")
        alertDialog.dismiss()

    }


}

/**
 * To get the activity context from view inside it
 */
fun View.getActivity(): Activity? {
    var context = this.getContext()
    while (context is ContextWrapper) {
        if (context is Activity) {
            return context
        }
        context = (context as ContextWrapper).baseContext
    }
    return null
}