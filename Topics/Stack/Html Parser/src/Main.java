import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String content = scanner.nextLine();
        parseHtml(content);
    }

    private static void parseHtml(String content) {
        Pattern pattern = Pattern.compile("<([A-Za-z][A-Za-z0-9]*)>(.*)</\\1>");
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()) {
            String subText = matcher.group(2);
            if (!subText.matches("[a-zA-Z0-9\\s]*")) {
                parseHtml(subText);
            }
            System.out.println(subText);
        }
    }
}