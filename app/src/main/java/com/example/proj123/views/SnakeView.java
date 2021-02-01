package com.example.proj123.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;

import com.example.proj123.enums.TileType;

public class SnakeView extends View {
    private Paint mPaint = new Paint();
    private TileType snakeViewMap[][];

    Canvas canvas = new Canvas();

    private int data;

    public SnakeView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public void setSnakeViewMap(TileType[][] map) {
        this.snakeViewMap = map;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
        drawCircle(canvas);
    }

    public void drawCircle(Canvas canvas)
    {
        float tileSizeX = canvas.getWidth() / snakeViewMap.length;
        float tileSizeY = canvas.getHeight() / snakeViewMap[0].length;
        float circleSize = Math.min(tileSizeX, tileSizeY) / 2;
        Log.d("Log", "WE SET THE VALUE");
        mPaint.setColor(Color.RED);
        canvas.drawCircle(data * tileSizeX + tileSizeX / 2f + circleSize / 2, data * tileSizeY + tileSizeY / 2f + circleSize / 2, circleSize, mPaint);
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
                            mPaint.setColor(Color.rgb(	105,105,105));
                            break;
                    }
                    canvas.drawCircle(x * tileSizeX + tileSizeX / 2f + circleSize / 2, y * tileSizeY + tileSizeY / 2f + circleSize / 2, circleSize, mPaint);
                }
                mPaint.setColor(Color.RED);
                canvas.drawCircle(5 * tileSizeX + tileSizeX / 2f + circleSize / 2, 5 * tileSizeY + tileSizeY / 2f + circleSize / 2, circleSize, mPaint);
            }
        }
    }
}
