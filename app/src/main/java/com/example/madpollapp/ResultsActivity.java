package com.example.madpollapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

// JEEVA's file — Screen 3
public class ResultsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        String[] poll  = PollManager.getPoll(this);
        int[] votes    = PollManager.getVotes(this);
        int total      = votes[0] + votes[1];
        int pctA = total == 0 ? 0 : (votes[0] * 100 / total);
        int pctB = total == 0 ? 0 : (votes[1] * 100 / total);

        ((TextView)    findViewById(R.id.tvResultA)).setText(poll[1] + ": " + votes[0] + " votes (" + pctA + "%)");
        ((TextView)    findViewById(R.id.tvResultB)).setText(poll[2] + ": " + votes[1] + " votes (" + pctB + "%)");
        ((ProgressBar) findViewById(R.id.pbA)).setProgress(pctA);
        ((ProgressBar) findViewById(R.id.pbB)).setProgress(pctB);

        findViewById(R.id.btnReset).setOnClickListener(v -> {
            PollManager.resetPoll(this);
            startActivity(new Intent(this, CreatePollActivity.class));
            finish();
        });
    }
}
