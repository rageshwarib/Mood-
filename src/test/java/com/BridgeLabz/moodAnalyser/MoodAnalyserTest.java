package com.BridgeLabz.moodAnalyser;

import org.junit.Assert;
import org.junit.Test;

public class MoodAnalyserTest {
    @Test
    public void givenSadMessage_whenGetMood_ShouldReturnsadMood() throws MoodAnalysisException {
        MoodAnalyser moodAnalyser = new MoodAnalyser();
        String mood = moodAnalyser.analyseMood("I am in Sad Mood");
        Assert.assertEquals("Sad", mood);
    }
    @Test
    public void givenHappyMessge_whenGetMood_shouldReturnhappyMood() throws MoodAnalysisException {
        MoodAnalyser moodAnalyser = new MoodAnalyser();
        String mood = moodAnalyser.analyseMood("I am in Happy Mood");
        Assert.assertEquals("Happy", mood);
    }


}
