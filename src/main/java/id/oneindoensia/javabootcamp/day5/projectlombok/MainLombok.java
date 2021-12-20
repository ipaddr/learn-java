package id.oneindoensia.javabootcamp.day5.projectlombok;

public class MainLombok {
    public static void main(String[] args) {

        Mahasiswa mahasiswa =
                new Mahasiswa(123123, "teman mahasiswa"
                        , 1000000.32, "Some address");

        System.out.println(mahasiswa.getNim());
        System.out.println(mahasiswa.getName());
        System.out.println(mahasiswa.getNoRekening());
        System.out.println(mahasiswa.getAddress());
    }
}
