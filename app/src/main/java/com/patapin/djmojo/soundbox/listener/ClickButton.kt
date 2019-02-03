package com.patapin.djmojo.soundbox.listener

import android.media.MediaPlayer
import android.util.Log
import android.view.View

/**
 * Created by DJMojo on 17/01/15.
 */
class ClickButton(var counter: Int, private val mediaPlayer: MediaPlayer) : View.OnClickListener {

    override fun onClick(v: View) {
        counter++
        Log.d("ClickButton", "Current counter : $counter")
        mediaPlayer.start()

    }
}
