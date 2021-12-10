import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapExample {
    public static void main(String[] args) {
        Map<String, Integer> hm
                = new HashMap<String, Integer>();

        hm.put("a", Integer.valueOf(100));
        hm.put("b", Integer.valueOf(200));
        hm.put("c", Integer.valueOf(300));
        hm.put("d", Integer.valueOf(400));

        // Traversing through the map
        for (Map.Entry<String, Integer> me : hm.entrySet()) {
            System.out.print(me.getKey() + ":");
            System.out.println(me.getValue());
        }

        System.out.println("Initial Map " + hm);

        hm.put("b", Integer.valueOf(1000));

        System.out.println("Updated Map " + hm);

        // Initial Map
        System.out.println(hm);

        hm.remove("a");

        // Final Map
        System.out.println(hm);

        /**
         * characteristic
         */

        Map<String, Integer> map
                = new HashMap<>();

        map.put("Budi", 10);
        map.put("Andi", 30);
        map.put("Bayu", 20);

        for (Map.Entry<String, Integer> e : map.entrySet())
            System.out.println(e.getKey() + " "
                    + e.getValue());

        System.out.println("==========================");

        Map<String, Integer> map2
                = new LinkedHashMap<>();

        map2.put("Budi", 10);
        map2.put("Andi", 30);
        map2.put("Bayu", 20);

        for (Map.Entry<String, Integer> e : map2.entrySet())
            System.out.println(e.getKey() + " "
                    + e.getValue());

        System.out.println("==========================");

        Map<String, Integer> map3
                = new TreeMap<>();

        map3.put("Budi", 10);
        map3.put("Andi", 30);
        map3.put("Bayu", 20);

        for (Map.Entry<String, Integer> e : map3.entrySet())
            System.out.println(e.getKey() + " "
                    + e.getValue());
    }
}
