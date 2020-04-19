package com.BridgeLabz.moodAnalyser;

public class MoodAnalyser {
    public String analyseMood(String message) {
        if (message.contains("Sad"))
            return "Sad";
        if (message.contains("Happy"))
            return "Happy";
        return "Invalid mood";
    }
}
