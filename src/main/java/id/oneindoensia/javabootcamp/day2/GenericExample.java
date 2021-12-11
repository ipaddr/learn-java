package id.oneindoensia.javabootcamp.day2;

public class GenericExample {

    static class Test<T>{
        // An object of type T is declared
        T obj;
        Test(T obj) {  this.obj = obj;  }  // constructor
        public T getObject()  { return this.obj; }
        public void setObject(T obj){
            this.obj = obj;
        }
    }

    static class TestMultiple<T, U>
    {
        T obj1;  // An object of type T
        U obj2;  // An object of type U

        // constructor
        TestMultiple(T obj1, U obj2)
        {
            this.obj1 = obj1;
            this.obj2 = obj2;
        }

        // To print objects of T and U
        public void print()
        {
            System.out.println(obj1);
            System.out.println(obj2);
        }
    }

    // A Generic method example
    static <T> void genericDisplay (T element)
    {
        System.out.println(element.getClass().getName() +
                " = " + element);
    }

    public static void main(String[] args) {
        // instance of Integer type
        Test <Integer> iObj = new Test<Integer>(15);
        System.out.println(iObj.getObject());

        // instance of String type
        Test <String> sObj =
                new Test<String>("This is Generic");
        System.out.println(sObj.getObject());

        /**
         * test multiple generic
         */
        TestMultiple <String, Integer> obj =
                new TestMultiple<>("Object Name", 15);

        obj.print();

        /**
         * generic method
         */
        // Calling generic method with Integer argument
        genericDisplay(11);

        // Calling generic method with String argument
        genericDisplay("GeeksForGeeks");

        // Calling generic method with double argument
        genericDisplay(1.0);
    }
}
