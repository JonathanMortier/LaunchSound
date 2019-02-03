package com.patapin.djmojo.soundbox.activity

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.widget.ImageButton
import com.patapin.djmojo.soundbox.R
import com.patapin.djmojo.soundbox.model.ButtonInfos

class MoviesActivity : SoundButtonActivity() {


    private var moviesSoundList: List<ButtonInfos>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movies)

        moviesSoundList = MainActivity.getMoviesSoundList()

        for (buttonInfos in moviesSoundList!!) {

            val button = findViewById<ImageButton>(buttonInfos.buttonId)

            button.setOnClickListener(buttonInfos.click)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_movies, menu)
        return true
    }


    override fun onPause() {
        super.onPause()

        val settings = getSharedPreferences(MainActivity.PREFS_COUNTER, Context.MODE_PRIVATE)

        val editor = settings.edit()

        Log.i("onPause", "Stockage des stats")

        editor.clear()
        MainActivity.getMoviesSoundList()?.forEach { button ->
            Log.d("onPause", button.prefCounter + " = " + button.click?.counter)
            editor.putInt(button.prefCounter, button.click!!.counter)
        }
        editor.apply()

        overridePendingTransition(R.anim.appearfromleft, R.anim.disappearfromright)

    }

}
