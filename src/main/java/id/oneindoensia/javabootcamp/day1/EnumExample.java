package id.oneindoensia.javabootcamp.day1;

public class EnumExample {

    public enum WheelNumbers {
        ONE, TWO, THREE, FOUR;
    }

    public static class Vehicle {
        private WheelNumbers wheelNumbers;

        public void vehicleType() {
            switch (wheelNumbers) {
                case ONE -> {
                    System.out.println("Not sure");
                    break;
                }
                case TWO -> {
                    System.out.println("Motor Cycle");
                    break;
                }
                case THREE -> {
                    System.out.println("3 wheel motor cycle");
                    break;
                }
                case FOUR -> {
                    System.out.println("car");
                    break;
                }
                default -> throw new IllegalStateException("Unexpected value: " + wheelNumbers);
            }
        }
    }

    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle();
        vehicle.wheelNumbers = WheelNumbers.FOUR;
        vehicle.vehicleType();
    }
}
