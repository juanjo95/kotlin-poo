package com.androidavanzadotutorial.poo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ImageView
import com.squareup.picasso.Picasso

class PalettWidgetsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_palett_widgets)

        /**
         * ImageView Url
         */
        /*var ivEjemplo: ImageView = findViewById(R.id.iv)
        val imageURL = "https://http2.mlstatic.com/D_NQ_NP_669593-MCO50195190532_062022-O.webp"
        Picasso.get().load(imageURL).into(ivEjemplo)*/

        /**
         * WebView
         */
        var webView:WebView = findViewById(R.id.webView)
        var webSettings:WebSettings = webView.settings
        webSettings.javaScriptEnabled = true
        webView.setWebViewClient(WebViewClient())

        webView.loadUrl("https://www.google.com/")
    }


}