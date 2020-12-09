package com.example.braintrain;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button goButt;
    ArrayList<Integer> answers = new ArrayList<Integer>();
    int locationCorrectAnswer;
    TextView resultTextView;
    int score = 0;
    int numberOfQuestions = 0;

    TextView scoreTextView;
    TextView sumTextView;
    TextView timerTextView;

    Button button0;
    Button button1;
    Button button2;
    Button button3;



    public void chooseAnswer(View view) {
        if (Integer.toString(locationCorrectAnswer).equals(view.getTag().toString())) {
            resultTextView.setText("Correct!");
            //adds a point to the player.
            score++;
        } else {
            resultTextView.setText("Wrong!");
        }
        numberOfQuestions++;
        scoreTextView.setText(Integer.toString(score) + "/" + Integer.toString(numberOfQuestions));
        newQuestion();
    }


    public void start(View view) {
        goButt.animate().alpha(0).setDuration(1000);
    }


    public void newQuestion() {

        Random rand = new Random();

        int a = rand.nextInt(21);
        int b = rand.nextInt(21);

        sumTextView.setText(Integer.toString(a) + " + " + Integer.toString(b));

        locationCorrectAnswer = rand.nextInt(4);

        answers.clear();

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

        button0.setText(Integer.toString(answers.get(0)));
        button1.setText(Integer.toString(answers.get(1)));
        button2.setText(Integer.toString(answers.get(2)));
        button3.setText(Integer.toString(answers.get(3)));


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sumTextView = findViewById(R.id.sumTextView);
        button0 = findViewById(R.id.button0);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        resultTextView = findViewById(R.id.textView4);
        scoreTextView = findViewById(R.id.scoreTextView);
        timerTextView = findViewById(R.id.timerTextView);

        goButt = findViewById(R.id.buttonStart);

        newQuestion();

        new CountDownTimer(30100, 1000) {


            @Override
            public void onTick(long millisUntilFinished) {
               timerTextView.setText(String.valueOf(millisUntilFinished / 1000) + "s");
            }

            @Override
            public void onFinish() {
                resultTextView.setText("Time's Up!");
            }
        }.start();


    }
}