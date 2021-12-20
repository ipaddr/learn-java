package id.oneindoensia.javabootcamp.day5.springbasic;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DemoWithoutXMLApps {
    public static void main(String[] args) {
        configWithoutComponentScan();
    }

    private static void configWithComponentScan(){
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(SpringConfig.class);

        Coach coach = context.getBean("trackCoach", Coach.class);

        System.out.println(coach.getDailyWorkout());
        System.out.println(coach.getDailyFortune());
    }

    private static void configWithoutComponentScan(){
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(SpringConfig.class);

        TrackCoach coach = context.getBean("trackCoach", TrackCoach.class);

        System.out.println(coach.getEmailAddress());
        System.out.println(coach.getTeam());
        System.out.println(coach.getDailyWorkout());
        System.out.println(coach.getDailyFortune());
    }
}
