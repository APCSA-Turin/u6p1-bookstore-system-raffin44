package com.example.project;

public class IdGenerate {
    private static String currentId = "99"; // Starting ID

    // Empty private constructor to prevent instantiation
    private IdGenerate() {}

    public static String getCurrentId() {
        return currentId;
    }

    public static void reset() {
        currentId = "99"; // Resets ID to 99
    }

    public static void generateID() {
        int id = Integer.parseInt(currentId); // Convert to int for incrementation
        id++;
        currentId = String.valueOf(id); // Convert back to String
    }
}