package com.guagua.kkmusics.util

import android.annotation.SuppressLint
import android.content.Context
import android.support.design.widget.Snackbar
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient

class WebPlayer{

    var layout: View
    var context: Context

    constructor(context: Context, layout: View){
        this.context = context
        this.layout = layout
    }

    @SuppressLint("SetJavaScriptEnabled")
    fun autoPlay(url: String) {

        fun addPlayerToSnackbar(player: WebView){
            val snackbar = Snackbar.make(layout, "", Snackbar.LENGTH_INDEFINITE)
            val snackView = snackbar.view as Snackbar.SnackbarLayout
            val parenParams = snackView.layoutParams
            parenParams.height = 300
            snackView.layoutParams = parenParams
            snackView.addView(player)
            snackbar.show()
        }

        val player = WebView(context)
        player.loadUrl(url)
        player.settings.javaScriptEnabled = true
        player.isSoundEffectsEnabled = true
        player.webViewClient = object : WebViewClient() {
            override fun onPageFinished(view: WebView, url: String) {
                // reference: https://stackoverflow.com/questions/16709963/programmatic-click-in-android-webview
                // perform click on play button to auto play
                player.loadUrl("javascript:(function(){"+
                        "l=document.getElementsByClassName('clickable control icon play')[0];"+
                        "e=document.createEvent('HTMLEvents');"+
                        "e.initEvent('click',true,true);"+
                        "l.dispatchEvent(e);"+
                        "})()")
            }
        }
        addPlayerToSnackbar(player)

    }

}