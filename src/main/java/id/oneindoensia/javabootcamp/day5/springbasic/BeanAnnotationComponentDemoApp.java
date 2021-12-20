package id.oneindoensia.javabootcamp.day5.springbasic;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanAnnotationComponentDemoApp {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("beanAnnnotationComponent-applicationContext.xml");

        Coach beanAnnotationCoach = context.getBean("beanAnnotationComponentCoach", Coach.class);

        System.out.println(beanAnnotationCoach.getDailyWorkout());
        System.out.println(beanAnnotationCoach.getDailyFortune());

    }
}
