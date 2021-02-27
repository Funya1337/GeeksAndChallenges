package com.example.proj123.Fragments;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Bundle;

import java.util.Arrays;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.proj123.Activities.MainActivity;
import com.example.proj123.R;
import com.example.proj123.classes.GetDataFromEditor;
import com.example.proj123.classes.GlobalClass;
import com.example.proj123.engine.GameEngine;
import com.example.proj123.views.SnakeView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import me.testica.codeeditor.Editor;

import static com.example.proj123.classes.GlobalClass.dictionary;

public class RetailerGameFragment extends Fragment {

    private static GameEngine gameEngine;
    private static SnakeView snakeView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_retailer_game, container, false);
        Button redirectBtn = rootView.findViewById(R.id.redirectBtn);

        final GlobalClass globalClass = (GlobalClass) Objects.requireNonNull(getActivity()).getApplicationContext();

        redirectBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (GlobalClass.getCode() == null)
                {
                    Toast.makeText(getContext(), "Nothing to execute!", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    GlobalClass.CodeToArray(GlobalClass.getCode());
                    movePixel();
                }
            }
        });

        gameEngine = new GameEngine();
        gameEngine.initGame();
        snakeView = rootView.findViewById(R.id.snakeView);
        snakeView.setSnakeViewMap(gameEngine.getMap());
        snakeView.invalidate();
        return rootView;
    }

    public static void movePixel()
    {
        if (GlobalClass.splited[0].split(" ")[0].equals(dictionary[0]))
        {
            snakeView.makeStep(Integer.parseInt(GlobalClass.splited[0].split(" ")[1]), GlobalClass.getCode());
            snakeView.setSnakeViewMap(gameEngine.getMap());
            snakeView.invalidate();
            GlobalClass.splited = Arrays.copyOfRange(GlobalClass.splited, 1, GlobalClass.splited.length);
        }
    }
}