package com.example.proj123.Fragments;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;
import com.example.proj123.R;
import com.example.proj123.classes.GetDataFromEditor;
import com.example.proj123.classes.GlobalClass;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;

import me.testica.codeeditor.Editor;
import me.testica.codeeditor.SyntaxHighlightRule;

public class RetailerEditorFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_retailer_editor, container, false);
        final Editor editor = rootView.findViewById(R.id.editor);
        Button sendDataBtn = rootView.findViewById(R.id.sendDataBtn);
        Button loadDataBtn = rootView.findViewById(R.id.loadDataBtn);

        final GlobalClass globalClass = (GlobalClass) Objects.requireNonNull(getActivity()).getApplicationContext();

        final GetDataFromEditor getDataFromEditor = new GetDataFromEditor();

        sendDataBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getDataFromEditor.setCode(editor.getText());
                if (getDataFromEditor.checkSyntax(editor.getText()))
                {
                    save(editor);
                    globalClass.setCode(editor.getText());
                }
                else
                {
                    Toast.makeText(getContext(),"Syntax Error!",Toast.LENGTH_SHORT).show();
                }
            }
        });

        loadDataBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                load(editor);
            }
        });

        editor.setSyntaxHighlightRules(
                new SyntaxHighlightRule("[0-9]*", "#00838f"),
                new SyntaxHighlightRule("/\\\\*(?:.|[\\\\n\\\\r])*?\\\\*/|(?<!:)//.*", "#9ea7aa")
        );
        editor.getNumLinesView().setBackgroundColor(Color.BLACK);
        editor.getNumLinesView().setTextColor(Color.WHITE);
        editor.getEditText().setPadding(10, 0, 0, 0);
        return rootView;
    }

    public void save(Editor editor)
    {
        if (!editor.getText().isEmpty())
        {
            File file = new File(getContext().getFilesDir(), "text");
            if (!file.exists())
            {
                file.mkdir();
            }
            try {
                File gpxfile = new File(file, "sample");
                FileWriter writer = new FileWriter(gpxfile);
                writer.append(editor.getText());
                writer.flush();
                writer.close();
                Toast.makeText(getContext(), "Your code saved!", Toast.LENGTH_LONG).show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void load(Editor editor)
    {
        File fileEvents = new File(getContext().getFilesDir() + "/text/sample");
        StringBuilder text = new StringBuilder();
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileEvents));
            String line;
            while ((line = br.readLine()) != null)
            {
                text.append(line);
                text.append("\n");
            }
            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String result = text.toString();
        editor.setText(result);
    }
}