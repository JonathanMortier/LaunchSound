package com.patapin.djmojo.soundbox.activity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;

import com.patapin.djmojo.soundbox.R;

import java.io.InputStream;

/**
 * Created by DJMojo on 01/03/15.
 */
public class CustomActivity extends Activity {

    private Button addButton, shareButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom);

        addButton = (Button) findViewById(R.id.add_button);
        shareButton = (Button) findViewById(R.id.share_button);

        shareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent share = new Intent(Intent.ACTION_SEND);
                share.setType("audio/*");
                share.putExtra(Intent.EXTRA_STREAM, Uri.parse("android.resource://com.patapin.djmojo.soundbox/" + R.raw.timmy));
                startActivity(Intent.createChooser(share, "Share a sound"));
            }
        });

    }
}
