package com.example.theendgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class second_game extends AppCompatActivity {

    ImageButton btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_game);
        if (getSupportActionBar() != null) {getSupportActionBar().hide();}

        btnBack = findViewById(R.id.btnBack);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(second_game.this, center.class);
                startActivity(intent);
            }
        });

        //Intent intent = getIntent();
        //String receivedText = intent.getStringExtra("keyname");
        //TextView textView = findViewById(R.id.tvMsg);
        //textView.setText("שלום " + receivedText + ", משחק זה עדיין בבניה!");


    }
}