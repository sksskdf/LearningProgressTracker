import java.time.LocalDate;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        var sc = new Scanner(System.in);
        var ld = LocalDate.parse(sc.next());
        var ld2 = ld.plusDays(sc.nextInt());
        System.out.println(ld2.getYear() > ld.getYear());
    }
}