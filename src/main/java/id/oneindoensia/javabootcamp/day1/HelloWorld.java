package id.oneindoensia.javabootcamp.day1;

public class HelloWorld {
    public static void main(String[] args) throws ClassNotFoundException {
        System.out.println("Hello World");
        int myFirstNumber = 10 + 5 + (2 * 10);
        int mySecondNumber = 16;
        int myThirdNumber = 7;
        int total = myFirstNumber + mySecondNumber + myThirdNumber;
        System.out.println(total);
        int randomNumber = 1000;
        int lastNumberResult = randomNumber - total;
        System.out.println(lastNumberResult);
        sebuahFungsi();
    }

    private static void sebuahFungsi() throws ClassNotFoundException {
        System.out.println("saya sebuah fungsi");
        fungsilainnya();

    }

    private static void fungsilainnya(){
        System.out.println("saya dari fungsi lainya");
        fungsiTerakhir();
    }

    private static void fungsiTerakhir(){
        System.out.println("call dari  fungsi terakhir");
        Integer saldo = null;
        if (saldo == null) {
            throw new NullPointerException("Saldo tidak boleh null");
        }
        saldo += 1000000;
        System.out.println("nilai s = "+saldo);
    }

}
