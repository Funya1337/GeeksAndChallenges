package com.example.proj123.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.WindowManager;

import com.example.proj123.Fragments.RetailerDashboardFragment;
import com.example.proj123.Fragments.RetailerEditorFragment;
import com.example.proj123.Fragments.RetailerGameFragment;
import com.example.proj123.R;
import com.example.proj123.classes.GetDataFromEditor;
import com.ismaeldivita.chipnavigation.ChipNavigationBar;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import io.github.rosemoe.editor.widget.CodeEditor;
import me.testica.codeeditor.Editor;

public class MainActivity extends AppCompatActivity {

    ChipNavigationBar chipNavigationBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        chipNavigationBar = findViewById(R.id.bottom_nav_menu);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new RetailerDashboardFragment()).commit();
        bottomMenu();
    }
    private void bottomMenu()
    {
        chipNavigationBar.setOnItemSelectedListener(new ChipNavigationBar.OnItemSelectedListener() {
            @Override
            public void onItemSelected(int i) {
                Fragment fragment = null;
                switch (i) {
                    case R.id.bottom_nav_dashboard:
                        fragment = new RetailerDashboardFragment();
                        break;
                    case R.id.bottom_nav_game:
                        fragment = new RetailerGameFragment();
                        break;
                    case R.id.bottom_nav_editor:
                        fragment = new RetailerEditorFragment();
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();
            }
        });
    }
}