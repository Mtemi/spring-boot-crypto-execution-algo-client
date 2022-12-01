package com.ismail.algo;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.util.TimeZone;

/**
 * @author ismail
 * @since 20221130
 */
public class DateUtil
{
    /**
     * Nano Second
     */
    public static final int NANOS = 1_000_000_000;

    /**
     * Micro Second
     */
    public static final int MICROS = 1_000_000;

    /**
     * Milli Second
     */
    public static final int MILLIS = 1_000;

    
    public static final long SECOND = 1000L;

    public static final long MINUTE = 60 * SECOND;

    public static final long HOUR = 3600 * SECOND;

    public static final long DAY = 24L * HOUR;

    public static final long WEEK = 7L * DAY;

    public static final long MONTH = 30L * DAY;

    public static final long YEAR = 365L * DAY;

    
    /**
     * Current time nanos
     * 
     * @return
     */
    public static final long currentTimeNanos()
    {
        Instant ins = Instant.now();

        long time = ins.getEpochSecond() * DateUtil.NANOS + ins.getNano();

        return time;
    }

    public static final Instant currentTimeInstant()
    {
        Instant time = Instant.now();

        return time;
    }
    
    public static final long currentTimeMillis()
    {
        return System.currentTimeMillis();
    }

    public static final long nanosToMillis(final long nanos)
    {
        long millis = (nanos - nanos % 1000000L) / 1000000L;

        return millis;
    }

    public static final double nanosToMicros(final long nanos)
    {
        long millis = (nanos - nanos % 1000L) / 1000L;

        return millis;
    }

    public static final long millisToNanos(final long millis)
    {
        long nanos = millis * 1000000L;

        return nanos;
    }
    
    
    
    public static SimpleDateFormat getFormatter(String pFormat)
    {
        return getFormatter(pFormat, null, false);
    }

    public static SimpleDateFormat getFormatter(String pFormat, String pTimeZoneID)
    {
        return getFormatter(pFormat, pTimeZoneID, false);
    }

    
    public static SimpleDateFormat getFormatter(String pFormat, String pTimeZoneID, boolean pLenient)
    {
        SimpleDateFormat dateParser = new SimpleDateFormat(pFormat);
        dateParser.setLenient(pLenient);

        if (pTimeZoneID != null)
        {
            TimeZone tz = TimeZone.getTimeZone(pTimeZoneID);
            dateParser.setTimeZone(tz);
        }

        return dateParser;
    }
    
    public static String formatNano(long pEpocNanos, DateTimeFormatter formatter)
    {
        Instant instant = Instant.ofEpochSecond(0, pEpocNanos);
        String value = formatter.format(instant);
        
        return value;
    }

    public static String getOrderAge(long pMillis)
    {
        String age = null;
        
        if (pMillis>DAY)
            age = getOrderAgeInHours(pMillis);
        else if (pMillis>HOUR)
            age = getOrderAgeInMinutes(pMillis);
        else if (pMillis >MINUTE) 
            age = getOrderAgeInSeconds(pMillis);
        else 
            age = getOrderAgeInMillis(pMillis);
        
        return age;
    }

    /**
     * Returns the time elapsed; but round it by days (i.e. don't show hours, minutes, seconds..etc)
     * 
     * @param pMillis
     * @return
     */
    public static String getOrderAgeInSeconds(long pMillis)
    {
        if (pMillis <= 0L)
            return "";

        long millis = pMillis - pMillis % SECOND;

        return getOrderAgeInMillis(millis);
    }

    /**
     * Returns the time elapsed; but round it by days (i.e. don't show hours, minutes, seconds..etc)
     * 
     * @param pMillis
     * @return
     */
    public static String getOrderAgeInMinutes(long pMillis)
    {
        if (pMillis <= 0L)
            return "";

        long millis = pMillis - pMillis % MINUTE;

        return getOrderAgeInMillis(millis);
    }

    /**
     * Returns the time elapsed; but round it by days (i.e. don't show hours, minutes, seconds..etc)
     * 
     * @param pMillis
     * @return
     */
    public static String getOrderAgeInHours(long pMillis)
    {
        if (pMillis <= 0L)
            return "";

        long millis = pMillis - pMillis % HOUR;

        return getOrderAgeInMillis(millis);
    }



    /**
     * convert millis to a amount in years / months / days / hours / minutes / seconds
     * 
     * and displays the time in a shorter version; depending on the duration
     * 
     * @param pMillis
     * @return
     */
    public static String getOrderAgeInMillis(long pMillis)
    {
        int sign = pMillis >= 0 ? 1 : -1;

        long millis = pMillis;
        if (sign < 0)
            millis = -millis;

        long years = 0;
        long months = 0;
        long days = 0L;
        long hours = 0L;
        long minutes = 0L;
        long seconds = 0L;

        // calculate days and months
        days = millis / (24 * 3600 * 1000);
        millis = millis - (days * 24 * 3600 * 1000);

        // calculate months
        months = (days - days % 30L) / 30L;
        if (months > 0)
            days = days % 30;

        // years
        years = (months - months % 12L) / 12L;
        if (years > 0)
            months = months % 12;

        hours = millis / (3600 * 1000);
        millis = millis - (hours * 3600 * 1000);

        minutes = millis / (60 * 1000);
        millis = millis - (minutes * 60 * 1000);

        seconds = millis / (1000);
        millis = millis - (seconds * 1000);

        StringBuilder sb = new StringBuilder(30);

        if (sign < 0)
            sb.append('-');

        if (years > 0)
        {
            sb.append(years + "y ");

            if (months > 0)
                sb.append(months + "mon ");

            if (days > 0)
                sb.append(days + "d ");
        }
        else if (months > 0)
        {
            sb.append(months + "mon ");

            if (days > 0)
                sb.append(days + "d ");

            if (hours > 0)
                sb.append(hours + "h ");

            if (minutes > 0)
                sb.append(minutes + "m ");
        }
        else
        {
            if (days > 0)
                sb.append(days + "d ");

            if (hours > 0)
                sb.append(hours + "h ");

            if (minutes > 0)
                sb.append(minutes + "m ");

            if (seconds > 0)
                sb.append(seconds + "s ");

            if (millis > 0)
                sb.append(millis + "ms ");
        }

        return sb.toString().trim();
    }

}
