package com.example.proj123.Fragments;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Bundle;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.proj123.Activities.MainActivity;
import com.example.proj123.R;
import com.example.proj123.classes.GetDataFromEditor;
import com.example.proj123.engine.GameEngine;
import com.example.proj123.views.SnakeView;

import java.util.ArrayList;
import java.util.Objects;

public class RetailerGameFragment extends Fragment {

    private GameEngine gameEngine;
    private SnakeView snakeView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_retailer_game, container, false);
        Button redirectBtn = rootView.findViewById(R.id.redirectBtn);

        final String code = ((MainActivity) Objects.requireNonNull(getActivity())).getCode();

        redirectBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                movePixel(code);
            }
        });

        gameEngine = new GameEngine();
        gameEngine.initGame();
        snakeView = rootView.findViewById(R.id.snakeView);
        snakeView.setSnakeViewMap(gameEngine.getMap());
        snakeView.invalidate();
        return rootView;
    }
    public void movePixel(String code)
    {
        code = code.replaceAll("([\\r\\n])", "");
        String[] splited = code.split(";");
        String[] dictionary = {"step", "turn", "stop"};
        for (int i = 0; i < splited.length; i++)
        {
            if (splited[i].split(" ")[0].equals(dictionary[0]))
            {
                snakeView.setData(Integer.parseInt(splited[i].split(" ")[1]));
            }
        }
    }
}