package com.androidavanzadotutorial.poo

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.CalendarView
import android.widget.ImageView
import android.widget.MediaController
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.VideoView
import com.squareup.picasso.Picasso
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.Calendar

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

        /**
         * Calendar View
         */
        var cvEjemplo:CalendarView = findViewById(R.id.cvEjemplo)
        var tvFecha:TextView = findViewById(R.id.tvFecha)
        
        cvEjemplo.setOnDateChangeListener { cv, year, month, day ->
            var date = "$day/${month+1}/$year"
            tvFecha.text = "Fecha selecionada: $date"
        }

        //Setiar fechas
        var calendar = Calendar.getInstance()
        calendar.set(2026,5-1,8)
        cvEjemplo.date = calendar.timeInMillis

        var d = cvEjemplo.firstDayOfWeek
        cvEjemplo.firstDayOfWeek = (d+1)%7

        /**
         * ProgressBar desde código DETERMINADO - SECUNDARIO
         */
        var pbDeterminado:ProgressBar = findViewById(R.id.pbDeterminado)
        var pbSecundario:ProgressBar = findViewById(R.id.pbSecundario)

        pbDeterminado.max = 200
        pbDeterminado.progress = 0
        pbSecundario.progress = 0
        pbSecundario.secondaryProgress = 0

        GlobalScope.launch {
            progressManager(pbDeterminado)
            progressManager(pbSecundario)
        }

    }

    private fun progressManager(pb:ProgressBar){
        while(pb.progress < pb.max){
            Thread.sleep(100L)
            //pb.progress += 5
            pb.incrementProgressBy(5)
            if(pb.id == R.id.pbSecundario){
                pb.incrementSecondaryProgressBy(10)
            }
        }
    }


}