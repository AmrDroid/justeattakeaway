package com.aelsayed.takeaway.presentation.util

import android.app.Activity
import android.view.View
import android.widget.Toast

fun View.visible() {
    visibility = View.VISIBLE
}

fun View.gone() {
    visibility = View.GONE
}

fun View.showLoading(show: Boolean) {
    if (show) {
        visible()
    } else {
        gone()
    }
}

fun Activity.showSuccessMessage(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_LONG).show()
}