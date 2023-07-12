package com.example.theendgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.Random;

public class dice_roll extends AppCompatActivity {

    ImageButton btnBack;
    ImageView ivFirstDice , ivSecondDice;
    Button btnRandom;
    TextView tvRandomizer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dice_roll);
        if (getSupportActionBar() != null) {getSupportActionBar().hide();}

        btnBack = findViewById(R.id.btnBack);
        btnRandom = findViewById(R.id.btnRandom);
        tvRandomizer = findViewById(R.id.tvRandomizer);
        ivFirstDice = findViewById(R.id.ivFirstDice);
        ivSecondDice = findViewById(R.id.ivSecondDice);

        btnBack.setOnClickListener(v -> {
            Intent intent = new Intent(dice_roll.this, center.class);
            startActivity(intent);
        });

        btnRandom.setOnClickListener(v -> {
            Intent intent = getIntent();
            String recivedText = intent.getStringExtra("keyname");
            int[] randomNum = {0};
            int[] randomNum2 = {0};
            Handler handler = new Handler();
            for (int i = 0; i <= 7; i++) {
                handler.postDelayed(() -> {
                    for (int j = 0; j <= 2; j++) {
                        Random r = new Random();
                        int low = 1, high = 7;
                        int result = r.nextInt(high - low) + low;
                        if (j == 0) randomNum[0] = result;
                        else if (j == 1) randomNum2[0] = result;
                    }
                    int randomSum = randomNum[0] + randomNum2[0];
                    tvRandomizer.setText(recivedText + " the number is: " + randomSum);
                    if (randomNum[0] == 1) ivFirstDice.setImageResource(R.drawable.dice1); else if (randomNum[0] == 2) ivFirstDice.setImageResource(R.drawable.dice2); else if (randomNum[0] == 3) ivFirstDice.setImageResource(R.drawable.dice3); else if (randomNum[0] == 4) ivFirstDice.setImageResource(R.drawable.dice4); else if (randomNum[0] == 5) ivFirstDice.setImageResource(R.drawable.dice5); else if (randomNum[0] == 6) ivFirstDice.setImageResource(R.drawable.dice6);
                    if (randomNum2[0] == 1) ivSecondDice.setImageResource(R.drawable.dice1); else if (randomNum2[0] == 2) ivSecondDice.setImageResource(R.drawable.dice2); else if (randomNum2[0] == 3) ivSecondDice.setImageResource(R.drawable.dice3); else if (randomNum2[0] == 4) ivSecondDice.setImageResource(R.drawable.dice4); else if (randomNum2[0] == 5) ivSecondDice.setImageResource(R.drawable.dice5); else if (randomNum2[0] == 6) ivSecondDice.setImageResource(R.drawable.dice6);
                }, 90 * i);
            }
        });
    }
}