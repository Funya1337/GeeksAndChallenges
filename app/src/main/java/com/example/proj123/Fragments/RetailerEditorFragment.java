package com.example.proj123.Fragments;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.proj123.R;

import me.testica.codeeditor.Editor;
import me.testica.codeeditor.SyntaxHighlightRule;

public class RetailerEditorFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_retailer_editor, container, false);
        Editor editor = rootView.findViewById(R.id.editor);
        editor.setText("Hello Android");
        editor.setSyntaxHighlightRules(
                new SyntaxHighlightRule("[0-9]*", "#00838f"),
                new SyntaxHighlightRule("/\\\\*(?:.|[\\\\n\\\\r])*?\\\\*/|(?<!:)//.*", "#9ea7aa")
        );
        editor.getNumLinesView().setBackgroundColor(Color.BLACK);
        editor.getNumLinesView().setTextColor(Color.WHITE);
        editor.getEditText().setPadding(10, 0, 0, 0);
        return rootView;
    }
}