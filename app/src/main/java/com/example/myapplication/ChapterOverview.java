package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ChapterOverview extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter_overview);
    }

    public void chapter1(View v){
        Intent goToChapter = new Intent(ChapterOverview.this, ChapterOneNumbers.class);
        startActivity(goToChapter);
    }
    public void chapter2(View v){
        Intent goToChapter = new Intent(ChapterOverview.this, ChapterTwoNumbers.class);
        startActivity(goToChapter);}
    public void goHome(View v){
        Intent goToChapter = new Intent(ChapterOverview.this, MainActivity.class);
        startActivity(goToChapter);}

    public void chapter3(View v){
        Intent goToChapter = new Intent(ChapterOverview.this, ChapterThreeNumbers.class);
        startActivity(goToChapter);}
}


