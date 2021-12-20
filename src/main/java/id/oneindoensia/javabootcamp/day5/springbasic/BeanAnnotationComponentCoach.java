package id.oneindoensia.javabootcamp.day5.springbasic;

import org.springframework.stereotype.Component;

@Component("beanAnnotationComponentCoach")
public class BeanAnnotationComponentCoach implements Coach{
    @Override
    public String getDailyWorkout() {
        return "BeanAnnotationComponentCoach getDailyWorkout";
    }

    @Override
    public String getDailyFortune() {
        return "BeanAnnotationComponentCoach getDailyFortune";
    }
}
