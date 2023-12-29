import java.util.regex.*;

public class NumberFinder {
    public static void main(String[] args) {
        String text = "6 Sorry1 Bout 2 That $22.2 33.4 -66 43.435.4";

        Pattern digPattern = Pattern.compile("(?<=(\\s|\\$|^))-?\\d+(\\.\\d+)?(?=\\s|$)");
        Matcher digMatcher = digPattern.matcher(text);
        while (digMatcher.find()) {
            System.out.println(digMatcher.group());
        }
    }
}
