package com.rahulpwar654.bubbleindicator;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Toast;

import com.rahulpwar654.bubbleindicatorlibrary.AllNumberedIndicator;
import com.rahulpwar654.bubbleindicatorlibrary.BubbleIndicator;
import com.rahulpwar654.bubbleindicatorlibrary.IndicatorClickListener;
import com.rahulpwar654.bubbleindicatorlibrary.NumberedIndicator;


public class MainActivity extends Activity implements IndicatorClickListener {

    BubbleIndicator mBubbleIndicator;
    NumberedIndicator mNumberedIndicator;
    AllNumberedIndicator mAllNumberedIndicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mBubbleIndicator= (BubbleIndicator) findViewById(R.id.bubbleindicator);
        mNumberedIndicator= (NumberedIndicator) findViewById(R.id.numberedindicator);
        mAllNumberedIndicator= (AllNumberedIndicator) findViewById(R.id.allnumberedindicator);


        //Bubble Indicator
        mBubbleIndicator.setBubbleNumbers(4);
        mBubbleIndicator.setSelectedBubleNum(0);
        mBubbleIndicator.setBackgroundColor(Color.WHITE);
        mBubbleIndicator.setIndicatorClickListener(this);
        mBubbleIndicator.setDrawLine(false);


        //Single Numbered Indicator
        mNumberedIndicator.setBubbleNumbers(4);
        mNumberedIndicator.setSelectedBubleNum(0);
        mNumberedIndicator.setBackgroundColor(Color.WHITE);
        mNumberedIndicator.setIndicatorClickListener(this);

        //ALL Numbered Indicator
        mAllNumberedIndicator.setBubbleNumbers(4);
        mAllNumberedIndicator.setSelectedBubleNum(0);
        mAllNumberedIndicator.setBackgroundColor(Color.WHITE);
        mAllNumberedIndicator.setIndicatorClickListener(this);
        mAllNumberedIndicator.setDrawLine(false);



    }

    @Override
    public void onBubbleClicked(int bubbleNum) {
        Toast.makeText(this, "Bubble "+(bubbleNum+1)+" clicked ", Toast.LENGTH_SHORT).show();
        mBubbleIndicator.setSelectedBubleNum(bubbleNum);
        mNumberedIndicator.setSelectedBubleNum(bubbleNum);
        mAllNumberedIndicator.setSelectedBubleNum(bubbleNum);
    }
}
