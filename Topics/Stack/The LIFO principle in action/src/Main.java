import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner sc = new Scanner(System.in);

        Deque<Integer> stack = new ArrayDeque<>();

        int to = sc.nextInt();
        for (int i = 0; i < to; i++) {
            stack.push(sc.nextInt());
        }

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}