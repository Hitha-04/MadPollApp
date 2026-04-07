package com.example.madpollapp;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

// HITHASHREE's file — routes to correct screen on launch
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (PollManager.pollExists(this)) {
            startActivity(new Intent(this, VoteActivity.class));
        } else {
            startActivity(new Intent(this, CreatePollActivity.class));
        }
        finish();
    }
}
