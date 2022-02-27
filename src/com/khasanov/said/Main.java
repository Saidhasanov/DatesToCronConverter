package com.khasanov.said;

public class Main {

    public static void main(String[] args) throws DatesToCron.DatesToCronConvertException {
        String[] dates1 = new String[] {
                "2022-01-25T08:00:00",
                "2022-01-25T08:30:00",
                "2022-01-25T09:00:00",
                "2022-01-25T09:30:00",
                "2022-01-26T08:00:00",
                "2022-01-26T08:30:00",
                "2022-01-26T09:00:00",
                "2022-01-26T09:30:00",
        };

        String[] dates2 = new String[] {
                "2022-01-24T19:53:00",
                "2022-01-24T19:54:00",
                "2022-01-24T19:55:00",
                "2022-01-24T19:56:00",
                "2022-01-24T19:57:00",
                "2022-01-24T19:58:00",
                "2022-01-24T19:59:00",
                "2022-01-24T20:00:00",
                "2022-01-24T20:01:00",
                "2022-01-24T20:02:00",
        };


        DatesToCron conv = new DatesToCron();
        System.out.println(conv.convert(dates1));
    }
}
