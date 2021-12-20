package id.oneindoensia.javabootcamp.day4.stunting;

public class Main {
    public static void main(String[] args) {
        IRepository ibuHamil = new IbuHamilRepository();
        ibuHamil.insert("insert");
        ibuHamil.upadate("update");
        ibuHamil.delete("delete");
    }
}
