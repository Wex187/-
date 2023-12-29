import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HyperlinkReplacer {
    public static void main(String[] args) {
        String text = "Можно послушать музыку genius.com и еще что-то не настоящее gargulia.org.";

        String regex = "((\\b\\S+[^,!?.{}\\[\\]'@]\\.org)|(\\b\\S+\\.com))";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            System.out.println("Ссылка: " + matcher.group());
            System.out.println("Гиперссылка: http://" + matcher.group() + "\n");
        }
    }
}
