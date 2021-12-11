package id.oneindoensia.javabootcamp.day2;

import java.util.*;

public class ListAndImmutableListAndSetExample {
    public static void main(String[] args) {
        // Creating an object of List interface
        // implemented by the ArrayList class
        List<Integer> l1 = new ArrayList<Integer>();

        // Adding elements to object of List interface
        // Custom inputs

        l1.add(0, 1);
        l1.add(1, 2);

        // Print the elements inside the object
        System.out.println(l1);

        // Now creating another object of the List
        // interface implemented ArrayList class
        // Declaring object of integer type
        List<Integer> l2 = new ArrayList<Integer>();

        // Again adding elements to object of List interface
        // Custom inputs
        l2.add(1);
        l2.add(2);
        l2.add(3);

        // Will add list l2 from 1 index
        l1.addAll(1, l2);

        System.out.println(l1);

        // Removes element from index 1
        l1.remove(1);

        // Printing the updated List 1
        System.out.println(l1);

        // Prints element at index 3 in list 1
        // using get() method
        System.out.println(l1.get(3));

        // Replace 0th element with 5
        // in List 1
        l1.set(0, 5);

        // Again printing the updated List 1
        System.out.println(l1);

        /**
         * Immutable list
         */
        // non-empty immutable set
        List<String> list = List.of("One", "two", "three");

        // Let's print the list
        System.out.println(list);

        /**
         * Set
         */
        // Creating an object of Set class
        // Declaring object of Integer type
        Set<Integer> a = new HashSet<Integer>();

        // Adding all elements to List
        a.addAll(Arrays.asList(
                new Integer[] { 1, 3, 2, 4, 8, 9, 0 }));

        // Again declaring object of Set class
        // with reference to HashSet
        Set<Integer> b = new HashSet<Integer>();

        b.addAll(Arrays.asList(
                new Integer[] { 1, 3, 7, 5, 4, 0, 7, 5 }));


        // To find union
        Set<Integer> union = new HashSet<Integer>(a);
        union.addAll(b);
        System.out.print("Union of the two Set");
        System.out.println(union);

        // To find intersection
        Set<Integer> intersection = new HashSet<Integer>(a);
        intersection.retainAll(b);
        System.out.print("Intersection of the two Set");
        System.out.println(intersection);

        // To find the symmetric difference
        Set<Integer> difference = new HashSet<Integer>(a);
        difference.removeAll(b);
        System.out.print("Difference of the two Set");
        System.out.println(difference);

        // Creating an object of Set and
        // declaring object of type String
        Set<String> hs = new HashSet<String>();

        // Elements are added using add() method
        // Later onwards we wil show accessing the same

        // Custom input elements
        hs.add("A");
        hs.add("B");
        hs.add("C");
        hs.add("A");
        hs.add("D");

        // Declaring a string
        String check = "D";

        // Check if the above string exists in
        // the SortedSet or not
        // using contains() method
        System.out.println("Contains " + check + " "
                + hs.contains(check));

        // Printing initial Set elements
        System.out.println("Initial HashSet " + hs);

        // Removing custom element
        // using remove() method
        hs.remove("B");

        // Printing Set elements after removing an element
        // and printing updated Set elements
        System.out.println("After removing element " + hs);

    }
}
