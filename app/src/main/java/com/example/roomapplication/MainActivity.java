package com.example.roomapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button submitButton = findViewById(R.id.submit);
        Button viewButton = findViewById(R.id.view);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startSubmitActivity();
            }
        });

        viewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startViewActivity();
            }
        });
    }


    private void startSubmitActivity() {
        Intent intent = new Intent(this, SubmitActivity.class);
        startActivity(intent);
    }

    private void startViewActivity() {
        Intent intent = new Intent(this, ViewActivity.class);
        startActivity(intent);
    }
}
