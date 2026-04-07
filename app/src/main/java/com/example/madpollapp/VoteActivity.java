package com.example.madpollapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

// ★ SHERIN's file — Screen 2 (YOUR FILE)
public class VoteActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vote);

        String[] poll   = PollManager.getPoll(this);
        TextView tvQ    = findViewById(R.id.tvQuestion);
        RadioButton rbA = findViewById(R.id.rbA);
        RadioButton rbB = findViewById(R.id.rbB);
        RadioGroup rg   = findViewById(R.id.radioGroup);
        Button btnVote  = findViewById(R.id.btnVote);

        tvQ.setText(poll[0]);
        rbA.setText(poll[1]);
        rbB.setText(poll[2]);

        btnVote.setOnClickListener(v -> {
            int selected = rg.getCheckedRadioButtonId();
            if (selected == -1) {
                Toast.makeText(this, "Please select an option!", Toast.LENGTH_SHORT).show();
                return;
            }
            PollManager.incrementVote(this, selected == R.id.rbA ? "A" : "B");
            startActivity(new Intent(this, ResultsActivity.class));
            finish();
        });
    }
}
