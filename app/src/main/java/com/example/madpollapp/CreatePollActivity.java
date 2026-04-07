package com.example.madpollapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

// HITHASHREE's file - Screen 1
public class CreatePollActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_poll);  // ⚠️ This XML must exist!

        EditText etQ = (EditText) findViewById(R.id.etQuestion);
        EditText etA = (EditText) findViewById(R.id.etOptionA);
        EditText etB = (EditText) findViewById(R.id.etOptionB);
        Button btn   = (Button)   findViewById(R.id.btnCreate);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String q = etQ.getText().toString().trim();
                String a = etA.getText().toString().trim();
                String b = etB.getText().toString().trim();

                if (q.isEmpty() || a.isEmpty() || b.isEmpty()) {
                    Toast.makeText(CreatePollActivity.this, "Fill all fields!", Toast.LENGTH_SHORT).show();
                    return;
                }

                PollManager.savePoll(CreatePollActivity.this, q, a, b);
                startActivity(new Intent(CreatePollActivity.this, VoteActivity.class));
                finish();
            }
        });
    }
}