import java.time.LocalTime;
import java.util.Scanner;

class Main {

    static final LocalTime HOUR_1930 = LocalTime.of(19, 30);
    static final int WAY_TO_SHOP_MINS = 30;
    static final LocalTime SHOP_ARRIVAL_TIME = HOUR_1930.plusMinutes(WAY_TO_SHOP_MINS);

    public static void main(String[] args) {
        // put your code here
        Scanner sc = new Scanner(System.in);

        sc.useDelimiter("\n")
                .tokens()
                .skip(1)
                .map(str -> str.split("\\s+"))
                .filter(strings ->
                        LocalTime.parse(strings[1]).isAfter(SHOP_ARRIVAL_TIME))
                .map(strings -> strings[0])
                .forEachOrdered(System.out::println);
    }
}
