package com.deartail.apps.flow.main

import android.content.Context
import android.webkit.JsResult
import android.webkit.WebChromeClient
import android.webkit.WebView
import androidx.appcompat.app.AlertDialog
import com.deartail.apps.R


class CustomWebChromeClient(
    private val context: Context,
    private val onProgressChangeListener: (Int) -> Unit
) : WebChromeClient() {

    override fun onProgressChanged(view: WebView, progress: Int) {
        onProgressChangeListener(progress)
    }

    override fun onJsAlert(view: WebView?, url: String?, message: String?, result: JsResult?): Boolean {
        makeCustomMessageDialog(message, result).show()
        return true
    }

    override fun onJsConfirm(view: WebView?, url: String?, message: String?, result: JsResult?): Boolean {
        makeCustomConfirmDialog(message, result).show()
        return true
    }

    private fun makeCustomMessageDialog(msg: String?, result: JsResult?): AlertDialog {
        return AlertDialog.Builder(context, R.style.CustomDialogTheme)
            .setMessage(msg)
            .setPositiveButton(android.R.string.ok) { _, _ ->
                result?.confirm()
            }
            .setOnCancelListener {
                result?.confirm()
                it.dismiss()
            }
            .setCancelable(true)
            .create()
    }

    private fun makeCustomConfirmDialog(msg: String?, result: JsResult?): AlertDialog {
        return AlertDialog.Builder(context, R.style.CustomDialogTheme)
            .setMessage(msg)
            .setPositiveButton(android.R.string.ok) { _, _ ->
                result?.confirm()
            }
            .setNegativeButton(android.R.string.cancel) { _, _ ->
                result?.cancel()
            }
            .setOnCancelListener {
                result?.cancel()
                it.dismiss()
            }
            .setCancelable(true)
            .create()
    }
}
