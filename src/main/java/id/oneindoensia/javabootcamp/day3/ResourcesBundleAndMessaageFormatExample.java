package id.oneindoensia.javabootcamp.day3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;

public class ResourcesBundleAndMessaageFormatExample {
    public static void main(String[] args) throws IOException {

        resourcesBundleWithMessageFormat(new Locale("es"));
    }

    private static void resourceBundleExample(){
//        FileInputStream fis = new FileInputStream("message.properties");
//        Properties properties = new Properties();
//        properties.load(fis);
//
//        System.out.println("Name : "+properties.getProperty("name"));
//        System.out.println("country : "+properties.getProperty("country"));

        Locale locale = new Locale("es_ES");
        ResourceBundle resourceBundle = ResourceBundle
                .getBundle("message_es", locale);
        String name = resourceBundle.getString("name");
        String country = resourceBundle.getString("country");
        System.out.println("name : "+name);
        System.out.println("country : "+country);
    }

    private static void messageFormatExample(){
        String pattern = "On {0, date}, {1} sent you "
                + "{2, choice, 0#no messages|1#a message|2#two messages|2<{2, number, integer} messages}.";
        MessageFormat formatter = new MessageFormat(pattern, Locale.US);
        String message = formatter.format(new Object[] {new Date(), "Alice", 0});

        System.out.println(message);
    }

    private static void resourcesBundleWithMessageFormat(Locale locale){
        System.out.println(locale.getCountry());
        String countryCode = locale.getLanguage();

        StringBuilder sb = new StringBuilder("message");
        sb.append("_");
        sb.append(countryCode);
        String fileMessage = sb.toString();


        ResourceBundle resourceBundle = null;
        File f = new File("src/main/resources/"+fileMessage+".properties");
        if(f.exists()) {
            // do something
            resourceBundle = ResourceBundle
                    .getBundle(fileMessage, locale);
        } else {
            resourceBundle = ResourceBundle
                    .getBundle("message", Locale.US);
        }


        String name = resourceBundle.getString("name");
        String country = resourceBundle.getString("country");
        String message = resourceBundle.getString("message");
        System.out.println("name : "+name);
        System.out.println("country : "+country);
        System.out.println("message : "+message);

        String messagePattern = "Seseorang bernama {0} dari negara {1} {2}";
        MessageFormat messageFormat =  new MessageFormat(messagePattern, locale);
        String finalMessage = messageFormat.format(new Object[]{name, country, message});
        System.out.println(finalMessage);

    }
}
