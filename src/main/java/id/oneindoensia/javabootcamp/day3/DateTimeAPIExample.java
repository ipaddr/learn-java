package id.oneindoensia.javabootcamp.day3;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.TimeZone;

public class DateTimeAPIExample {
    public static void main(String[] args) {
        formattingExample();
    }

    private static void parseDate(){
        String input = "Dec 12 2021";
        try {
            DateTimeFormatter formatter =
                    DateTimeFormatter.ofPattern("MMM d yyyy");
            LocalDate date = LocalDate.parse(input, formatter);
            System.out.printf("%s%n", date);
        }
        catch (DateTimeParseException exc) {
            System.out.printf("%s is not parsable!%n", input);
            throw exc;      // Rethrow the exception.
        }
        // 'date' has been successfully parsed
    }

    private static void formattingExample(){
        ZoneId leavingZone = ZoneId.of("America/Los_Angeles");
        ZonedDateTime departure = ZonedDateTime.now(leavingZone);

        try {
            DateTimeFormatter format = DateTimeFormatter.ofPattern("MMM d yyyy  hh:mm a");
            String out = departure.format(format);
            System.out.printf("LEAVING:  %s (%s)%n", out, leavingZone);
        }
        catch (DateTimeException exc) {
            System.out.printf("%s can't be formatted!%n", departure);
            throw exc;
        }
    }

    private static void monthOfdayExample(){
        // Creating an object of MonthDay class by
        // storing instance of MonthDay by
        // passing date and month as arguments

        // Custom inputs are passed as arguments
        MonthDay monthday = MonthDay.of(Month.MARCH, 14);

        // Print and display the value stored
        System.out.println(monthday);

        // Store an instance of MonthDay
        // from a text i.e --03-14
        MonthDay monthday2 = MonthDay.parse("--03-14");

        // Display the month using instance of class
        System.out.println(monthday2.getMonth());
    }

    private static void timezoneExample(){
        String[] id = TimeZone.getAvailableIDs();
        System.out.println("In TimeZone class available Ids are: ");
        for (int i=0; i<id.length; i++){
            System.out.println(id[i]);
        }

        SimpleDateFormat isoFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        isoFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        try {
            Date date = isoFormat.parse("2010-05-23T09:01:02");
            System.out.println(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private static void localDateTimeApi()
    {

        // the current date
        LocalDate date = LocalDate.now();
        System.out.println("the current date is "+
                date);


        // the current time
        LocalTime time = LocalTime.now();
        System.out.println("the current time is "+
                time);


        // will give us the current time and date
        LocalDateTime current = LocalDateTime.now();
        System.out.println("current date and time : "+
                current);


        // to print in a particular format
        DateTimeFormatter format =
                DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        String formatedDateTime = current.format(format);

        System.out.println("in formatted manner "+
                formatedDateTime);


        // printing months days and seconds
        Month month = current.getMonth();
        int day = current.getDayOfMonth();
        int seconds = current.getSecond();
        System.out.println("Month : "+month+" day : "+
                day+" seconds : "+seconds);

        // printing some specified date
        LocalDate date2 = LocalDate.of(1950,1,26);
        System.out.println("the republic day :"+date2);

        // printing date with current time.
        LocalDateTime specificDate =
                current.withDayOfMonth(24).withYear(2016);

        System.out.println("specific date with "+
                "current time : "+specificDate);
    }

    private static void zonedTimeAndDate()
    {
        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter format1 =
                DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        String formattedCurrentDate = date.format(format1);

        System.out.println("formatted current Date and"+
                " Time : "+formattedCurrentDate);

        // to get the current zone
        ZonedDateTime currentZone = ZonedDateTime.now();
        System.out.println("the current zone is "+
                currentZone.getZone());

        // getting time zone of specific place
        // we use withZoneSameInstant(): it is
        // used to return a copy of this date-time
        // with a different time-zone,
        // retaining the instant.
        ZoneId tokyo = ZoneId.of("Asia/Tokyo");

        ZonedDateTime tokyoZone =
                currentZone.withZoneSameInstant(tokyo);

        System.out.println("tokyo time zone is " +
                tokyoZone);

        DateTimeFormatter format =
                DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        String formatedDateTime = tokyoZone.format(format);

        System.out.println("formatted tokyo time zone "+
                formatedDateTime);

    }

    // duration format
    // https://www.digi.com/resources/documentation/digidocs/90001437-13/reference/r_iso_8601_duration_format.htm
    private static void checkingPeriod()
    {
        LocalDate date1 = LocalDate.now();

        LocalDate date2 =
                LocalDate.of(2014, Month.DECEMBER, 12);

        Period gap = Period.between(date2, date1);
        System.out.println("gap between dates "+
                "is a period of "+gap);
    }

    // duration format
    // https://www.digi.com/resources/documentation/digidocs/90001437-13/reference/r_iso_8601_duration_format.htm
    private static void checkingDuration()
    {

        LocalTime time1 = LocalTime.now();
        System.out.println("the current time is " +
                time1);

        Duration fiveHours = Duration.ofHours(5);

        // adding five hours to the current
        // time and storing it in time2
        LocalTime time2 = time1.plus(fiveHours);

        System.out.println("after adding five hours " +
                "of duration " + time2);

        Duration gap = Duration.between(time2, time1);
        System.out.println("duration gap between time1" +
                " & time2 is " + gap.toString());
    }
}
