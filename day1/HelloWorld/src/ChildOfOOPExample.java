public class ChildOfOOPExample extends OOPExample{

    public ChildOfOOPExample(String propertyOne, String propertyTwo) {
        super(propertyOne, propertyTwo);
    }

    @Override
    public void combineProperties() {
        System.out.println(getPropertyTwo() + " dan " + getPropertyOne());
    }

    public void combineProperties(String propertyOne, String propertyTwo) {
        System.out.println(propertyOne + " dan " + propertyTwo);
    }
}
