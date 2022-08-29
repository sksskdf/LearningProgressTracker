import java.sql.Array;
import java.util.*;

class MapUtils {
    public static Map<Integer, String> getSubMap(TreeMap<Integer, String> map) {
        // Write your code here
        int from;
        int to;
        if (map.firstKey() % 2 != 0) {
            from = map.firstKey();
            to = map.firstKey() + 4;
        } else {
            from = map.lastKey() - 4;
            to = map.lastKey();
        }

        return map.descendingMap().subMap(to, from - 1);
    }
}

/* Do not modify code below */
public class Main {
    public static void main(String[] args) {
        var map = new HashMap<Integer, String>();
        map.put(27,"Fairy Godmother");
        map.put(null, "null");
        System.out.println(map.get(27).hashCode());

        Scanner scanner = new Scanner(System.in);

//        TreeMap<Integer, String> map = new TreeMap<>();
//        Arrays.stream(scanner.nextLine().split("\\s")).forEach(s -> {
//            String[] pair = s.split(":");
//            map.put(Integer.parseInt(pair[0]), pair[1]);
//        });
//
//        Map<Integer, String> res = MapUtils.getSubMap(map);
//        res.forEach((k, v) -> System.out.println(k + " : " + v));
    }
}