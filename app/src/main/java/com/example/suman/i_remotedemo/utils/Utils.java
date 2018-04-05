package com.example.suman.i_remotedemo.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Created by Suman on 05-04-2018.
 */

public class Utils {
    private static Gson gson;

    public static Gson getGsonParser() {
        if(null == gson) {
            GsonBuilder builder = new GsonBuilder();
            gson = builder.create();
        }
        return gson;
    }
}
