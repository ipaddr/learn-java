public class Main {
    public static void main(String[] args) {
        FuncInterface fobj = new Test();

        fobj.abstractFun(5);
        fobj.helloWorld();
    }
}

class Test implements FuncInterface{
    @Override
    public void abstractFun(int x) {
        System.out.println(2*x);
    }
}

interface FuncInterface{
    void abstractFun(int x);

    default void helloWorld(){
        System.out.println("Hello World");
    }
}
