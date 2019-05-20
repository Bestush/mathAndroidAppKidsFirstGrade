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

public class ChapterTwoNumbers extends AppCompatActivity {


    Button myButton1;
    Button myNumber;
    Button myButton2;
    MediaPlayer mMediaPlayer;



    //sound
    private SoundPool sound;
    private int soundOne, soundTwo, soundThree, soundFour, soundFive, soundSix, soundSeven, soundEight, soundNine;
    //    private boolean correctAnswer= false;
//    private boolean falseAnswer =false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_chapter_two_numbers);
        myButton1 =  findViewById(R.id.arrow_left);
        myButton2 =  findViewById(R.id.arrow_right);
        myNumber= findViewById(R.id.numbers);


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
            sound = new SoundPool(6, AudioManager.STREAM_MUSIC, 0);
        }

        soundOne = sound.load(this, R.raw.onev, 1);

        soundTwo= sound.load(this, R.raw.twov, 1);
        soundThree = sound.load(this, R.raw.threev, 1);
        soundFour= sound.load(this, R.raw.fourv, 1);
        soundFive = sound.load(this, R.raw.fivev, 1);
        soundSix= sound.load(this, R.raw.sixv, 1);
        soundSeven = sound.load(this, R.raw.sevenv, 1);
        soundEight = sound.load(this, R.raw.eightv, 1);
        soundNine = sound.load(this, R.raw.ninev, 1);







    }

    int [] myNumbersArray = {R.drawable.one, R.drawable.two, R.drawable.three,
            R.drawable.four, R.drawable.five,R.drawable.six, R.drawable.seven,
            R.drawable.eight, R.drawable.nine};



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
                myClassObject.position = 8;
            }
            playNumber(v);
            myNumber.setBackgroundResource(myNumbersArray[myClassObject.position]);
        }

        else if(v.getId() == R.id.arrow_right){
            myClassObject.next();
            if (myClassObject.position > 8) {
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
            case 4:sound.play(soundFive, 1, 1, 0, 0, 1);
                break;

            case 5:sound.play(soundSix, 1, 1, 0, 0, 1);
                break;
            case 6:sound.play(soundSeven, 1, 1, 0, 0, 1);
                break;
            case 7:sound.play(soundEight, 1, 1, 0, 0, 1);
                break;
            case 8:sound.play(soundNine, 1, 1, 0, 0, 1);
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
        Intent goHome = new Intent(ChapterTwoNumbers.this, MainActivity.class);
        startActivity(goHome);
        finish();
        overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);

    }

}


