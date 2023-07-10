package com.example.theendgame;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;
import android.widget.ImageButton;

public class diff_easy extends AppCompatActivity {

    TextView tvName;
    ImageButton card1, card2, card3, card4, card5, card6, card7, card8, btnBack;
    private ImageButton firstFlippedCard;
    private ImageButton secondFlippedCard;
    private AppCompatButton btnRestart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diff_easy);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        btnBack = findViewById(R.id.btnBack);
        btnRestart = findViewById(R.id.btnRestart);
        tvName = findViewById(R.id.tvName);
        card1 = findViewById(R.id.card1); card2 = findViewById(R.id.card2); card3 = findViewById(R.id.card3); card4 = findViewById(R.id.card4); card5 = findViewById(R.id.card5); card6 = findViewById(R.id.card6); card7 = findViewById(R.id.card7); card8 = findViewById(R.id.card8);

        card1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flipCard(card1);
            }
        });
        card2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flipCard(card2);
            }
        });
        card3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flipCard(card3);
            }
        });
        card4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flipCard(card4);
            }
        });
        card5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flipCard(card5);
            }
        });
        card6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flipCard(card6);
            }
        });
        card7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flipCard(card7);
            }
        });
        card8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flipCard(card8);
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(diff_easy.this, MainActivity.class);
                startActivity(intent);
            }
        });
        btnRestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                restartGame();
            }
        });

        Intent intent = getIntent();
        String receivedName = intent.getStringExtra("keyname");
        TextView textView = findViewById(R.id.tvName);
        textView.setText("Hello " + receivedName);
    }

    private void flipCard(ImageButton card) {
        if (firstFlippedCard == null) {
            firstFlippedCard = card;
            card.setImageResource(getImageResource(card));
        } else if (secondFlippedCard == null) {
            secondFlippedCard = card;
            card.setImageResource(getImageResource(card));

            if (getImageResource(firstFlippedCard) == getImageResource(secondFlippedCard)) {
                firstFlippedCard = null;
                secondFlippedCard = null;
            } else {
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        firstFlippedCard.setImageResource(R.drawable.card_back);
                        secondFlippedCard.setImageResource(R.drawable.card_back);
                        firstFlippedCard = null;
                        secondFlippedCard = null;
                    }
                }, 1000);
            }
        }
    }


    private int getImageResource(ImageButton card) {
        if (card == card1 || card == card2) {
            return R.drawable.firstpic;
        } else if (card == card3 || card == card4) {
            return R.drawable.secondpic;
        } else if (card == card5 || card == card6) {
            return R.drawable.thirdpic;
        } else if (card == card7 || card == card8) {
            return R.drawable.fourthpic;
        }
        return 0;
    }

    private void restartGame() {
        firstFlippedCard = null;
        secondFlippedCard = null;

        card1.setImageResource(R.drawable.card_back);
        card2.setImageResource(R.drawable.card_back);
        card3.setImageResource(R.drawable.card_back);
        card4.setImageResource(R.drawable.card_back);
        card5.setImageResource(R.drawable.card_back);
        card6.setImageResource(R.drawable.card_back);
        card7.setImageResource(R.drawable.card_back);
        card8.setImageResource(R.drawable.card_back);
    }
}