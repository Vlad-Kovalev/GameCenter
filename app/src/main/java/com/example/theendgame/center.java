package com.example.theendgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class center extends AppCompatActivity {

    ImageView ibEasy, ibMedium;
    EditText etName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_center);
        if (getSupportActionBar() != null) {getSupportActionBar().hide();}

        ibEasy = findViewById(R.id.ivMemoryGame);
        ibMedium = findViewById(R.id.ivDiceRoll);
        etName = findViewById(R.id.etName);


        ibEasy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etName.getText().toString();
                Intent intent = new Intent(center.this, memory_game.class);
                intent.putExtra("keyname", name);
                startActivity(intent);
            }
         });

        ibMedium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etName.getText().toString();
                Intent intent = new Intent(center.this, dice_roll.class);
                intent.putExtra("keyname", name);
                startActivity(intent);
            }
        });

    }
}