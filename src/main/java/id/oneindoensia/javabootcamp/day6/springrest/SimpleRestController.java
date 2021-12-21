package id.oneindoensia.javabootcamp.day6.springrest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;

public class SimpleRestController {

    @Value("${name.firstName}")
    protected String firstName;

    @Value("${name.lastName}")
    protected String lastName;

    @GetMapping("/")
    public String sayHello(){
        return "Hello World! \nMy first name is "+firstName+ "and my last name is "+lastName+"  \nServer time is "+ LocalDateTime.now();
    }

    @GetMapping("/ola")
    public String sayOla(){
        return "Hi from OLA";
    }


}
