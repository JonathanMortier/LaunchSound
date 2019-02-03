package com.patapin.djmojo.soundbox.activity

import android.app.Activity
import android.content.Intent
import android.content.SharedPreferences
import android.media.MediaPlayer
import android.util.Log
import android.view.MenuItem

import com.patapin.djmojo.soundbox.R
import com.patapin.djmojo.soundbox.listener.ClickButton
import com.patapin.djmojo.soundbox.model.ButtonInfos

/**
 * Created by DJMojo on 01/03/15.
 */
open class SoundButtonActivity : Activity() {


    fun associateSoundNImageButton(tripletId: ButtonInfos, settings: SharedPreferences) {

        val mediaPlayer = MediaPlayer.create(this, tripletId.soundId)

        Log.i("associateSoundNImage", "setting : " + settings.getInt(tripletId.prefCounter, 0))
        val click = ClickButton(settings.getInt(tripletId.prefCounter, 0), mediaPlayer)

        tripletId.click = click

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        val id = item.itemId


        when (id) {
            R.id.action_qrcode -> {

                val intent = Intent(this, QRCodeActivity::class.java)
                startActivity(intent)
                return true
            }
            R.id.action_stat -> {

                val intent = Intent(this, StatActivity::class.java)
                startActivity(intent)
                return true
            }
            R.id.action_about -> {
                val intent = Intent(this, AboutActivity::class.java)
                startActivity(intent)
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }

    }
}
