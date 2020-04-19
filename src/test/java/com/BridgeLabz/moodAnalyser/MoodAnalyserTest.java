package com.BridgeLabz.moodAnalyser;

import org.junit.Assert;
import org.junit.Test;

public class MoodAnalyserTest {
    @Test
    public void givenSadMessage_whenGetMood_ShouldReturnsadMood() throws MoodAnalysisException {
        MoodAnalyser moodAnalyser = new MoodAnalyser("I am in Sad Mood");
        String mood = moodAnalyser.analyseMood();
        Assert.assertEquals("Sad", mood);
    }
    @Test
    public void givenHappyMessge_whenGetMood_shouldReturnhappyMood() throws MoodAnalysisException {
        MoodAnalyser moodAnalyser = new MoodAnalyser("I am in Happy Mood");
        String mood = moodAnalyser.analyseMood();
        Assert.assertEquals("Happy", mood);
    }
    @Test
    public void whenGetAnyMood_shouldReturnhappyMood() throws MoodAnalysisException {
        MoodAnalyser moodAnalyser = new MoodAnalyser("I am in any Mood");
        String mood = moodAnalyser.analyseMood();
        Assert.assertEquals("Happy", mood);

    }
    @Test
    public void givenNullMessage_whenAnalyseMood_shouldThrowMoodAnalysisException() {
        try {
            MoodAnalyser moodAnalyser = new MoodAnalyser(null);
            String mood = moodAnalyser.analyseMood();
        }catch (MoodAnalysisException moodAnalysisException){
            Assert.assertEquals("Invalid Message", moodAnalysisException.getMessage());
        }
    }
    @Test
    public void givenEmptyMessage_whenAnalyseMood_shouldThrowMoodAnalysisException() {
        try {
            MoodAnalyser moodAnalyser = new MoodAnalyser(" ");
            moodAnalyser.analyseMood();
        } catch (MoodAnalysisException moodAnalysisException) {
            Assert.assertEquals("Empty Mood",moodAnalysisException.getMessage());
        }
    }
}
