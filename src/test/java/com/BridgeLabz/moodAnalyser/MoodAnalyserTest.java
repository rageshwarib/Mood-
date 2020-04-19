package com.BridgeLabz.moodAnalyser;

import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

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
    @Test
    public void givenMoodAnalyserClassName_whenInProper_shouldReturnObject() throws MoodAnalysisException, IllegalAccessException, InstantiationException, InvocationTargetException {
        MoodAnalyser moodAnalyser = new MoodAnalyser();
        Constructor<?> moodAnalyserConstructor = MoodAnalyserReflector.getConstructor("com.BridgeLabz.moodAnalyser.MoodAnalyser");
        MoodAnalyser moodAnalyserObj = MoodAnalyserReflector.createMoodAnalyserObject(moodAnalyserConstructor);
        boolean check = moodAnalyser.equals(moodAnalyserObj);
        Assert.assertEquals(true, check);
    }

    @Test
    public void givenMoodAnalyserClassName_whenImproper_shouldThrowMoodAnalysisException() throws IllegalAccessException, InstantiationException, InvocationTargetException {
        try {
            MoodAnalyserReflector.getConstructor("MoodeAnalyser");
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.ExceptionType.CLASS_NOT_FOUND, e.type);
        }
    }

    @Test
    public void givenMoodAnalyserClassName_whenConstructorNotProper_shouldThrowMoodAnalysisException() throws IllegalAccessException, InstantiationException,InvocationTargetException {
        try {
            Constructor<?> moodAnalyserConstructor = MoodAnalyserReflector.getConstructor("com.BridgeLabz.moodAnalyser.MoodAnalyser", Integer.class);
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.ExceptionType.NO_SUCH_METHOD, e.type);
        }
}

    @Test
    public void givenMoodAnalyserClassName_whenProper_shouldReturnObject() throws IllegalAccessException, InstantiationException, InvocationTargetException, MoodAnalysisException {
        MoodAnalyser moodAnalyser = new MoodAnalyser();
        Constructor<?> moodAnalyserConstructor = MoodAnalyserReflector.getConstructor("com.BridgeLabz.moodAnalyser.MoodAnalyser");
        MoodAnalyser moodAnalyserObject = MoodAnalyserReflector.createMoodAnalyserObject(moodAnalyserConstructor);
        boolean check = moodAnalyser.equals(moodAnalyserObject);
        Assert.assertEquals(true, check);
    }
    @Test
    public void givenMoodAnalyserWithParameterConstructor_whenProper_shouldReturnObject() throws IllegalAccessException, InstantiationException, InvocationTargetException {
        MoodAnalyser moodAnalyser = new MoodAnalyser("I am in Happy mood");
        Constructor<?> moodAnalyserConstructor = null;
        try {
            moodAnalyserConstructor = MoodAnalyserReflector.getConstructor("com.BridgeLabz.moodAnalyser.MoodAnalyser", String.class);
        } catch (MoodAnalysisException e) {
            e.printStackTrace();
        }
        MoodAnalyser moodAnalyserObject = MoodAnalyserReflector.createMoodAnalyserObject(moodAnalyserConstructor, "I am in Happy mood");
        boolean check = moodAnalyser.equals(moodAnalyserObject);
        Assert.assertEquals(true, check);
    }
    @Test
    public void givenMoodAnalysrClassName_whenImproper_shouldThrowMoodAnalysisException(){
        try {
             MoodAnalyserReflector.getConstructor("MoodeAnalyser");
        }catch (MoodAnalysisException e){
            Assert.assertEquals(MoodAnalysisException.ExceptionType.CLASS_NOT_FOUND, e.type);
        }
    }
    @Test
    public void givenMoodAnalysrClassName_whenConstructorNotProper_shouldThrowMoodAnalysisException() {
        MoodAnalyser moodAnalyser = new MoodAnalyser("I am in Happy mood");
        Constructor<?> moodAnalyserConstructor = null;
        try {
            moodAnalyserConstructor = MoodAnalyserReflector.getConstructor("com.BridgeLabz.moodAnalyser.MoodAnalyser", String.class);
        } catch (MoodAnalysisException e) {
            e.printStackTrace();
      }
    }
    @Test
    public void givenHappyMessageUsingReflection_whenProper_shouldReturnHappyMood() throws MoodAnalysisException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Constructor<?> moodAnalyserConstructor = MoodAnalyserReflector.getConstructor("com.BridgeLabz.moodAnalyser.MoodAnalyser", String.class);
        MoodAnalyser moodAnalyserObject = MoodAnalyserReflector.createMoodAnalyserObject(moodAnalyserConstructor, "I am in Happy mood");
        Object result = MoodAnalyserReflector.invokeMethod(moodAnalyserObject, "analyseMood");
        Assert.assertEquals("Happy", result);
    }
    @Test
    public void givenHappyMessage_whenImproper_shouldThrowMoodAnalysisException() throws InstantiationException, IllegalAccessException, InvocationTargetException {
        try {
            Constructor<?> moodAnalyserConstructor = MoodAnalyserReflector.getConstructor("com.BridgeLabz.moodAnalyser.MoodAnalyser", String.class);
            MoodAnalyser moodAnalyserObject = MoodAnalyserReflector.createMoodAnalyserObject(moodAnalyserConstructor, "I am in Happy mood");
            Object result = MoodAnalyserReflector.invokeMethod(moodAnalyserObject, "CreateMethod");
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.ExceptionType.NO_SUCH_METHOD, e.type);
        }
    }
    @Test
    public void givenMoodAnalyser_setHappyMessage_withReflector_shouldReturnHappy() throws InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchFieldException, ClassNotFoundException {
        try {
            Constructor<?> moodAnalyserConstructor = MoodAnalyserReflector.getConstructor("com.BridgeLabz.moodAnalyser.MoodAnalyser");
            MoodAnalyser moodAnalyserObject = MoodAnalyserReflector.createMoodAnalyserObject(moodAnalyserConstructor);
            MoodAnalyserReflector.setVariableValues(moodAnalyserObject, "message", "I am in Happy mood");
            Object result = MoodAnalyserReflector.invokeMethod(moodAnalyserObject, "createMood");
            Assert.assertEquals("Happy", result);
        } catch (MoodAnalysisException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void givenMoodAnalyser_field_WhenImproperShould_throwException() throws  InstantiationException, IllegalAccessException, InvocationTargetException, ClassNotFoundException, NoSuchFieldException {
        try {
            Constructor<?> moodAnalyserConstructor = MoodAnalyserReflector.getConstructor("com.BridgeLabz.moodAnalyser.MoodAnalyser");
            MoodAnalyser moodAnalyserObject = MoodAnalyserReflector.createMoodAnalyserObject(moodAnalyserConstructor);
            MoodAnalyserReflector.setVariableValues(moodAnalyserObject, "Message", "I am in Happy mood");
            Object result = MoodAnalyserReflector.invokeMethod(moodAnalyserObject, "analyseMood");
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.ExceptionType.NO_SUCH_FIELD, e.type);
        }
    }
    @Test
    public void givenMoodAnalyser_SettingNullMessage_withReflector_shouldThrowException() throws MoodAnalysisException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException, ClassNotFoundException {
        try {
            Constructor moodAnalyserConstructor = MoodAnalyserReflector.getConstructor("com.BridgeLabz.moodAnalyser.MoodAnalyser");
            MoodAnalyser moodAnalyserObject = MoodAnalyserReflector.createMoodAnalyserObject(moodAnalyserConstructor);
            MoodAnalyserReflector.setVariableValues(moodAnalyserObject, "message", null);
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.ExceptionType.NULL, e.type);
        }
    }

}
