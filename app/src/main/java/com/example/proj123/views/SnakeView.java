package com.example.proj123.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentManager;

import com.example.proj123.Activities.MainActivity;
import com.example.proj123.Fragments.RetailerGameFragment;
import com.example.proj123.R;
import com.example.proj123.classes.GlobalClass;
import com.example.proj123.enums.TileType;

import java.util.Arrays;
import java.util.Random;

public class SnakeView extends View {
    private Paint mPaint = new Paint();
    private TileType snakeViewMap[][];

    private int currentLocationX = 6;

    private int currentLocationY = 8;

    public int num = 0;

    public int x = 1;

    public String side = "";

    public int checker = 0;

    public SnakeView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public void setSnakeViewMap(TileType[][] map) {
        this.snakeViewMap = map;
    }

    public void makeStep(int num)
    {
        this.num = num;
        checker = x;
    }

    public void makeTurn(String side)
    {
        this.side = side;
        checker = 4;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (snakeViewMap != null) {
            float tileSizeX = canvas.getWidth() / snakeViewMap.length;
            float tileSizeY = canvas.getHeight() / snakeViewMap[0].length;

            float circleSize = Math.min(tileSizeX, tileSizeY) / 2;

            for (int x = 0; x < snakeViewMap.length; x++) {
                for (int y = 0; y < snakeViewMap[x].length; y++) {
                    switch (snakeViewMap[x][y]) {
                        case Wall:
                            mPaint.setColor(Color.rgb(105,105,105));
                            break;
                    }
                    canvas.drawCircle(x * tileSizeX + tileSizeX / 2f + circleSize / 2, y * tileSizeY + tileSizeY / 2f + circleSize / 2, circleSize, mPaint);
                }
            }
            if (checker == 1)
            {
                mPaint.setColor(Color.RED);
                canvas.drawCircle(currentLocationX * tileSizeX + tileSizeX / 2f + circleSize / 2, (currentLocationY - num) * tileSizeY + tileSizeY / 2f + circleSize / 2, circleSize, mPaint);
                currentLocationY = currentLocationY - num;
                RetailerGameFragment.movePixel();
            }
            else if (checker == 2)
            {
                mPaint.setColor(Color.RED);
                canvas.drawCircle((currentLocationX - num) * tileSizeX + tileSizeX / 2f + circleSize / 2, currentLocationY * tileSizeY + tileSizeY / 2f + circleSize / 2, circleSize, mPaint);
                currentLocationX = currentLocationX - num;
                RetailerGameFragment.movePixel();
            }
            else if (checker == 3)
            {
                mPaint.setColor(Color.RED);
                canvas.drawCircle((currentLocationX + num) * tileSizeX + tileSizeX / 2f + circleSize / 2, currentLocationY * tileSizeY + tileSizeY / 2f + circleSize / 2, circleSize, mPaint);
                currentLocationX = currentLocationX + num;
                RetailerGameFragment.movePixel();
            }
            else if (checker == 4)
            {
                if (side.equals("right"))
                {
                    x = 3;
                    RetailerGameFragment.movePixel();
                }
                else
                {
                    x = 2;
                    RetailerGameFragment.movePixel();
                }
            }
            else
            {
                mPaint.setColor(Color.RED);
                canvas.drawCircle(currentLocationX * tileSizeX + tileSizeX / 2f + circleSize / 2, currentLocationY * tileSizeY + tileSizeY / 2f + circleSize / 2, circleSize, mPaint);
            }
        }
    }
}
