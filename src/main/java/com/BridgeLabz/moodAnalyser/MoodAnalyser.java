package com.BridgeLabz.moodAnalyser;

public class MoodAnalyser {

    public String message;

    public MoodAnalyser(String message) {
        this.message = message;
    }

    public String analyseMood() throws MoodAnalysisException {
        try {
            if (message.contains("Sad"))
                return "Sad";
                return "Happy";
        } catch (NullPointerException e) {
            return "Happy";
        }
    }
}
