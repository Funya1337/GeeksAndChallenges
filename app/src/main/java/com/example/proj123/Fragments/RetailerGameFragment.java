package com.example.proj123.Fragments;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Bundle;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.proj123.R;

public class RetailerGameFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return new MyView(getContext());
    }
    public class MyView extends View
    {
        Paint paint = null;
        public MyView(Context context)
        {
            super(context);
            paint = new Paint();
        }
        @Override
        protected void onDraw(Canvas canvas)
        {
            super.onDraw(canvas);
            int x = getWidth();
            int y = getHeight();
            int boardRow = x / 60;
            int boardCol = y / 60;
            int right = 50;
            int bottom = 50;
            int radius = 50;
            paint.setStyle(Paint.Style.FILL);
            paint.setColor(Color.WHITE);
            canvas.drawPaint(paint);
            // Use Color.parseColor to define HTML colors
            int color = ContextCompat.getColor(getContext(), R.color.colorFieldGrey);
            paint.setColor(color);
            canvas.drawColor(ContextCompat.getColor(getContext(), R.color.colorBackgroundBlack));
            System.out.println("boardRow " + boardRow);
            System.out.println("boardCol " + boardCol);
            for (int i = 0; i <= x; i += 60) {
                for (int j = 0; j <= y - 300; j += 60) {
                    System.out.println(i);
                    System.out.println(j);
                    canvas.drawRoundRect((new RectF(i, j, 50 + i, 50 + j)), 20, 20, paint);
                }
            }
        }
    }
}