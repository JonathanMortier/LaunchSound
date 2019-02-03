package com.patapin.djmojo.soundbox.activity

import android.app.Activity
import android.os.Bundle
import android.widget.TextView
import com.patapin.djmojo.soundbox.R

class StatActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stat)

        val mainSoundList = MainActivity.getMainSoundList()
        val moviesSoundList = MainActivity.getMoviesSoundList()
        val southparkSoundList = MainActivity.getSouthParkSoundList()

        mainSoundList?.forEach { buttonInfos ->
            val textView = findViewById<TextView>(buttonInfos.statTextId)
            val text = buttonInfos.click!!.counter.toString()
            textView.text = text
        }

        moviesSoundList?.forEach { buttonInfos ->
            val textView = findViewById<TextView>(buttonInfos.statTextId)
            val text = buttonInfos.click!!.counter.toString()
            textView.text = text
        }

        southparkSoundList?.forEach { buttonInfos ->
            val textView = findViewById<TextView>(buttonInfos.statTextId)
            val text = buttonInfos.click!!.counter.toString()
            textView.text = text
        }

    }
}
