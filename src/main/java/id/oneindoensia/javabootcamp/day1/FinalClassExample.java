package id.oneindoensia.javabootcamp.day1;

public final class FinalClassExample implements InterfaceExample{

    private String flyRange = "long";

    @Override
    public void fly() {
        System.out.println("this can fly : "+ flyRange);
    }

    private class newTest implements InterfaceExample{
        @Override
        public final void fly() {
            System.out.println("this can fly : "+ flyRange);
        }
    }

    private class newTestAgain extends newTest{
    }
}
