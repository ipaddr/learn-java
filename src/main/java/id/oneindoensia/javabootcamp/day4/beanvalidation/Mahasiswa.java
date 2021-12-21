package id.oneindoensia.javabootcamp.day4.beanvalidation;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Range;

public class Mahasiswa {

    @NotNull(message = "nim can not empty")
    @Range(min = 100_000_000L, max = 999_999_999L, message = "Amount must between 100.000.000 dan 999.999.999")
    private Long nim;

    @NotBlank(message = "name can not empty")
    @Size(max = 30, message = "name max is 30 char")
    private String name;

    @NotNull(message = "address can not null")
    @Valid
    private Address address;

    public Mahasiswa(){}

    @Valid
    public Mahasiswa(@NotNull(message = "Nim param from constructor can not null") Long nim,
                     @NotBlank(message = "name param from constructor can not blank") String name) {
        this.nim = nim;
        this.name = name;
    }

    public Long getNim() {
        return nim;
    }

    public void setNim(Long nim) {
        this.nim = nim;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Mahasiswa{" +
                "nim=" + nim +
                ", name='" + name + '\'' +
                ", address=" + address +
                '}';
    }

    public void sayHello(@NotBlank(message = "sayHello param name must not blank") String name){
        System.out.println("Hi "+name+ ", My name is "+this.name);
    }

    @NotBlank(message = "Mahasiswa name can not blank")
    public String mahasiswaName(){
        return name;
    }
}
