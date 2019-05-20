package com.example.myapplication;

import android.content.Intent;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ChapterThreeNumbers extends AppCompatActivity {


    Button myButton1;
    Button myNumber;
    Button myButton2;
    MediaPlayer mMediaPlayer;



    //sound
    private SoundPool sound;
    private int soundOne, soundTwo, soundThree, soundFour;
    //    private boolean correctAnswer= false;
//    private boolean falseAnswer =false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_chapter_three_numbers);
        myButton1 =  findViewById(R.id.arrow_left);
        myButton2 =  findViewById(R.id.arrow_right);
        myNumber= findViewById(R.id.addition);


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            AudioAttributes audioAttributes = new AudioAttributes.Builder()
                    .setUsage(AudioAttributes.USAGE_ASSISTANCE_SONIFICATION)
                    .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                    .build();

            sound = new SoundPool.Builder()
                    .setMaxStreams(9)
                    .setAudioAttributes(audioAttributes)
                    .build();
        } else {
            sound = new SoundPool(4, AudioManager.STREAM_MUSIC, 0);
        }

        soundOne = sound.load(this, R.raw.one_plus_zero_one, 1);

        soundTwo= sound.load(this, R.raw.one_plus_one_two, 1);
        soundThree = sound.load(this, R.raw.one_plus_two_three, 1);
        soundFour= sound.load(this, R.raw.two_plus_two_four, 1);





        mMediaPlayer = MediaPlayer.create(this, R.raw.one_plus_zero_one);


        mMediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        mMediaPlayer.start();


    }

    int [] myNumbersArray = {R.drawable.one_plus_zero, R.drawable.one_plus_one_two,
            R.drawable.one_plus_two_three,
            R.drawable.two_plus_two_four};



    class MyClass{
        int position = 0;

        public void next(){

            this.position++;
        }

        public void prev()
        {
            this.position--;
        }
    }

    MyClass myClassObject =  new MyClass();



    public void changeNumber(View v) {
        if (v.getId() == R.id.arrow_left) {
            myClassObject.prev();

            if (myClassObject.position < 0) {
                myClassObject.position = 3;
            }
            playNumber(v);
            myNumber.setBackgroundResource(myNumbersArray[myClassObject.position]);
        }

        else if(v.getId() == R.id.arrow_right){
            myClassObject.next();
            if (myClassObject.position > 3) {
                myClassObject.position = 0;
            }
            playNumber(v);

            myNumber.setBackgroundResource(myNumbersArray[myClassObject.position]);
        }



    }

    //sound related code
    public void playNumber(View v) {
        switch(myClassObject.position){
            case 0: sound.play(soundOne, 1, 1, 0, 0, 1);
                break;
            case 1:sound.play(soundTwo, 1, 1, 0, 0, 1);
                break;
            case 2:sound.play(soundThree, 1, 1, 0, 0, 1);
                break;
            case 3:sound.play(soundFour, 1, 1, 0, 0, 1);
                break;

        }
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        sound.release();
        sound= null;

    }
    public  void goHome(View v){
        Intent goHome = new Intent(ChapterThreeNumbers.this, MainActivity.class);
        startActivity(goHome);
        finish();
        overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);

    }

}


