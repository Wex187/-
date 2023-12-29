import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordFinder {
    public static void main(String[] args) {
        String text = "My money has aged, my money. has grown older m";
        String targetLetter = "m";
        String regex = "(?<=(\\s|^))(" + targetLetter.toUpperCase() + "|" + targetLetter.toLowerCase() + ")[A-z]*";

        Pattern wordPatern = Pattern.compile(regex);
        Matcher wordMatcher = wordPatern.matcher(text);

        while (wordMatcher.find()) {
            System.out.println(wordMatcher.group());
        }
    }
}