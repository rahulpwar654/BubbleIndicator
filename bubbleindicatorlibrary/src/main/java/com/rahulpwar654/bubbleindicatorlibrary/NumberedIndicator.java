package com.rahulpwar654.bubbleindicatorlibrary;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by warlord on 6/18/2017.
 */

public class NumberedIndicator extends View {

    private int desiredWidth = 300;
    private int desiredHeight = 60;
    private int cellwidth=0;
    private int bubbleNum=4;

    private IndicatorClickListener mIndicatorClickListener;

    int selectedBubleNum=0;


    private int largeBubbleRad=0;
    private int smallBubbleRad=0;

    private Paint mPaintOuter;
    private Paint mPaintPercent,mOuterCircle;
    private Paint mInnerCircle, mTextPaint,mTextPaintSmall;
    private Paint mPaintline,mPaintlineGray;
    private Paint mPaintGray;
    private static final String singleChar="+";
    int txtSize= 0;



    public NumberedIndicator(Context context) {
        super(context);
        initialization();
    }

    public NumberedIndicator(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initialization();
    }

    public NumberedIndicator(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initialization();
    }






    private void initialization() {

        mPaintOuter = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaintOuter.setColor(Color.WHITE);

        mPaintPercent = new Paint(Paint.ANTI_ALIAS_FLAG);
        // mPaintPercent.setColor(Color.CYAN);
        mPaintPercent.setColor(Color.parseColor("#4AD562"));

        mInnerCircle = new Paint(Paint.ANTI_ALIAS_FLAG);
        mInnerCircle.setColor(Color.parseColor("#4AD562"));
        mInnerCircle.setStrokeCap(Paint.Cap.ROUND);

        mPaintline = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaintline.setColor(Color.parseColor("#4AD562"));
        mPaintline.setStrokeCap(Paint.Cap.SQUARE);
        mPaintline.setStrokeWidth(5);

        mPaintlineGray = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaintlineGray.setColor(Color.parseColor("#9B9B9B"));
        mPaintlineGray.setStrokeCap(Paint.Cap.SQUARE);
        mPaintlineGray.setStrokeWidth(5);



        mOuterCircle = new Paint(Paint.ANTI_ALIAS_FLAG);
        mOuterCircle.setColor(Color.parseColor("#4990E2"));
        mOuterCircle.setStrokeCap(Paint.Cap.ROUND);

        mPaintGray = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaintGray.setColor(Color.parseColor("#9B9B9B"));
        mPaintGray.setStrokeCap(Paint.Cap.ROUND);




        mTextPaint = new Paint();
        //mTextPaint.setColor(Color.CYAN);
        mTextPaint.setColor(Color.parseColor("#4AD562"));
        // mTextPaint.setTextSize(textSize);


        mTextPaintSmall = new Paint();
        //mTextPaint.setColor(Color.CYAN);
        mTextPaintSmall.setColor(Color.WHITE);
        mTextPaintSmall.setTextSize(25);
        mTextPaintSmall.setTypeface(Typeface.DEFAULT);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int xwidth=cellwidth;
        /**
         * Draw line first
         */
        if(selectedBubleNum!=0)
        {
            //blue line
            canvas.drawLine(cellwidth,(desiredHeight/2),(cellwidth*(selectedBubleNum+1)),(desiredHeight/2),mPaintline);
            //gray line
            canvas.drawLine(cellwidth*(selectedBubleNum+1),(desiredHeight/2),(desiredWidth-cellwidth),(desiredHeight/2),mPaintlineGray);
        }else{
            canvas.drawLine(cellwidth,(desiredHeight/2),(desiredWidth-cellwidth),(desiredHeight/2),mPaintlineGray);
        }


        /**
         * Draw circle
         */
        for(int i=0;i<bubbleNum;i++){

            if(i<selectedBubleNum)
            {
                // canvas.drawLine(xwidth,(desiredHeight/2),(xwidth+cellwidth),(desiredHeight/2),mPaintline);
                //canvas.drawCircle(xwidth, (desiredHeight / 2), largeBubbleRad, mOuterCircle);
                canvas.drawCircle(xwidth, (desiredHeight / 2), smallBubbleRad, mInnerCircle);
            }else
            if(i==selectedBubleNum) {
                //canvas.drawLine(xwidth,(desiredHeight/2),(xwidth+cellwidth),(desiredHeight/2),mPaintline);
                canvas.drawCircle(xwidth, (desiredHeight / 2), largeBubbleRad, mOuterCircle);
            }else{
                canvas.drawCircle(xwidth, (desiredHeight / 2), smallBubbleRad, mPaintGray);
            }
            xwidth+=cellwidth;
        }



        int textWidth = (int) mTextPaintSmall.measureText(singleChar, 0, singleChar.length());
        int diff=textWidth/2;
        canvas.drawText(""+(selectedBubleNum+1),(cellwidth*(selectedBubleNum+1)-diff),(desiredHeight/2)+(diff+4),mTextPaintSmall);
       /* mCenterTextposition=cellwidth*(selectedBubleNum+1)-diff;*/


    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);


        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);

        //setWidgetWidth((int) (widthSize * 0.6));
        //setWidgetHeight((int) (heightSize * 0.6));

        int width;
        int height;

        width=widthSize;
        height=heightSize;

        /*//Measure Width
        if (widthMode == MeasureSpec.EXACTLY) {
            width = widthSize;
        } else if (widthMode == MeasureSpec.AT_MOST) {
            width = Math.min(getWidgetWidth(), widthSize);
        } else {
            width = getWidgetWidth();
        }

        if (heightMode == MeasureSpec.EXACTLY) {
            height = heightSize;
        } else if (heightMode == MeasureSpec.AT_MOST) {
            height = Math.min(getWidgetHeight(), heightSize);
        } else {
            height = getWidgetHeight();
        }*/

        //setWidgetWidth(width);
        //setWidgetHeight(height);
        //cellwidth=desiredWidth/(bubbleNum+1);
        //setWidgetHeight((int) (cellwidth*1.5));

        setData(width,height);
        //getUpdateRadius();

        setMeasuredDimension(desiredWidth,desiredHeight);
        //setWidgetWidth(width);

    }



    private void setData(int width, int height)
    {
        cellwidth=width/(bubbleNum+1);
        largeBubbleRad=(cellwidth/4)+4;
        smallBubbleRad=(cellwidth/8);

        txtSize=(2*largeBubbleRad)-14;
        mTextPaintSmall.setTextSize(txtSize);

        setWidgetWidth(width);
        setWidgetHeight((2*largeBubbleRad)+5);

        /*largeBubbleRad=(cellwidth/3)-4;
        smallBubbleRad=(cellwidth/3)-16;*/

    }

    public int getWidgetWidth() {
        return desiredWidth;
    }

    public void setWidgetWidth(int clockWidgetWidth) {

        this.desiredWidth = clockWidgetWidth;
    }

    public int getWidgetHeight() {
        return desiredHeight;
    }

    public void setWidgetHeight(int clockWidgetHeight) {
        this.desiredHeight = clockWidgetHeight;
    }


    public void setBubbleNumbers(int num){
        this.bubbleNum=num;
        invalidate();
    }

    public int getBubbleNum() {
        return bubbleNum;
    }
    public int getSelectedBubleNum() {
        return selectedBubleNum;
    }

    public void setSelectedBubleNum(int selectedBubleNum) {
        /**
         * indexing starts from 0
         */


        if(selectedBubleNum<bubbleNum) {
            this.selectedBubleNum = selectedBubleNum;
            invalidate();
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getActionMasked();

        switch (action)
        {

            case MotionEvent.ACTION_DOWN:
                float initialX = event.getX();
                float initialY = event.getY();

                Log.e("---"," x   "+initialX+"     y"+initialY);
                //Log.d(TAG, "Action was DOWN");

                //if((initialX/cellwidth)>=1 && (initialX%cellwidth)<=smallBubbleRad )
                //if((initialX/cellwidth)>=1)
                if((initialX>(cellwidth-smallBubbleRad)))
                {
                    int pos = (int) (initialX/cellwidth);

                    if((initialX%cellwidth)>(cellwidth/2))
                        pos=pos+1;

                    Log.e("---"," >=  "+((pos*cellwidth)-smallBubbleRad)+"     <= "+((pos*cellwidth)+smallBubbleRad));
                    if(initialX>=((pos*cellwidth)-smallBubbleRad) && (initialX<((pos*cellwidth)+smallBubbleRad)))
                    {
                        if (initialY > ((desiredHeight / 2) - smallBubbleRad) && initialY < ((desiredHeight / 2) + smallBubbleRad)) {
                            if (mIndicatorClickListener != null) {
                                mIndicatorClickListener.onBubbleClicked((pos-1));
                            }
                        }
                    }
                }

                break;

            case MotionEvent.ACTION_MOVE:
                // Log.d(TAG, "Action was MOVE");
                break;

            case MotionEvent.ACTION_UP:
                float finalX = event.getX();
                float finalY = event.getY();
                break;

        }

        return super.onTouchEvent(event);
    }

    @Override
    public void setBackgroundColor(int color) {
        super.setBackgroundColor(color);
    }

    public int getCellwidth() {
        return cellwidth;
    }

    public int getLargeBubbleRad() {
        return largeBubbleRad;
    }

    public void setLargeBubbleRad(int largeBubbleRad) {
        this.largeBubbleRad = largeBubbleRad;
    }


    /**
     * getter setter for  Bubble click listener
     * @return
     */
    public IndicatorClickListener getBubbleWidgetClickListener() {
        return mIndicatorClickListener;
    }

    public void setBubbleWidgetClickListener(IndicatorClickListener mIndicatorClickListener) {
        this.mIndicatorClickListener = mIndicatorClickListener;
    }
}
