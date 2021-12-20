package id.oneindoensia.javabootcamp.day5.springbasic;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {
    public static void main(String[] args) {
        beanLifecycle();
    }

    private static void beanScopeXML(){
        // load spring config file
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");

        // retrieve bran from spring container
        Coach theChoach = context.getBean("TrackCoach", Coach.class);

        Coach alphaChoach = context.getBean("TrackCoach", Coach.class);

        boolean isSame = theChoach == alphaChoach;

        System.out.println(isSame);
    }

    private static void beanScopeAnnotation(){
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("beanAnnnotationComponent-applicationContext.xml");


        // retrieve bran from spring container
        Coach theChoach = context.getBean("trackCoach", Coach.class);

        Coach alphaChoach = context.getBean("trackCoach", Coach.class);

        boolean isSame = theChoach == alphaChoach;

        System.out.println(isSame);

    }

    private static void beanLifecycle(){
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("beanAnnnotationComponent-applicationContext.xml");


        // retrieve bran from spring container
        Coach theChoach = context.getBean("trackCoach", Coach.class);

        System.out.println(theChoach.getDailyWorkout());
        System.out.println(theChoach.getDailyFortune());

        context.close();
    }
}
