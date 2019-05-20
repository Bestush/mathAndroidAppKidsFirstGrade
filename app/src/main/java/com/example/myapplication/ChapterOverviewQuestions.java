package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ChapterOverviewQuestions extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter_overview_questions);
    }




    public void chapter2Questions(View v) {
        Intent goToChapter = new Intent(ChapterOverviewQuestions.this, Chapter2.class);
        startActivity(goToChapter);
        overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);

    }
    public void chapter1Questions(View v) {
        Intent goToChapter = new Intent(ChapterOverviewQuestions.this, Chapter1.class);
        startActivity(goToChapter);
        overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);

    }
    //
    public void goHome(View v){
        Intent goHome = new Intent(ChapterOverviewQuestions.this, MainActivity.class);
        startActivity(goHome);
        finish();
        overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
    }

    public void chapter3Questions(View v){
        Intent goToChapter = new Intent(ChapterOverviewQuestions.this, Chapter3.class);
        startActivity(goToChapter);
        overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);

    }
}


