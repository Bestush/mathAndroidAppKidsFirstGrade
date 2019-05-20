package com.example.myapplication;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button button_kid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button_kid = findViewById(R.id.button_kid);
    }


        public void goToNumbers(View v){
        Intent goToNumber = new Intent(MainActivity.this, ChapterOverview.class);
        startActivity(goToNumber);
            overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);

        }
//
    public void goToQuestions(View v){
        Intent goToChapter = new Intent(MainActivity.this, ChapterOverviewQuestions.class);
        startActivity(goToChapter);
        overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);

    }
}
