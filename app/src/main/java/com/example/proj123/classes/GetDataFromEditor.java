package com.example.proj123.classes;

import android.app.Application;
import android.util.Log;

import com.example.proj123.Fragments.RetailerGameFragment;

import java.util.ArrayList;
import java.util.Arrays;

public class GetDataFromEditor {

    private String code = "";
    public boolean status = false;

    public String getCode() {
        Log.d("Log", code);
        return code;
    }

    public boolean checkSyntax(String code)
    {
        return handleCodeFunc(code);
    }

    public void setCode(String code) {
        this.code = code;
    }

    public boolean handleCodeFunc(String code)
    {
        code = code.replaceAll("([\\r\\n])", "");
        String[] splited = code.split(";");
        ArrayList<String> arr = new ArrayList<String>();
        String[] dictionary = {"step", "turn", "stop"};
        if (!splited[splited.length - 1].equals("stop"))
        {
            status = false;
            Log.d("Log", "Error");
        }
        else
        {
            for (int i = 0; i < splited.length; i++)
            {
                arr.add(splited[i].split("\\s+")[0]);
            }
            for (int i = 0; i < arr.size(); i++)
            {
                if (arr.get(i).equals(dictionary[0]) || arr.get(i).equals(dictionary[1]) || arr.get(i).equals(dictionary[2]))
                {
                    status = true;
                }
                else
                {
                    status = false;
                }
            }
        }
        return status;
    }
}
