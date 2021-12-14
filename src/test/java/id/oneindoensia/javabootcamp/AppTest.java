package id.oneindoensia.javabootcamp;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import id.oneindoensia.javabootcamp.day4.beanvalidation.Address;
import id.oneindoensia.javabootcamp.day4.beanvalidation.ExampleClassData;
import id.oneindoensia.javabootcamp.day4.beanvalidation.ExampleClassEntry;
import id.oneindoensia.javabootcamp.day4.beanvalidation.Mahasiswa;
import id.oneindoensia.javabootcamp.day4.beanvalidation.container.Data;
import id.oneindoensia.javabootcamp.day4.beanvalidation.container.Entry;
import id.oneindoensia.javabootcamp.day4.beanvalidation.extractor.DataValueExtractor;
import id.oneindoensia.javabootcamp.day4.beanvalidation.extractor.EntryKeyExtractor;
import id.oneindoensia.javabootcamp.day4.beanvalidation.extractor.EntryValueExtractor;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import jakarta.validation.executable.ExecutableValidator;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Set;

/**
 * Unit test for simple App.
 */
public class AppTest 
{

    private Validator validator;
    private ExecutableValidator executableValidator;

    @Test
    public void shouldAnswerWithTrue()
    {
        validator = Validation.buildDefaultValidatorFactory().getValidator();

        Mahasiswa mahasiswa = new Mahasiswa();

        Set<ConstraintViolation<Mahasiswa>> violations = validator.validate(mahasiswa);
        for (ConstraintViolation<Mahasiswa> violation : violations) {
            System.out.println(violation.getMessage());
        }
    }

    @Test
    public void nestedValidation(){
        validator = Validation.buildDefaultValidatorFactory().getValidator();

        Mahasiswa mahasiswa = new Mahasiswa(123456L, "Iip Permana");
        Address address = new Address();
        mahasiswa.setAddress(address);

        Set<ConstraintViolation<Mahasiswa>> violations = validator.validate(mahasiswa);
        for (ConstraintViolation<Mahasiswa> violation : violations) {
            System.out.println(violation.getMessage());
        }
    }

    @Test
    public void sayHello() throws NoSuchMethodException {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
        executableValidator = validator.forExecutables();

        Mahasiswa mahasiswa = new Mahasiswa();
        String stringSayHello = "";

        Method method = Mahasiswa.class.getMethod("sayHello", String.class);

        Set<ConstraintViolation<Mahasiswa>> violations = executableValidator.validateParameters(mahasiswa, method, new Object[]{stringSayHello});

        for (ConstraintViolation<Mahasiswa> violation : violations) {
            System.out.println(violation.getPropertyPath());
            System.out.println(violation.getMessage());
        }
    }

    @Test
    public void mahasiswaName() throws NoSuchMethodException {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
        executableValidator = validator.forExecutables();

        Mahasiswa mahasiswa = new Mahasiswa();

        Method method = Mahasiswa.class.getMethod("mahasiswaName");

        String returnValue = mahasiswa.mahasiswaName();
        Set<ConstraintViolation<Mahasiswa>> violations = executableValidator.validateReturnValue(mahasiswa, method, returnValue);
        for (ConstraintViolation<Mahasiswa> violation : violations) {
            System.out.println(violation.getPropertyPath());
            System.out.println(violation.getMessage());
        }
    }

    @Test
    public void mahasiswaConstructorParam() throws NoSuchMethodException {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
        executableValidator = validator.forExecutables();

        Mahasiswa mahasiswa = new Mahasiswa();

        Constructor<Mahasiswa> constructor = Mahasiswa.class.getConstructor(Long.class, String.class);

        Set<ConstraintViolation<Mahasiswa>> violations = executableValidator.validateConstructorParameters(constructor, new Object[]{null, ""});

        for (ConstraintViolation<Mahasiswa> violation : violations) {
            System.out.println(violation.getPropertyPath());
            System.out.println(violation.getMessage());
        }
    }

    @Test
    public void mahasiswaConstructorReturnVal() throws NoSuchMethodException {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
        executableValidator = validator.forExecutables();

        Long nim = null;
        String name = "";

        Mahasiswa mahasiswa = new Mahasiswa(nim, name);

        Constructor<Mahasiswa> constructor = Mahasiswa.class.getConstructor(Long.class, String.class);

        Set<ConstraintViolation<Mahasiswa>> violations = executableValidator.validateConstructorReturnValue(constructor, mahasiswa);

        for (ConstraintViolation<Mahasiswa> violation : violations) {
            System.out.println(violation.getPropertyPath());
            System.out.println(violation.getMessage());
        }
    }

    @Test
    public void valueExtractorExample(){
        validator = Validation.byDefaultProvider().configure()
                .addValueExtractor(new DataValueExtractor())
                .buildValidatorFactory().getValidator();

        Data<String> stringData = new Data<>();

        ExampleClassData exampleClassData = new ExampleClassData();
        exampleClassData.setData(stringData);

        Set<ConstraintViolation<ExampleClassData>> violations = validator.validate(exampleClassData);

        for (ConstraintViolation<ExampleClassData> violation : violations) {
            System.out.println(violation.getPropertyPath());
            System.out.println(violation.getMessage());
        }
    }

    @Test
    public void multipleValueExtractorExample(){
        validator = Validation.byDefaultProvider().configure()
                .addValueExtractor(new EntryKeyExtractor())
                .addValueExtractor(new EntryValueExtractor())
                .buildValidatorFactory().getValidator();

        Entry<String, String> stringStringEntry = new Entry<>();

        ExampleClassEntry exampleClassEntry = new ExampleClassEntry();
        exampleClassEntry.setEntry(stringStringEntry);

        Set<ConstraintViolation<ExampleClassEntry>> violations = validator.validate(exampleClassEntry);

        for (ConstraintViolation<ExampleClassEntry> violation : violations) {
            System.out.println(violation.getPropertyPath());
            System.out.println(violation.getMessage());
        }
    }
}
