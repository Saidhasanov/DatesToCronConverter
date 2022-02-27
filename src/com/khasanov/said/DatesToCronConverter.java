package com.khasanov.said;

public interface DatesToCronConverter {
    String convert(String[] dates) throws DatesToCron.DatesToCronConvertException;
    String getImplementationInfo();
}
