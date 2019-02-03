package com.patapin.djmojo.soundbox.activity

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

import com.patapin.djmojo.soundbox.BuildConfig
import com.patapin.djmojo.soundbox.R

/**
 * Created by DJMojo on 14/02/15.
 */
class AboutActivity : Activity() {

    private var txtVersionCode: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        txtVersionCode = findViewById(R.id.txtVersionCode)

        Log.d("About", "Version code : " + BuildConfig.VERSION_CODE.toString())
        Log.d("About", "Version number : " + BuildConfig.VERSION_NAME)

        txtVersionCode!!.append(BuildConfig.VERSION_CODE.toString())


    }
}
