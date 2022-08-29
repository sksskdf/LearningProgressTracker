import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // put your code here
        double input = scanner.nextDouble();
        System.out.println(Math.pow(input, 2) * Math.PI);
    }
}