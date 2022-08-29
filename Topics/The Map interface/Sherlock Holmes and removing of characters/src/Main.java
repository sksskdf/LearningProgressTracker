import java.util.HashMap;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner sc = new Scanner(System.in);
        char[] chars = sc.nextLine().toLowerCase().toCharArray();
        char[] chars1 = sc.nextLine().toLowerCase().toCharArray();

        var map = new HashMap<Character, Integer>();

        for (char c : chars) {
            int count = map.getOrDefault(c, 0);
            map.put(c, count+1);
        }

        for (char c : chars1) {
            int count = map.getOrDefault(c, 0);
            map.put(c, count-1);
        }

        int sum = map.values().stream().mapToInt(e -> Math.abs(Integer.valueOf(e))).sum();
        System.out.println(sum);
    }
}