package com.patapin.djmojo.soundbox.activity

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.patapin.djmojo.soundbox.R

/**
 * Created by DJMojo on 01/03/15.
 */
class CustomActivity : Activity() {

    private var addButton: Button? = null
    private var shareButton: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom)

        addButton = findViewById<View>(R.id.add_button) as Button
        shareButton = findViewById<View>(R.id.share_button) as Button

        shareButton!!.setOnClickListener {
            val share = Intent(Intent.ACTION_SEND)
            share.type = "audio/*"
            share.putExtra(Intent.EXTRA_STREAM, Uri.parse("android.resource://com.patapin.djmojo.soundbox/" + R.raw.timmy))
            startActivity(Intent.createChooser(share, "Share a sound"))
        }

    }
}
