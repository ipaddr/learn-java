package id.oneindoensia.javabootcamp.day2;

import java.util.UUID;

public class UUIDExample {
    public static void main(String[] args) {
        UUID gfg = UUID.fromString("c81d4e2e-bcf2-11e6-869b-7df92533d2db");

        // checking clock sequence
        System.out.println(gfg.clockSequence());

        // generating random UUID
        UUID gfg1 = UUID.randomUUID();
        UUID gfg2 = UUID.randomUUID();

        int compare = gfg1.compareTo(gfg2);
        if(compare==1)
            System.out.println("gfg1 is greater than gfg2");
        else if(compare==0)
            System.out.println("both are equal");
        else
            System.out.println("gfg1 is smaller than gfg2");

        if(gfg1.equals(gfg2))
            System.out.println("both are equal");
        else
            System.out.println("both are not same");

        // checking the least significatnt bit
        System.out.println("Least significant bit " +
                gfg.getLeastSignificantBits());

        // checking the most significatnt bit
        System.out.println("Most significant bit " +
                gfg.getMostSignificantBits());

        // checking the hash code for this UUID
        System.out.println("Hash code " +
                gfg.hashCode());

        // creating byte array
        byte[] b = {10, 23, 45};

        // creating UUID from array
        UUID gfg3 = UUID.nameUUIDFromBytes(b);

        // checking UUID
        System.out.println(gfg3);

        UUID gfg4 = UUID.fromString("c81d4e2e-bcf2-11e6-869b-7df92533d2db");

        // checking node value for this UUID
        System.out.println("Node value: "
                + gfg4.node());

        UUID gfg5 = UUID.randomUUID();

        // checking  this UUID
        System.out.println("UUID: "
                + gfg5);

        UUID gfg6 = UUID.fromString("c81d4e2e-bcf2-11e6-869b-7df92533d2db");

        // checking time stamp for this UUID
        System.out.println("time stamp: "
                + gfg6.timestamp());

        UUID gfg7 = UUID.fromString("c81d4e2e-bcf2-11e6-869b-7df92533d2db");

        // checking string format for this UUID
        System.out.println("String equivalent: "
                + gfg7.toString());

        UUID gfg8 = UUID.fromString("c81d4e2e-bcf2-11e6-869b-7df92533d2db");

        // checking variant number for this UUID
        System.out.println("variant number is: "
                + gfg8.variant());
    }
}
