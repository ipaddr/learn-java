package id.oneindoensia.javabootcamp.day5.springmvc.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor()
public class Employee {
    private int id;

    @NotBlank(message = "not allow blank")
    @Size(min = 3, max = 20)
    private String firstName;

    @NotBlank(message = "not allow blank")
    @Size(min = 3, max = 20)
    private String lastName;

    private String email;
}
