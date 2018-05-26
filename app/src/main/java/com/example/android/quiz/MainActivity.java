package com.example.android.quiz;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    //initializing question values for radio questions, default is false
    int question1 = 0;
    int question2 = 0;
    int question3 = 0;

    //for radio questions lets user know which is the right answer
    String wrongQuestionOne = "One is the correct answer";
    String wrongQuestionTwo = "Two is the correct answer";
    String wrongQuestionThree = "Three is the correct answer";

    //initializing score
    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //when submit is clicked
    public void submitScore(View view) {

        //boolean values for check boxes question 1, could this be moved into it's own function
        CheckBox oneCheckQuestionOne = (CheckBox) findViewById(R.id.check_1_question_1);
        CheckBox twoCheckQuestionTwo = (CheckBox) findViewById(R.id.check_1_question_2);
        CheckBox threeCheckQuestionTwo = (CheckBox) findViewById(R.id.check_1_question_3);
        CheckBox fourCheckQuestionTwo = (CheckBox) findViewById(R.id.check_1_question_4);

        boolean hasCheckQuestionOne = oneCheckQuestionOne.isChecked();
        boolean hasCheckQuestionTwo = twoCheckQuestionTwo.isChecked();
        boolean hasCheckQuestionThree = threeCheckQuestionTwo.isChecked();
        boolean hasCheckQuestionFour = fourCheckQuestionTwo.isChecked();

        //get answer for fill question one and convert it to uppercase
        EditText answerFillQuestionOne = (EditText) findViewById(R.id.name);
        String fillQuestionOne = answerFillQuestionOne.getText().toString();

        fillQuestionOne = fillQuestionOne.toUpperCase();

        //Calculating radio questions portion of score
        score = question1 + question2 + question3;


        // used so we can add the answer to html could these be in there own function??
        TextView questionOneTextView = (TextView) findViewById(R.id.answer_radio_question_1);
        TextView questionTwoTextView = (TextView) findViewById(R.id.answer_radio_question_2);
        TextView questionThreeTextView = (TextView) findViewById(R.id.answer_radio_question_3);
        TextView questionOneCheckTextView = (TextView) findViewById(R.id.answer_check_question_1);
        TextView questionOneFillTextView = (TextView) findViewById(R.id.answer_fill_question_1);


        //lets user know if they were right or wrong
        displayMessageCheckBox(hasCheckQuestionOne, hasCheckQuestionTwo, hasCheckQuestionThree, hasCheckQuestionFour, questionOneCheckTextView);
        displayMessageRadioQuestion(question1, questionOneTextView, wrongQuestionOne);
        displayMessageRadioQuestion(question2, questionTwoTextView, wrongQuestionTwo);
        displayMessageRadioQuestion(question3, questionThreeTextView, wrongQuestionThree);
        displayMessageFillQuestion(questionOneFillTextView, fillQuestionOne);




        String message = finalScoreSummary(score);
        displayMessage(message);

    }

    //creates meessage for final score
    private String finalScoreSummary(int score) {
        String priceMessage = "Your final score is: " + score;

        return priceMessage;
    }

    // displays final score message
    private void displayMessage(String message) {
        TextView finalScoreTextView = (TextView) findViewById(R.id.final_score_text_view);
        finalScoreTextView.setText(message);
    }

    //used for radio questions need to add a string message showing right answer
    private void displayMessageRadioQuestion(int isCorrect, TextView answer, String wrongAnswer) {

        if (isCorrect == 1) {
            answer.setText("Correct");
        } else {
            answer.setText(wrongAnswer);
        }
    }

    private void displayMessageFillQuestion(TextView answer, String fillIN) {

        //checking to see if fill question one is correct should probably be moved to it's own function
        if (fillIN.equals("CAT")) {
            answer.setText("Correct");
            score++;
        } else {
            answer.setText("Wrong, it's spelled splat");
        }
    }

    //used for check box question, may need a different one for each need to add a string message showing right answer
    private void displayMessageCheckBox(Boolean A, Boolean B, Boolean C, Boolean D, TextView answer) {

        if (A && B && !C && !D) {
            answer.setText("Correct");
            score++;
        } else {
            answer.setText("Wrong, 1 & 2 Sir/Ma'am/gram");
        }
    }


    //checks all the radio questions
    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((android.widget.RadioButton) view).isChecked();

        // Check which radio button was clicked for radio question 1
        switch (view.getId()) {
            case R.id.radio_one:
                if (checked)
                    question1 = 1;// Correct
                break;
            case R.id.radio_two:
                if (checked)
                    question1 = 0;// wrong
            {
                break;
            }
            case R.id.radio_three:
                if (checked)
                    question1 = 0;// wrong
                break;
            case R.id.radio_four:
                if (checked)
                    question1 = 0;// wrong
            {
                break;
            }
        }

        // Check which radio button was clicked for radio question 2
        switch (view.getId()) {
            case R.id.radio2_one:
                if (checked)
                    question2 = 0;// wrong
                break;
            case R.id.radio2_two:
                if (checked)
                    question2 = 1;// right
                break;
            case R.id.radio2_three:
                if (checked)
                    question2 = 0;// wrong
                break;
            case R.id.radio2_four:
                if (checked)
                    question2 = 0;// wrong
            {
                break;
            }
        }

        // Check which radio button was clicked for radio question 3
        switch (view.getId()) {
            case R.id.radio3_one:
                if (checked)
                    question3 = 0; // wrong
                break;
            case R.id.radio3_two:
                if (checked)
                    question3 = 0; // wrong
                break;
            case R.id.radio3_three:
                if (checked)
                    question3 = 1; // right
                break;
            case R.id.radio3_four:
                if (checked)
                    question3 = 0; // wrong
            {
                break;
            }
        }
    }


}
