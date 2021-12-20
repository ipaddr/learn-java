package id.oneindoensia.javabootcamp.day5.springbasic;

import org.springframework.stereotype.Component;

@Component
public class RESTFortuneService implements FortuneService{
    @Override
    public String getFortune() {
        return "I'm forutune from RESTFortuneService";
    }
}
