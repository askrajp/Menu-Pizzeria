package com.pizzeria.menupizzeria.util;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public class JsonUtil {

    private static final Gson gson = new Gson();

    public static <T> void writeListToFile(List<T> list, String filePath) throws IOException {
        try (FileWriter writer = new FileWriter(filePath)) {
            gson.toJson(list, writer);
        }
    }

    public static <T> List<T> readListFromFile(String filePath, Type type) throws IOException {
        try (FileReader reader = new FileReader(filePath)) {
            return gson.fromJson(reader, type);
        }
    }
}
