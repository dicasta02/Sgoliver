package com.softpolaris.sgoliver.utilities;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * @author dacastano
 * @version 1.0
 * @since 22, October, 2018
 */
public class DateUtils {
    private DateUtils() {
    }

    public static String getCurrentDateFormat() {
        DateFormat dateFormat = new SimpleDateFormat(Constants.DATE_FORMAT, Locale.getDefault());

        return dateFormat.format(new Date());
    }

    public static String getCurrentDateTimeFormat() {
        DateFormat dateFormat = new SimpleDateFormat(Constants.DATE_TIME_FORMAT, Locale.getDefault());

        return dateFormat.format(new Date());
    }

    public static String getCurrentDateShortFormat() {
        DateFormat dateFormat = new SimpleDateFormat(Constants.DATE_FORMAT_SHORT, Locale.getDefault());

        return dateFormat.format(new Date());
    }
}