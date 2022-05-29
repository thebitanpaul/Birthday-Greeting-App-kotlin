package com.example.birthdaygreet

import android.annotation.SuppressLint
import android.media.session.MediaController
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import android.widget.VideoView
import androidx.annotation.RequiresApi
import kotlinx.android.synthetic.main.activity_main2.*
import com.example.birthdaygreet.R as BirthdaygreetR

class MainActivity2 : AppCompatActivity() {


    @SuppressLint("SetTextI18n")
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(BirthdaygreetR.layout.activity_main2)

//First Video Playback

        val videoPath = "android.resource://$packageName/${BirthdaygreetR.raw.birthdayvideo2}"
        val uri = Uri.parse(videoPath)
        videoView.setVideoURI(uri)
        videoView.requestFocus()

        videoView.setOnCompletionListener {
            Toast.makeText(this, "A app by Bitan Paul", Toast.LENGTH_LONG).show()
        }

        videoView.setOnErrorListener { mp, what, extra ->
            Toast.makeText(this, "Error Occured", Toast.LENGTH_LONG).show()
            false
        }

        videoView.setOnPreparedListener { mp->
            videoView.start()


        }
//Second Video Playback

        val videoPath2 = "android.resource://$packageName/${BirthdaygreetR.raw.birthdayvideo}"
        val uri2 = Uri.parse(videoPath2)
        videoView2.setVideoURI(uri2)
        videoView2.requestFocus()

        videoView2.setOnCompletionListener {
            Toast.makeText(this, "A app by Bitan Paul", Toast.LENGTH_LONG).show()
        }

        videoView2.setOnErrorListener { mp, what, extra ->
            Toast.makeText(this, "Error Occured", Toast.LENGTH_LONG).show()
            false
        }

        videoView2.setOnPreparedListener { mp->
            videoView2.start()

        }

        val name = intent.getStringExtra("name")
        newgreeting.text = "May you have all the love your heart can hold, " +
                "all the happiness a day can bring, and all the blessings a life can unfold. " +
                "Happy birthday : \n $name!"

    }

}

