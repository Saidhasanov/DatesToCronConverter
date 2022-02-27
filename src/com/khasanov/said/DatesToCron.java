package com.khasanov.said;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class DatesToCron implements DatesToCronConverter{

    public static class DatesToCronConvertException extends Exception {
    }

    public String convert(String[] dates) throws DatesToCronConvertException {
        int n = dates.length;
        List<String> second = new ArrayList<>();
        List<String> minute = new ArrayList<>();
        List<String> hour = new ArrayList<>();
        List<String> dayOfMonth = new ArrayList<>();
        List<String> month = new ArrayList<>();
        List<String> dayOfWeek = new ArrayList<>();

        for (String s : dates) {
            LocalDateTime local = LocalDateTime.parse(s);
            String[] datetime = s.split("T");
            String[] date = datetime[0].split("-");
            String[] time = datetime[1].split(":");
            String dayOfMonthStr = String.valueOf(local.getDayOfMonth());
            String dayOfWeekStr = String.valueOf(local.getDayOfWeek());

            if (!second.contains(time[2]))
                second.add(time[2]);
            if (!minute.contains(time[1]))
                minute.add(time[1]);
            if (!hour.contains(time[0]))
                hour.add(time[0]);
            if (!dayOfMonth.contains(dayOfMonthStr))
                dayOfMonth.add(dayOfMonthStr);
            if (!month.contains(date[1]))
                month.add(date[1]);
            if (!dayOfWeek.contains(dayOfWeekStr))
                dayOfWeek.add(dayOfWeekStr);
        }

        String cron = "";
        if (second.size() == 1)
            cron += String.format("%1$s ", second.get(0));
        else if (second.size() == 2)
            cron += String.format("%1$s/%2$s ", second.get(0), second.get(1));
        else cron += "* ";

        if (minute.size() == 1)
            cron += String.format("%1$s ", minute.get(0));
        else if (minute.size() == 2)
            cron += String.format("%1$s/%2$s ", minute.get(0), minute.get(1));
        else cron += "* ";

        if (hour.size() == 1)
            cron += String.format("%1$s ", hour.get(0));
        else if (hour.size() == 2) {
            int s = Integer.parseInt(hour.get(1));
            int f = Integer.parseInt(hour.get(0));
            if (s - f == 1)
                cron += String.format("%1$s-%2$s ", f, s);
            else
                cron += String.format("%1$s/%2$s ", f, s);
        }
        else cron += "* ";

        if (dayOfMonth.size() == 1){
            cron += String.format("%1$s ", dayOfMonth.get(0));
            if (month.size() == 1)
                cron += String.format("%1$s ", month.get(0));
            else cron += "* ";
            if (dayOfWeek.size() == 1)
                cron += String.format("%1$s", dayOfWeek.get(0));
            else cron += "* ";
        }
        else cron += "* * *";

        if (cron.equals("* * * * * *"))
            throw new DatesToCronConvertException();

        return cron;
    }

    public String getImplementationInfo() {
        return "Хасанов Саид Фархадович, DatesToCron, com.khasanov.said, https://github.com/Saidhasanov/DatesToCronConverter";
    }
}
