package com.example.proj123.classes;

import android.app.Application;

import java.util.Arrays;

public class GlobalClass extends Application {
    public static String code;

    public static String[] splited;

    public static String[] dictionary = {"step", "turn", "stop"};

    public static String getCode() {
        return code;
    }

    public static void setCode(String code) {
        GlobalClass.code = code;
    }

    public static void CodeToArray(String code)
    {
        code = code.replaceAll("([\\r\\n])", "");
        String[] splited = code.split(";");
        GlobalClass.splited = splited;
    }
}
