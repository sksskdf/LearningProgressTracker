import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;

class Main {
    public static void main(String[] args) {
        // put your code here
        var sc = new Scanner(System.in);
        int from = sc.nextInt();
        int to = sc.nextInt();
        int it = sc.nextInt();
        var map = new TreeMap<Integer, String>();
        while (it > 0) {
            int key = sc.nextInt();
            String val = sc.next();
            map.put(key, val);
            it--;
        }
        var subMap = map.subMap(from, to + 1);
        subMap.forEach((k, v) -> System.out.println(k + " " + v));
    }
}