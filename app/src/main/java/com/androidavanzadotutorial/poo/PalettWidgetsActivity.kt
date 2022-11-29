package com.androidavanzadotutorial.poo

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ImageView
import android.widget.MediaController
import android.widget.VideoView
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

        /**
         * VideoView
         */
        //web
        var vvWeb:VideoView = findViewById(R.id.vvWeb)
        var mcWeb = MediaController(this)

        mcWeb.setAnchorView(vvWeb)
        vvWeb.setVideoPath("https://jotajotavm.com/img/video.mp4")
        vvWeb.setMediaController(mcWeb)

        //local
        var vvLocal:VideoView = findViewById(R.id.vvLocal)
        var mcLocal = MediaController(this)

        mcLocal.setAnchorView(vvLocal)
        var path:String = "android.resource://"+packageName+"/"+R.raw.video
        vvLocal.setVideoURI(Uri.parse(path))
        vvLocal.setMediaController(mcLocal)
        vvLocal.start()

    }


}