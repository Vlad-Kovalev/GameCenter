package com.example.theendgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;

public class FourInRow extends AppCompatActivity{

    private ImageButton btnBack;
    private View[] rows = new View[6];
    private ImageView[][] cols = new ImageView[6][7];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_four_in_row);
        if (getSupportActionBar() != null) {getSupportActionBar().hide();}

        btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FourInRow.this, center.class);
                startActivity(intent);
            }
        });

        for(int i = 0; i < rows.length; i++) {
            String rowId = "row" + (i + 1);
            int rowResId = getResources().getIdentifier(rowId, "id", getPackageName());
            rows[i] = ((View) findViewById(rowResId));
            // rows findViewById in loop

            for (int j = 0; j < cols[i].length; j++) {
                String circlesId = "col" + (j + 1);
                int circleResId = getResources().getIdentifier(circlesId, "id", getPackageName());
                cols[i][j] = ((ImageView) rows[i].findViewById(circleResId));

                // add click listener to each ImageView
                cols[i][j].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // Perform your action here
                        // For example, change the image of the clicked ImageView
                        ((ImageView)v).setImageResource(R.drawable.red_circle);
                    }
                });
            }       // cols findViewById and setting listeners in loop
        }
    }
}