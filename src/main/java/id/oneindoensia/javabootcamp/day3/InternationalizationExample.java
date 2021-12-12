package id.oneindoensia.javabootcamp.day3;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.Date;
import java.util.Locale;

public class InternationalizationExample {
    public static void main(String[] args) {
        numberFormatExample();
    }

    private static void numberFormatExample(){
        // Here we get the below number
        // representation in various countries
        double d = 123456.789;
        NumberFormat nf = NumberFormat.getInstance(Locale.ITALY);
        NumberFormat nf1 = NumberFormat.getInstance(Locale.US);
        NumberFormat nf2 = NumberFormat.getInstance(Locale.CHINA);

        System.out.println("ITALY representation of " +
                d + " : " + nf.format(d));

        System.out.println("US representation of " +
                d + " : " + nf1.format(d));

        System.out.println("CHINA representation of " +
                d + " : " + nf2.format(d));
    }

    private static void localConstructor(){
        Locale deLocale = new Locale("de","De");
        Locale usLocale = new Locale("en","US");
        long number = 123456789L;
        NumberFormat denf = NumberFormat.getInstance(deLocale);
        NumberFormat usnf = NumberFormat.getInstance(usLocale);
        System.out.println( denf.format(number) );
        System.out.println( usnf.format(number) );

        Date now = new Date();
        DateFormat usdf = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, usLocale);
        DateFormat dedf = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, deLocale);
        System.out.println( usdf.format(now) );
        System.out.println( dedf.format(now) );
    }

    private static void localBuilder(){
        Locale locale = new Locale.Builder()
                .setLocale(Locale.US)
                .setLanguage("en")
                .setRegion("CA")
                .build();
        System.out.println(locale.getCountry());
    }

    private static void localLanguage(){
        Locale usLocale = Locale.forLanguageTag("en-US");
        Locale deLocale = Locale.forLanguageTag("de-Germany");
        long number = 123456789L;
        NumberFormat denf = NumberFormat.getInstance(deLocale);
        NumberFormat usnf = NumberFormat.getInstance(usLocale);
        System.out.println( denf.format(number) );
        System.out.println( usnf.format(number) );
    }

    private static void localeFromConstant(){
        Locale deLocale = Locale.GERMANY;
        Locale usLocale = Locale.US;
        long number = 123456789L;
        NumberFormat denf = NumberFormat.getInstance(deLocale);
        NumberFormat usnf = NumberFormat.getInstance(usLocale);
        System.out.println( denf.format(number) );
        System.out.println( usnf.format(number) );
    }
}
