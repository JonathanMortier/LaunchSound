package com.patapin.djmojo.soundbox.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.util.Log;
import android.view.MenuItem;

import com.patapin.djmojo.soundbox.R;
import com.patapin.djmojo.soundbox.listener.ClickButton;
import com.patapin.djmojo.soundbox.model.ButtonInfos;

/**
 * Created by DJMojo on 01/03/15.
 */
public class SoundButtonActivity extends Activity {


    public void associateSoundNImageButton(ButtonInfos tripletId, SharedPreferences settings) {

        final MediaPlayer mediaPlayer = MediaPlayer.create(this, tripletId.getSoundId());

        Log.i("associateSoundNImage", "setting : " + settings.getInt(tripletId.getPrefCounter(), 0));
        ClickButton click = new ClickButton(settings.getInt(tripletId.getPrefCounter(), 0), mediaPlayer);

        tripletId.setClick(click);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_qrcode) {

            Intent intent = new Intent(this, QRCodeActivity.class);
            startActivity(intent);
            return true;
        }
        else if (id == R.id.action_stat) {

            Intent intent = new Intent(this, StatActivity.class);
            startActivity(intent);
            return true;
        }
        else if (id == R.id.action_about) {
            Intent intent = new Intent(this, AboutActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
