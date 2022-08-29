import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.stream.Stream;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        LocalDateTime border1 = LocalDateTime.parse(scanner.nextLine());
        LocalDateTime border2 = LocalDateTime.parse(scanner.nextLine());
        int n = Integer.parseInt(scanner.nextLine());
        long result = Stream.generate(scanner::nextLine).limit(n)
                .map(LocalDateTime::parse)
                .filter(dateTime ->
                        border1.compareTo(dateTime) <= 0 && border2.compareTo(dateTime) > 0
                                || border2.compareTo(dateTime) <= 0 && border1.compareTo(dateTime) > 0
                )
                .count();
        System.out.println(result);
    }
}
