package id.oneindoensia.javabootcamp.day4.beanvalidation;

import id.oneindoensia.javabootcamp.day4.beanvalidation.container.Entry;
import jakarta.validation.constraints.NotBlank;

public class ExampleClassEntry {
    private Entry<@NotBlank(message = "Entry key must not blank")
            String,@NotBlank(message = "Entry value must not blank") String> entry;

    public void setEntry(Entry<String, String> entry) {
        this.entry = entry;
    }

    public Entry<String, String> getEntry() {
        return entry;
    }
}
