package com.rahulpwar654.bubbleindicator;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.rahulpwar654.bubbleindicatorlibrary.IndicatorClickListener;
import com.rahulpwar654.bubbleindicatorlibrary.NumberedIndicator;


public class MainActivity extends AppCompatActivity implements IndicatorClickListener {

    NumberedIndicator numberedIndicator;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numberedIndicator= (NumberedIndicator) findViewById(R.id.numberedindicator);

        /**
         *
         */

        numberedIndicator.setBubbleNumbers(4);
        numberedIndicator.setBackgroundColor(Color.WHITE);
        numberedIndicator.setBubbleWidgetClickListener(this);




    }

    @Override
    public void onBubbleClicked(int bubbleNum) {

        Toast.makeText(this, ""+bubbleNum+" clicked ", Toast.LENGTH_SHORT).show();


    }
}
