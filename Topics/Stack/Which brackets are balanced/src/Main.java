import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Character> brackets = new ArrayDeque<>();

        String openingBrackets = "({[";
        String closingBrackets = ")}]";
        char[] input = scanner.nextLine().toCharArray();

        boolean matched = true;

        for (char c : input) {
            if (openingBrackets.indexOf(c) > -1) {
                brackets.push(c);
                matched = false;
            } else if (closingBrackets.indexOf(c) > -1) {
                Character b = brackets.pollFirst();
                matched = b != null && openingBrackets.indexOf(b) == closingBrackets.indexOf(c);
            }
        }

        System.out.println(matched && brackets.size() == 0);
    }
}