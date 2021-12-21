package id.oneindoensia.javabootcamp.day4.beanvalidation;

import id.oneindoensia.javabootcamp.day4.beanvalidation.container.Data;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ExampleClassData {

    @NotNull(message = "data must not null")
    private Data<@NotBlank(message = "data generic param must not blank") String> data;

    public Data<String> getData() {
        return data;
    }

    public void setData(Data<String> data) {
        this.data = data;
    }
}
