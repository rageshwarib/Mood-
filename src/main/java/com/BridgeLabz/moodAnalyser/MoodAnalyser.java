package com.BridgeLabz.moodAnalyser;

public class MoodAnalyser {

    public String message;

    public MoodAnalyser(String message){
        this.message = message;
    }

    public String analyseMood() {
        if (message.contains("Sad"))
            return "Sad";
        if (message.contains("Happy"))
            return "Happy";
        return "Invalid mood";
    }
}
