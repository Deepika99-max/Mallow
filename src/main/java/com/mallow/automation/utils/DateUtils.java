package com.mallow.automation.utils;

import java.time.LocalDate;

public class DateUtils {

    private DateUtils() {
    }

    public static LocalDate getFutureDate() {

        return LocalDate.now().plusDays(1);
    }

    public static String getFutureDay() {

        return String.valueOf(
                getFutureDate().getDayOfMonth()
        );
    }
}