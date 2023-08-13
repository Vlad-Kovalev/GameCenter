package com.example.theendgame;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Collections;

public class memory_game extends AppCompatActivity {

    private TextView tvName;
    private GridLayout glCards;
    private ImageView ivCongrats, btnBack;
    private ImageView firstFlippedCard; private ImageView secondFlippedCard;
    private AppCompatButton btnRestart;
    private ImageView[] cards = new ImageView[8];
    private int tryCount = 1;
    private int matchedPairs = 0;
    private String receivedName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memory_game);
        if (getSupportActionBar() != null) {getSupportActionBar().hide();}

        Intent intent = getIntent();
        receivedName = intent.getStringExtra("keyname");
        tvName = findViewById(R.id.tvName); btnBack = findViewById(R.id.btnBack); btnRestart = findViewById(R.id.btnRestart); ivCongrats = findViewById(R.id.ivCongrats); glCards = findViewById(R.id.glCards);
        cards[0] = findViewById(R.id.card1); cards[1] = findViewById(R.id.card2); cards[2] = findViewById(R.id.card3); cards[3] = findViewById(R.id.card4); cards[4] = findViewById(R.id.card5); cards[5] = findViewById(R.id.card6); cards[6] = findViewById(R.id.card7); cards[7] = findViewById(R.id.card8);
        Collections.shuffle(Arrays.asList(cards));

        cards[0].setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {flipCard(cards[0]);}});
        cards[1].setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {flipCard(cards[1]);}});
        cards[2].setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {flipCard(cards[2]);}});
        cards[3].setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {flipCard(cards[3]);}});
        cards[4].setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {flipCard(cards[4]);}});
        cards[5].setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {flipCard(cards[5]);}});
        cards[6].setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {flipCard(cards[6]);}});
        cards[7].setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {flipCard(cards[7]);}});

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(memory_game.this, center.class);
                startActivity(intent);
            }
        });
        btnRestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recreate();
            }
        });
    }

    private void flipCard(ImageView card) {
        updateTryCount();
        if (firstFlippedCard == null) {
            firstFlippedCard = card;
            card.setImageResource(getImageResource(card));
            firstFlippedCard.setEnabled(false);
            tryCount++;
        }
        else if (secondFlippedCard == null) {
            secondFlippedCard = card;
            secondFlippedCard.setEnabled(false);
            card.setImageResource(getImageResource(card));

            if (getImageResource(firstFlippedCard) == getImageResource(secondFlippedCard)) {
                firstFlippedCard.setOnClickListener(null);
                secondFlippedCard.setOnClickListener(null);

                firstFlippedCard = null;
                secondFlippedCard = null;
                tryCount++;

                matchedPairs++;
                if (matchedPairs == 4) {
                    glCards.setVisibility(View.GONE);
                    ivCongrats.setVisibility(View.VISIBLE);
                    tvName.setVisibility(View.VISIBLE);
                    tryCount--;
                    int heightInDp = 55;
                    float scale = getResources().getDisplayMetrics().density;
                    int heightInPixels = (int) (heightInDp * scale + 0.5f);
                    tvName.getLayoutParams().height = heightInPixels; tvName.invalidate();
                    tvName.setText("Congratulations " + receivedName + "!\n" + "you won in " + tryCount + " turns");
                    btnRestart.setVisibility(View.VISIBLE);
                }
            } else {
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        firstFlippedCard.setImageResource(R.drawable.card_back);
                        secondFlippedCard.setImageResource(R.drawable.card_back);

                        firstFlippedCard.setEnabled(true);
                        secondFlippedCard.setEnabled(true);

                        firstFlippedCard = null;
                        secondFlippedCard = null;
                        tryCount++;
                    }
                }, 1000);
            }
        }
    }

    private int getImageResource(ImageView card) {
        if (card == cards[0] || card == cards[1]) {
            return R.drawable.firstpic;}
        else if (card == cards[2] || card == cards[3]) {
            return R.drawable.secondpic;}
        else if (card == cards[4] || card == cards[5]) {
            return R.drawable.thirdpic;}
        else if (card == cards[6] || card == cards[7]) {
            return R.drawable.fourthpic;}
        return R.drawable.card_back;
    }

    private void updateTryCount() {
        tvName.setVisibility(View.VISIBLE);
        if (tryCount == 1) tvName.setText(receivedName + " you clicked " + tryCount + " time");
        else tvName.setText(receivedName + " you clicked " + tryCount + " times");
    }
}