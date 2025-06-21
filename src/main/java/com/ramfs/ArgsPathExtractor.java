package com.ramfs;

public class ArgsPathExtractor {
    public static String extractPath(String[] args) {
        for (String arg : args) {
            if (!arg.startsWith("-")) {
                return arg;
            }
        }
        return "";
    }
}
