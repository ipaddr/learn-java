package id.oneindoensia.javabootcamp.day4.stunting;

public class IbuHamilRepository implements IRepository<java.lang.String> {
    @Override
    public void insert(java.lang.String objekibuhamilataubayibalita) {
        System.out.println(objekibuhamilataubayibalita);
    }

    @Override
    public void upadate(java.lang.String objekibuhamilataubayibalita) {
        System.out.println(objekibuhamilataubayibalita);
    }

    @Override
    public void delete(java.lang.String objekibuhamilataubayibalita) {
        System.out.println(objekibuhamilataubayibalita);
    }
}
