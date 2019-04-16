package com.example.myapplication;

import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.MediaController;
import android.widget.VideoView;


public class Video extends AppCompatActivity {
    MediaPlayer videoPlayer;

//    @Override
//    public void onConfigurationChanged(Configuration newConfig) {
//        super.onConfigurationChanged(newConfig);
//
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);



        VideoView video = findViewById(R.id.myPlayer);
        String videoPath = "android.resource://" + getPackageName() +"/" + R.raw.kids_math;
        Uri uri = Uri.parse(videoPath);
        video.setVideoURI(uri);

        MediaController player = new MediaController(this);
        video.setMediaController(player);
        player.setAnchorView(video);

    }
}
