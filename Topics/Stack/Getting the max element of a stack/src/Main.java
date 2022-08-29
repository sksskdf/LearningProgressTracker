import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Deque<Integer> stk = new ArrayDeque<>();
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        while (n-- > 0) {
            switch (s.next()) {
                case "push": int i = s.nextInt();
                    stk.push(stk.isEmpty() || i >= stk.peek() ? i : stk.peek());
                    break;
                case "pop": stk.pop();
                    break;
                default: System.out.println(stk.peek());
            }
        }
    }
}