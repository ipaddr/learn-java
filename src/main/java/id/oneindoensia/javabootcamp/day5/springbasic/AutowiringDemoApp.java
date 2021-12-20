package id.oneindoensia.javabootcamp.day5.springbasic;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AutowiringDemoApp {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("beanAnnnotationComponent-applicationContext.xml");

        TrackCoach autowiringAnnotationCoach = context.getBean("trackCoach", TrackCoach.class);

        System.out.println(autowiringAnnotationCoach.getDailyWorkout());
        System.out.println(autowiringAnnotationCoach.getDailyFortune());
        System.out.println(autowiringAnnotationCoach.getFortuneCombination());
    }
}
