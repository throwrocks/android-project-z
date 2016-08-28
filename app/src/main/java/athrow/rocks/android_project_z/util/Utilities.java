package athrow.rocks.android_project_z.util;

/**
 * Utilities
 * Created by jose on 8/27/16.
 */

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

/**
 * Utilities
 * General Utilities
 * Created by josel on 7/5/2016.
 */
public final class Utilities {

    private Utilities(){ throw new AssertionError("No Utilities instances for you!"); } // suppress constructor

    /**
     * getDateAsString
     * Convert a date into a string
     *
     * @param date   the date
     * @param format the format in which to return the string
     * @return the new formatted date string
     */
    public static String getDateAsString(Date date, String format, String timezone) {
        DateFormat formatter = new SimpleDateFormat(format, Locale.getDefault());
        if (timezone == null) {
            formatter.setTimeZone(TimeZone.getDefault());
        } else {
            formatter.setTimeZone(TimeZone.getTimeZone(timezone));
        }
        return formatter.format(date);
    }

    /**
     * getStringAsDate
     *
     * @param dateString a string in date format
     * @param format     the resulting date format
     * @return a new date in the specified format
     */
    public static Date getStringAsDate(String dateString, String format, String timezone) {
        SimpleDateFormat formatter = new SimpleDateFormat(format, Locale.getDefault());
        if (timezone == null) {
            formatter.setTimeZone(TimeZone.getDefault());
        } else {
            formatter.setTimeZone(TimeZone.getTimeZone("UTC"));
        }
        Date date = new Date();
        try {
            date = formatter.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * elapsedTimeDisplay
     * Get the elapsed time between two dates in readable format
     *
     * @param dateStart the date start
     * @param dateEnd   the date end
     * @return the elapsed hours and minutes
     */
    public static String elapsedTimeDisplay(Date dateStart, Date dateEnd) {
        long diff = dateEnd.getTime() - dateStart.getTime();
        long diffMinutes = diff / (60 * 1000) % 60;
        long diffHours = diff / (60 * 60 * 1000);
        String mins = Long.toString(diffMinutes);
        if (mins.length() == 1) {
            mins = "0" + mins;
        }
        return Long.toString(diffHours) + ":" + mins;
    }

    /**
     * elapsedMinuted
     * Get the elapsed minutes between two dates
     *
     * @param dateStart the date start
     * @param dateEnd   the date end
     * @return the elapsed hours and minutes in a long
     */
    public static long elapsedMilliseconds(Date dateStart, Date dateEnd) {
        return dateEnd.getTime() - dateStart.getTime();
    }

    /**
     * millisecondsToHours
     * Get the hh:mm value from milliseconds
     * @param millis the milliseconds value
     * @return a string with the time in hh:mm format
     */
    public static String millisecondsToHours(long millis){
        return String.format(Locale.getDefault(), "%02d:%02d",
                TimeUnit.MILLISECONDS.toHours(millis),
                TimeUnit.MILLISECONDS.toMinutes(millis) % TimeUnit.HOURS.toMinutes(1));
    }


    /**
     * getTodaysDate
     *
     * @param format the date format in which to return the date
     * @return today's date in the specified format
     */
    public static Date getTodaysDate(String format) {
        Date date = new Date();
        String dateString = getDateAsString(date, format, null);
        return getStringAsDate(dateString, format, null);
    }

    /**
     * buildStringFromArray
     *
     * @param stringArray the String[] to convert
     * @param separator   the string separator
     * @return the separated string
     */
    public static String buildStringFromArray(ArrayList<String> stringArray, String separator) {
        if (stringArray.size() > 0) {
            StringBuilder nameBuilder = new StringBuilder();
            for (String n : stringArray) {
                nameBuilder.append(n).append(separator);
            }
            nameBuilder.deleteCharAt(nameBuilder.length() - 1);
            return nameBuilder.toString();
        } else {
            return null;
        }
    }

    /**
     * StringSplit
     */
    public static String[] stringSplit(String string, String splitCharacter) {
        return string.split(splitCharacter);

    }

    /**
     * isConnected
     * This method is used to check for network connectivity before attempting a network call
     *
     * @param context the activity from where the method is called
     * @return true for is connected and false for is not connected
     */
    public static boolean isConnected(Context context) {
        ConnectivityManager cm =
                (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        return activeNetwork != null && activeNetwork.isConnectedOrConnecting();
    }

    /**
     * formatCurrency
     * @param amount the double amount to format as currency
     * @return the USD value
     */
    public static String formatCurrency(double amount){
        DecimalFormat dFormat = new DecimalFormat("#.00");
        return ("$" + dFormat.format(amount));
    }

    /**
     * getDateEnd
     * @param date the date that needs to be converted to an end date
     * @return a date at 11:59 PM
     */
    public static Date getDateEnd(Date date){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY,23);
        cal.set(Calendar.MINUTE,59);
        cal.set(Calendar.SECOND,59);
        cal.set(Calendar.MILLISECOND,59);
        long time = cal.getTimeInMillis();
        date.setTime(time);
        return date;
    }

}
