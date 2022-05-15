package edu.ewubd.counterapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView showCounter;
    private Button btstart,btreset,btpause,btexit;

    private int id = 2019162001;

    boolean flag=false,pause=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showCounter = findViewById(R.id.counter);
        btstart = findViewById(R.id.btstart);
        btreset = findViewById(R.id.btreset);
        btpause = findViewById(R.id.btpause);
        btexit = findViewById(R.id.btexit);

        btexit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();

            }
        });
        btstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                flag=true;
                counter i = new counter();
                i.execute(flag);
                pause=false;

            }
        });
        btreset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pause=true;
                id=2019162001;
                showCounter.setText(String.valueOf(id));

            }
        });
        btpause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pause=!pause;

            }
        });

    }
    class counter extends AsyncTask<Boolean,Integer,Integer>{


        @Override
        protected Integer doInBackground(Boolean... booleans) {
            while(booleans[0])
            {
                if(!pause){
                    id--;
                    publishProgress(id);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }


            }
            return null;
        }
        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            showCounter.setText(String.valueOf(id));
        }
    }
}