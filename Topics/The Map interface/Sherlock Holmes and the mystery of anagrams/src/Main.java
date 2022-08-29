import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner sc = new Scanner(System.in);
        char[] chars = sc.nextLine().toLowerCase().toCharArray();
        char[] chars1 = sc.nextLine().toLowerCase().toCharArray();

        var map = new HashMap<Character, Integer>();
        var map1 = new HashMap<Character, Integer>();

        for (char c : chars) {
            Integer count = map.getOrDefault(c, 0);
            map.put(c, count + 1);
        }

        for (char c : chars1) {
            Integer count = map1.getOrDefault(c, 0);
            map1.put(c, count + 1);
        }

        System.out.println(Objects.equals(map, map1) ? "yes" : "no");
    }
}