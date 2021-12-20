package id.oneindoensia.javabootcamp.day5.springbasic;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringApp {

	public static void main(String[] args) {

		// load the spring configuration file
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
				
		// retrieve bean from spring container
		TrackCoach trackCoach = context.getBean("TrackCoach", TrackCoach.class);
		BaseballCoach baseballCoach = context.getBean("BaseballCoach", BaseballCoach.class);
		Coach cricketCoach = context.getBean("CricketCoach", Coach.class);
		
		// call methods on the bean
		System.out.println(trackCoach.getDailyWorkout());
		System.out.println(trackCoach.getDailyFortune());
		System.out.println(trackCoach.getEmailAddress());
		System.out.println(trackCoach.getTeam());

		System.out.println(baseballCoach.getDailyWorkout());
		System.out.println(baseballCoach.getDailyFortune());
		System.out.println(baseballCoach.getEmailAddress());
		System.out.println(baseballCoach.getTeam());

		System.out.println(cricketCoach.getDailyWorkout());
		System.out.println(cricketCoach.getDailyFortune());
		
		// close the context
		context.close();
	}

}







