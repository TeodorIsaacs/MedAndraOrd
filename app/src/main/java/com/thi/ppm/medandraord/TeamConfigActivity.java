package com.thi.ppm.medandraord;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

public class TeamConfigActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.thi.ppm.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_config);
    }

    public void teamContinue(View view){
        /* Alternativ lösning på att skicka typ.
        //Sending data to another Activity
                //Starting a new Intent
                Intent nextScreen = new Intent(getApplicationContext(), SecondScreenActivity.class);

                nextScreen.putExtra("name", inputName.getText().toString());
                nextScreen.putExtra("email", inputEmail.getText().toString());

                startActivity(nextScreen)
         */
        Intent intent = new Intent(this, GameActivity.class);

        //TODO get names for the checked boxes
        /*
        CheckBox teamCheck1 = (CheckBox) findViewById(R.id.teamCheck1);
        */
        //TODO Fixa så att team names skickas till nästa screen
        /*EditText teamName1 = (EditText) findViewById(R.id.teamName1);
        String message = teamName1.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);*/
        startActivity(intent);
    }
}
