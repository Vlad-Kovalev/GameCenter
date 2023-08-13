package com.example.theendgame;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatSpinner;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class TruthOrDare extends AppCompatActivity {
    private ImageButton btnBack;
    private AppCompatButton btnAdd;
    private EditText etNameInput;
    private Spinner spinDropdown;
    private ArrayList<String> players = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_truth_or_dare);

        spinDropdown = (Spinner)findViewById(R.id.spinDropdown);
        etNameInput = findViewById(R.id.etNameInput);
        btnBack = findViewById(R.id.btnBack); btnAdd = findViewById(R.id.btnAdd);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TruthOrDare.this, center.class);
                startActivity(intent);
            }
        });
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                players.add(etNameInput.getText().toString());
            }
        });

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, players) {
            @Override
            public View getDropDownView(int position, View convertView, ViewGroup parent) {
                // Check if it's the first item (position 0)
                if (position == 0) {
                    // Inflate the custom layout for the dropdown
                    convertView = getLayoutInflater().inflate(R.layout.spinner_item_custom_message, parent, false);
                } else {
                    // For other positions, use the default dropdown view
                    convertView = super.getDropDownView(position, convertView, parent);
                }
                return convertView;
            }
        };
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinDropdown.setAdapter(adapter);
        spinDropdown.setSelection(0, true);

    }
}