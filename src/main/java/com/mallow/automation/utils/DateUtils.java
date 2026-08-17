package com.mallow.automation.utils;

import java.time.LocalDate;

public class DateUtils {

    public static LocalDate getFutureDate() {

        return LocalDate.now().plusDays(1);
    }
}