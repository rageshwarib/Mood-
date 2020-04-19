package com.BridgeLabz.moodAnalyser;

import java.util.Objects;

public class MoodAnalyser {

    public String message;

    public MoodAnalyser() {
    }

    public MoodAnalyser(String message) {
        this.message = message;
    }

    public String analyseMood() throws MoodAnalysisException {
        try {
            if (this.message.equals(""))
                throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.EMPTY, "Empty Mood");
            if (this.message.contains("Sad"))
                return "Sad";
            if (this.message.contains("Happy"))
                return "Happy";
            return "Happy";
        } catch (NullPointerException e) {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.NULL, "Invalid Message");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MoodAnalyser that = (MoodAnalyser) o;
        return Objects.equals(message, that.message);
    }

}