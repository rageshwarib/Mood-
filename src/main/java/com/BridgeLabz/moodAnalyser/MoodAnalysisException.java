package com.BridgeLabz.moodAnalyser;

public class MoodAnalysisException extends Exception {
     public ExceptionType type;

    public enum ExceptionType {
        EMPTY, NULL, CLASS_NOT_FOUND, NO_SUCH_METHOD, NO_SUCH_FIELD ;
    }
    public MoodAnalysisException(ExceptionType type, String message) {
        super(message);
        this.type = type;
    }
}
