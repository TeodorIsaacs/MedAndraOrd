package com.thi.ppm.medandraord;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

import java.util.ArrayList;

public class TeamConfigActivity extends AppCompatActivity {

    public static final String ALL_TEAMS = "com.thi.ppm.allTeams";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_config);
    }

    public void teamContinue(View view){
        Intent intent = new Intent(this, GameActivity.class);

        CheckBox teamCheck1 = (CheckBox) findViewById(R.id.teamCheck1);
        CheckBox teamCheck2 = (CheckBox) findViewById(R.id.teamCheck2);
        CheckBox teamCheck3 = (CheckBox) findViewById(R.id.teamCheck3);
        CheckBox teamCheck4 = (CheckBox) findViewById(R.id.teamCheck4);
        CheckBox teamCheck5 = (CheckBox) findViewById(R.id.teamCheck5);
        CheckBox teamCheck6 = (CheckBox) findViewById(R.id.teamCheck6);

        ArrayList<String> teamList = new ArrayList<>();

        if (teamCheck1.isChecked()){
            EditText teamName1 = (EditText) findViewById(R.id.teamName1);
            String teamname = teamName1.getText().toString();
            teamList.add(teamname);
        }
        if (teamCheck2.isChecked()){
            EditText teamName2 = (EditText) findViewById(R.id.teamName2);
            String teamname = teamName2.getText().toString();

            teamList.add(teamname);
        }
        if (teamCheck3.isChecked()){
            EditText teamName3 = (EditText) findViewById(R.id.teamName3);
            String teamname = teamName3.getText().toString();

            teamList.add(teamname);
        }
        if (teamCheck4.isChecked()){
            EditText teamName4 = (EditText) findViewById(R.id.teamName4);
            String teamname = teamName4.getText().toString();

            teamList.add(teamname);
        }
        if (teamCheck5.isChecked()){
            EditText teamName5 = (EditText) findViewById(R.id.teamName5);
            String teamname = teamName5.getText().toString();

            teamList.add(teamname);
        }
        if (teamCheck6.isChecked()){
            EditText teamName6 = (EditText) findViewById(R.id.teamName6);
            String teamname = teamName6.getText().toString();

            teamList.add(teamname);
        }

        intent.putExtra(ALL_TEAMS, teamList);

        startActivity(intent);
    }
}
