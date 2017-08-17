package com.londonappbrewery.destini;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static android.R.attr.button;
import static android.R.attr.right;
import static android.view.View.Y;

public class MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here:
    int mIndex = 0;
    int mfinCount = 1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:
        final  TextView storyText = (TextView) findViewById(R.id.storyTextView);
        final Button topButton = (Button) findViewById(R.id.buttonTop);
        final Button bottomButton = (Button) findViewById(R.id.buttonBottom);

        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:
        topButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mIndex == 0) {
                    storyText.setText(R.string.T3_Story);
                    topButton.setText(R.string.T3_Ans1);
                    bottomButton.setText(R.string.T3_Ans2);
                } else if (mIndex == 1) {
                    storyText.setText(R.string.T6_End);
                    storyEnd();
                } else if (mIndex == 10) {
                    mIndex = 0;
                    storyText.setText(R.string.T3_Story);
                    topButton.setText(R.string.T3_Ans1);
                    bottomButton.setText(R.string.T3_Ans2);
                }


                mIndex = mIndex + 1;
            }
        });


        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:
        bottomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mIndex == 0) {
                    storyText.setText(R.string.T2_Story);
                    topButton.setText(R.string.T2_Ans1);
                    bottomButton.setText(R.string.T2_Ans2);
                } else if (mIndex == 1) {
                    storyText.setText(R.string.T5_End);
                    storyEnd();
                } else if (mIndex == 10) {
                    storyText.setText(R.string.T4_End);
                    storyEnd();
                }


                mIndex = mIndex + 10;
            }
        });
    }

    public void storyEnd() {
        final Button topButton = (Button) findViewById(R.id.buttonTop);
        final Button bottomButton = (Button) findViewById(R.id.buttonBottom);
        final String[] finResponse = {
                "fin.", //0
                "fin..",
                "fin...",
                "I said fin.",
                "FIN.",
                "F I N.", //5
                "Stop it.",
                "Stop.",
                "You aren't funny.",
                "Close the app.",
                "The button is right there.", //10
                "Tap the other button.",
                "Fine.",
                "Tap me all day if it makes you happy.",
                "I have nothing better to do.",
                "I'm a button.", //15
                "I'll stop responding.",
                "Then you'll be tapping me for no reason",
                "like a moron.", //18
                "Fuck you",
                "I'm both buttons.", //20
                "Now what?",
                "Close the app like a pleb.",
                "You don't deserve a dedicated button.",
                "You've lost that chance", //24
                "SUCK",
                "IT"
        };

        topButton.setText(finResponse[0]);
        bottomButton.setText(R.string.end);

        topButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mfinCount < 19) {
                    topButton.setText(finResponse[mfinCount]);
                    mfinCount = mfinCount +1;
                } else if (mfinCount >=19 && mfinCount <= 24){
                    topButton.setText(finResponse[0]);
                } else {
                    topButton.setText(finResponse[25]);
                    bottomButton.setText(finResponse[26]);
                }
            }
        });

        bottomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mfinCount <= 18){
                    finish();
                } else if (mfinCount > 18 && mfinCount < 25){
                    bottomButton.setText(finResponse[mfinCount++]);
                } else {
                    topButton.setText(finResponse[25]);
                    bottomButton.setText(finResponse[26]);
                }

            }
        });
    }
}


