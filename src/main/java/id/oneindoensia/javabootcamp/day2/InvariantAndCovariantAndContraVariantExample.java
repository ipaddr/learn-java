package id.oneindoensia.javabootcamp.day2;

public class InvariantAndCovariantAndContraVariantExample {
    public static void main(String[] args) {
        // invariant
        GenericExample.Test<String>  stringTest = new GenericExample.Test<>("String");
        //GenericExample.Test<Object> objectTest = stringTest; // Error

        GenericExample.Test<Object> objectTest = new GenericExample.Test<>("Object");
        //GenericExample.Test<String> stringTest1 = objectTest1; // Error

        doSomething (objectTest);

        doSomethingCovariant(stringTest);
        GenericExample.Test<? extends Object> strExtendObj = new GenericExample.Test<>("strExtendObj");
        doSomethingCovariant(strExtendObj);

        doSomethingContravariant(stringTest);
        GenericExample.Test<? super String> testSuperString = new GenericExample.Test<>("objSuperString");
        doSomethingContravariant(testSuperString);
    }

    public static void doSomething(GenericExample.Test<Object> objectTest){
        System.out.println(objectTest.obj.toString());
    }

    public static void doSomethingCovariant(GenericExample.Test<? extends Object>  objectTest){

        System.out.println(objectTest.obj.toString());
    }

    public static void doSomethingContravariant(GenericExample.Test<? super String>  objectTest){
        System.out.println(objectTest.obj.toString());
    }
}
