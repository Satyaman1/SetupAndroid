package com.satya.praticeproject.api

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.Window
import android.widget.ProgressBar
import com.satya.praticeproject.R

class CustomProgressBar(var context: Context) {

    var dialog: Dialog? = null

    private var progressBar: ProgressBar? = null

    fun showProgress() {

        if (dialog == null) {

            dialog = Dialog(context)

            dialog?.requestWindowFeature(Window.FEATURE_NO_TITLE)

            dialog?.setContentView(R.layout.custom_progress_bar)

            dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT)) //TODO Uncomment if you want to show transparent backgraound

            progressBar = dialog?.findViewById(R.id.progressbar)
        }

        if (dialog != null && !dialog!!.isShowing) {

            dialog?.setCancelable(false)

            dialog?.setCanceledOnTouchOutside(false)

            try {

                dialog?.show()

            } catch (e: Exception) {

                dialog!!.dismiss()
            }
        }
    }

    fun hideProgress() {

        if (dialog != null && dialog!!.isShowing) {

            dialog!!.dismiss()
        }
    }
}