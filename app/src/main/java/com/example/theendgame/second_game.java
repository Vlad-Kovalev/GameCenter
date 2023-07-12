package com.example.theendgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.Random;

public class second_game extends AppCompatActivity {

    ImageButton btnBack;
    ImageView ivFirstDice , ivSecondDice;
    Button btnRandom;
    TextView tvRandomizer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_game);
        if (getSupportActionBar() != null) {getSupportActionBar().hide();}

        btnBack = findViewById(R.id.btnBack);
        btnRandom = findViewById(R.id.btnRandom);
        tvRandomizer = findViewById(R.id.tvRandomizer);
        ivFirstDice = findViewById(R.id.ivFirstDice);
        ivSecondDice = findViewById(R.id.ivSecondDice);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(second_game.this, center.class);
                startActivity(intent);
            }
        });

        btnRandom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getIntent();
                String recivedText = intent.getStringExtra("keyname");
                int randomNum = 0, randomNum2 = 0;
                for(int i =0;i<=2; i++){
                    Random r = new Random();
                    int low = 1, high = 7;
                    int result = r.nextInt(high-low) + low;
                    if (i == 0) randomNum = result;
                    else if (i == 1) randomNum2 = result;
                }
                int randomSum = randomNum + randomNum2;
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        tvRandomizer.setText(recivedText + " the number is: " + randomSum);
                    }
                },500);

                if (randomNum == 1) ivFirstDice.setImageResource(R.drawable.dice1); else if (randomNum == 2) ivFirstDice.setImageResource(R.drawable.dice2); else if (randomNum == 3) ivFirstDice.setImageResource(R.drawable.dice3); else if (randomNum == 4) ivFirstDice.setImageResource(R.drawable.dice4); else if (randomNum == 5) ivFirstDice.setImageResource(R.drawable.dice5); else if (randomNum == 6) ivFirstDice.setImageResource(R.drawable.dice6);
                if (randomNum2 == 1) ivSecondDice.setImageResource(R.drawable.dice1); else if (randomNum2 == 2) ivSecondDice.setImageResource(R.drawable.dice2); else if (randomNum2 == 3) ivSecondDice.setImageResource(R.drawable.dice3); else if (randomNum2 == 4) ivSecondDice.setImageResource(R.drawable.dice4); else if (randomNum2 == 5) ivSecondDice.setImageResource(R.drawable.dice5); else if (randomNum2 == 6) ivSecondDice.setImageResource(R.drawable.dice6);
            }


        });
    }
}