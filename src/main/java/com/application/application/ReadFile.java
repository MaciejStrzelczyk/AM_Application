package com.application.application;

import com.google.gson.Gson;
import com.google.gson.JsonArray;


import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ReadFile {

    public static String read() throws IOException {
        Gson gson = new Gson();
        Reader reader = Files.newBufferedReader(Paths.get("src/main/resources/Example.json"));
        JsonArray array  = gson.fromJson(reader, JsonArray.class);
        String output = array.toString();
        return output;
    }
}
