package com.example.theendgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.android.material.imageview.ShapeableImageView;

public class center extends AppCompatActivity {

    ShapeableImageView ivMemoryGame, ivTruthOrDare, ivDiceRoll, ivFourInRow;
    EditText etName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_center);
        if (getSupportActionBar() != null) {getSupportActionBar().hide();}

        ivMemoryGame = findViewById(R.id.ivMemoryGame);
        ivTruthOrDare = findViewById(R.id.ivTruthOrDare);
        ivDiceRoll = findViewById(R.id.ivDiceRoll);
        ivFourInRow = findViewById(R.id.ivFourInRow);
        etName = findViewById(R.id.etName);


        ivMemoryGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etName.getText().toString();
                Intent intent = new Intent(center.this, memory_game.class);
                intent.putExtra("keyname", name);
                startActivity(intent);
            }
         });

        ivTruthOrDare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etName.getText().toString();
                Intent intent = new Intent(center.this, TruthOrDare.class);
                intent.putExtra("keyname", name);
                startActivity(intent);
            }
        });

        ivDiceRoll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etName.getText().toString();
                Intent intent = new Intent(center.this, dice_roll.class);
                intent.putExtra("keyname", name);
                startActivity(intent);
            }
        });

        ivFourInRow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etName.getText().toString();
                Intent intent = new Intent(center.this, FourInRow.class);
                intent.putExtra("keyname", name);
                startActivity(intent);
            }
        });

    }
}