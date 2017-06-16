package com.thi.ppm.medandraord;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.thi.ppm.medandraord.R.layout.activity_main);
    }

    /** Called when the user taps the Send button */
    public void startGame(View view) {
        Intent intent = new Intent(this, TeamConfigActivity.class);
        startActivity(intent);
    }
}
