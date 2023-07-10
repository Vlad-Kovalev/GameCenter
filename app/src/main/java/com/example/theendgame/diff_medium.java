package com.example.theendgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class diff_medium extends AppCompatActivity {

    ImageButton btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diff_medium);
        if (getSupportActionBar() != null) {getSupportActionBar().hide();}

        btnBack = findViewById(R.id.btnBack);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(diff_medium.this, MainActivity.class);
                startActivity(intent);
            }
        });

        //Intent intent = getIntent();
        //String receivedText = intent.getStringExtra("keyname");
        //TextView textView = findViewById(R.id.tvMsg);
        //textView.setText("שלום " + receivedText + ", משחק זה עדיין בבניה!");


    }
}