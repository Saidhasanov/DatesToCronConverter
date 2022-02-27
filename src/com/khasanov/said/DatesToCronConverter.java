package com.khasanov.said;

public interface DatesToCronConverter {
    String convert(String[] dates);
    String getImplementationInfo();
}
