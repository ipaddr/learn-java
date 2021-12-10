import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LambaExpressionCollectionExample {
    // operation is implemented using lambda expressions
    interface FuncInter1
    {
        int operation(int a, int b);
    }

    // sayMessage() is implemented using lambda expressions
    // above
    interface FuncInter2
    {
        void sayMessage(String message);
    }

    // Performs FuncInter1's operation on 'a' and 'b'
    private int operate(int a, int b, FuncInter1 fobj)
    {
        return fobj.operation(a, b);
    }

    private static void lambaMultipleParameter(){
        // lambda expression for addition for two parameters
        // data type for x and y is optional.
        // This expression implements 'FuncInter1' interface
        FuncInter1 add = (int x, int y) -> x + y;

        // lambda expression multiplication for two parameters
        // This expression also implements 'FuncInter1' interface
        FuncInter1 multiply = (int x, int y) -> x * y;

        // Creating an object of Test to call operate using
        // different implementations using lambda Expressions
        LambaExpressionCollectionExample tobj = new LambaExpressionCollectionExample();

        // Add two numbers using lambda expression
        System.out.println("Addition is " +
                tobj.operate(6, 3, add));

        // Multiply two numbers using lambda expression
        System.out.println("Multiplication is " +
                tobj.operate(6, 3, multiply));

        // lambda expression for single parameter
        // This expression implements 'FuncInter2' interface
        FuncInter2 fobj = message ->System.out.println("Hello "
                + message);
        fobj.sayMessage("Hi java bootcamp");
    }

    private static void lambaCollection(){
        ArrayList<Integer> al = new ArrayList<Integer>();
        al.add(205);
        al.add(102);
        al.add(98);
        al.add(275);
        al.add(203);
        System.out.println("Elements of the ArrayList " +
                "before sorting : " + al);

        // using lambda expression in place of comparator object
        Collections.sort(al, (o1, o2) -> (o1 > o2) ? -1 :
                (o1 < o2) ? 1 : 0);

        System.out.println("Elements of the ArrayList after" +
                " sorting descending : " + al);

        List sortedList = al.stream().sorted((o1, o2) -> (o1 > o2) ? 1 :
                (o1 < o2) ? -1 : 0).toList();

        System.out.println("Elements of the ArrayList after" +
                " sorting ascending : " + sortedList);
    }

    static boolean compute(String s){
        System.out.println("long running process");
        return s.contains("a");
    }

    public static void main(String args[])
    {
        lambaCollection();

    }


}
