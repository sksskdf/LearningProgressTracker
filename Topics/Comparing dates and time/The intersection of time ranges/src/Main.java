import java.time.LocalTime;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LocalTime start1 = LocalTime.parse(scanner.next());
        LocalTime finish1 = LocalTime.parse(scanner.next());
        LocalTime start2 = LocalTime.parse(scanner.next());
        LocalTime finish2 = LocalTime.parse(scanner.next());
        System.out.println(!start1.isAfter(finish2) && !start2.isAfter(finish1));
    }
}
