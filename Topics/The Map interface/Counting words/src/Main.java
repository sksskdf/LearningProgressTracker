import java.util.*;

class MapUtils {

    public static SortedMap<String, Integer> wordCount(String[] strings) {
        // write your code here
        var map = new TreeMap<String, Integer>();
        for (String word : strings) {
            int count = map.getOrDefault(word, 0);
            map.put(word, count + 1);
        }
        return map;
    }

    public static void printMap(Map<String, Integer> map) {
        // write your code here
        for (var a : map.entrySet()) {
            System.out.println(a.getKey() + " : " + a.getValue());
        }
    }

}

/* Do not change code below */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] words = scanner.nextLine().split(" ");
        MapUtils.printMap(MapUtils.wordCount(words));
    }
}