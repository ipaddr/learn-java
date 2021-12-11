package id.oneindoensia.javabootcamp.day2;

import java.util.*;

public class CollectionIterableIteratorExample {
    public static void main(String[] args) {
        // Creating instances of the array,
        // vector and hashtable
        int arr[] = new int[] { 1, 2, 3, 4 };
        Vector<Integer> v = new Vector();
        Hashtable<Integer, String> h = new Hashtable<>();

        // Adding the elements into the
        // vector
        v.addElement(1);
        v.addElement(2);

        // Adding the element into the
        // hashtable
        h.put(1, "first element on hashtabel");
        h.put(2, "second element on hashtable");

        // Array instance creation requires [],
        // while Vector and hastable require ()
        // Vector element insertion requires addElement(),
        // but hashtable element insertion requires put()

        // Accessing the first element of the
        // array, vector and hashtable
        System.out.println(arr[0]);
        System.out.println(v.elementAt(0));
        System.out.println(h.get(1));

        // Array elements are accessed using [],
        // vector elements using elementAt()
        // and hashtable elements using get()

        /**
         * using collection
         */
        Collection<Integer> integers = new Vector<>();
        integers.add(Integer.valueOf(1));
        integers.add(Integer.valueOf(2));
        integers.add(Integer.valueOf(3));
        integers.add(Integer.valueOf(4));
        integers.add(Integer.valueOf(5));

        integers.remove(Integer.valueOf(3));

        System.out.println(integers);

        /**
         * Iterable
         */
        // create a list
        List<String> list = new ArrayList<String>();

        // add elements
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");
        list.add("five");

        // Iterate through the list
        for( String element : list ){
            System.out.println( element );
        }

        // Iterate through the list
        list.forEach(
                (element) -> { System.out.println(element); });

        /**
         * using iterator
         */
        Iterator<String> iterator = list.iterator();

        while (iterator.hasNext()) {
            String element = iterator.next();
            System.out.println(element);
        }
    }
}
