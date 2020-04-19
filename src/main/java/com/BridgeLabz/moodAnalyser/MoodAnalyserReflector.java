package com.BridgeLabz.moodAnalyser;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MoodAnalyserReflector {
    public static Constructor<?> getConstructor(String className, Class<?>... parameter) throws MoodAnalysisException {
        try {
            Class<?> moodAnalyserClass = Class.forName(className);
            return moodAnalyserClass.getConstructor(parameter);
        } catch (ClassNotFoundException e) {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.CLASS_NOT_FOUND, "Class not found");
        } catch (NoSuchMethodException e) {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.NO_SUCH_METHOD, "Method not found");
        }
    }

    public static MoodAnalyser createMoodAnalyserObject(Constructor<?> moodAnalyserConstructor, Object... message) throws IllegalAccessException, InvocationTargetException, InstantiationException, InvocationTargetException {
        return (MoodAnalyser) moodAnalyserConstructor.newInstance(message);
    }

    public static Object invokeMethod(Object moodAnalyserObject, String methodName) throws MoodAnalysisException, IllegalAccessException, InvocationTargetException {
        try {
            Class objectClass = moodAnalyserObject.getClass();
            Method method = objectClass.getMethod(methodName);
            Object result = method.invoke(moodAnalyserObject);
            return result;
        } catch (NoSuchMethodException e) {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.NO_SUCH_METHOD, "Method not found");
        }
    }

}