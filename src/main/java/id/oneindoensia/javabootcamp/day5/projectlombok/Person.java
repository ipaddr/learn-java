package id.oneindoensia.javabootcamp.day5.projectlombok;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class Person {
    private Date birthDate;
}
