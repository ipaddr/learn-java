package id.oneindoensia.javabootcamp.day5.springbasic;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifecyclerDemoApp {

	public static void main(String[] args) {

		// load context;
		ClassPathXmlApplicationContext context =
				new ClassPathXmlApplicationContext("beanLifecycler-applicationContext.xml");

		Coach theCoach = context.getBean("TrackCoach", Coach.class);

		System.out.println(theCoach.getDailyWorkout());

		// close context
		context.close();
	}

}
