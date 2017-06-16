package com.thi.ppm.medandraord;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;


public class GameActivity extends AppCompatActivity {

    public String[] words;
    private TextView currentWord;
    private int count = 0;
    private int nOTeams = 2;
    private int[] teamScores;
    private int currentTeam = 0;
    private TextView currentScore;
    private int currentScoreInt = 0;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.thi.ppm.medandraord.R.layout.activity_game);

        /*
        Hur man kan hämta och displaya meddelanden från
        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String message = intent.getStringExtra(TeamConfigActivity.EXTRA_MESSAGE);

        // Capture the layout's TextView and set the string as its text
        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText(message);


        Eller

        String name = i.getStringExtra("name"); Så slipper man ett fält i gamla klassen kanske...
        String email = i.getStringExtra("email");
        */


        // Handle scores
        teamScores = new int[nOTeams];
        for (int i = 0; i < nOTeams; i++){
            teamScores[i] = 0;
        }
        currentScore = (TextView) findViewById(R.id.textView2);
        currentScore.setText(Integer.toString(currentScoreInt));

        // Fetches words, and displays first word
        getWords();
        currentWord = (TextView) findViewById(com.thi.ppm.medandraord.R.id.textView);
        currentWord.setText(words[count]);

        // Creates a thread for running the progress bar
        new Thread( new Runnable() {
            public void run() {
                ProgressBar progressBar = (ProgressBar) findViewById(com.thi.ppm.medandraord.R.id.progressBar3);
                int max = 60;
                int smoothfactor = 100;
                progressBar.setMax(max * smoothfactor);
                double lastTime = System.currentTimeMillis();
                while (progressBar.getProgress() < progressBar.getMax()) {
                    if (System.currentTimeMillis() >= lastTime + (1000/smoothfactor)) {
                        progressBar.incrementProgressBy(1);
                        lastTime += (1000/smoothfactor);
                    }
                }
            }
        }).start();
    }

    public void getWords(){
        Resources res = getResources();
        words = res.getStringArray(com.thi.ppm.medandraord.R.array.andra_ord);
    }

    public void nextWord(View view){
        if(count < words.length - 1) {
            currentWord.setText(words[++count]);
            teamScores[currentTeam] += 1;
            currentScoreInt++;
            currentScore.setText(Integer.toString(currentScoreInt));
        } else {
            count = 0;
            currentWord.setText(words[count]);
        }
    }

    public void skipWord(View view){
        if(count < words.length - 1){
            currentWord.setText(words[++count]);
        } else {
            count = 0;
            currentWord.setText(words[count]);
        }
    }
}
