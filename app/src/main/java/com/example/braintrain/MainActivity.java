package com.example.braintrain;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button goButt;
    ArrayList<Integer> answers = new ArrayList<Integer>();


    public void start(View view) {
        goButt.animate().alpha(0).setDuration(1000);
    }


    public void chooseAnswer(View view) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView sumTextView = findViewById(R.id.sumTextView);
        Button button0 = findViewById(R.id.button0);
        Button button1 = findViewById(R.id.button1);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);

        goButt = findViewById(R.id.buttonStart);


        Random rand = new Random();

        int a = rand.nextInt(21);
        int b = rand.nextInt(21);

        sumTextView.setText(Integer.toString(a) + " + " + Integer.toString(b));

        int locationCorrectAnswer = rand.nextInt(4);

        for (int i = 0; i < 4; i++) {
            if (i == locationCorrectAnswer) {
                answers.add(a + b);
            } else {
                int wrongAnswer = rand.nextInt(41);

                while (wrongAnswer == a+b) {
                    wrongAnswer = rand.nextInt(41);
                }
                answers.add(wrongAnswer);
            }
        }
    }
}