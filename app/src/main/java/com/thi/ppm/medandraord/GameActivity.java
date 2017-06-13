package com.thi.ppm.medandraord;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;


public class GameActivity extends AppCompatActivity {

    public String[] words;
    private TextView textView;
    private int count = 0;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.thi.ppm.medandraord.R.layout.activity_game);

        getWords();
        textView = (TextView) findViewById(com.thi.ppm.medandraord.R.id.textView);
        textView.setText(words[count]);

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
            textView.setText(words[++count]);
        } else {
            count = 0;
            textView.setText(words[count]);
        }
    }

    public void skipWord(View view){
        if(count < words.length - 1){
            textView.setText(words[++count]);
        } else {
            count = 0;
            textView.setText(words[count]);
        }
    }
}
