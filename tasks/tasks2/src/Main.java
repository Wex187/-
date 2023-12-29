import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        System.out.println("___1___");
        System.out.println(duplicateChars("Donald"));
        System.out.println(duplicateChars("orange"));
        System.out.println(duplicateChars("donald"));
        System.out.println("___2___");
        System.out.println(getInitials("Ryan Gosling"));
        System.out.println(getInitials("Barack Obama"));
        System.out.println("___3___");
        int[] numbers1 = {44, 32, 86, 19};
        int[] numbers2 = {22, 50, 16, 63, 31, 55};
        System.out.println(differenceEvenOdd(numbers1));
        System.out.println(differenceEvenOdd(numbers2));
        System.out.println("___4___");
        int[] numbers3 = {1, 2, 3, 4, 5};
        int[] numbers4 = {1, 2, 3, 4, 6};
        System.out.println(equalToAvg(numbers3));
        System.out.println(equalToAvg(numbers4));
        System.out.println("___5___");
        int[] numbers5 = {1, 2, 3};
        int[] numbers6 = {3, 3, -2, 408, 3, 31};
        System.out.println(indexMult(numbers5));
        System.out.println(indexMult(numbers6));
        System.out.println("___6___");
        System.out.println(reverse("Hello World"));
        System.out.println(reverse("The quick brown fox."));
        System.out.println("___7___");
        System.out.println(Tribonacci(7));
        System.out.println(Tribonacci(11));
        System.out.println("___8___");
        System.out.println(pseudoHash(5));
        System.out.println(pseudoHash(10));
        System.out.println(pseudoHash(0));
        System.out.println("___9___");
        System.out.println(botHelper("Hello, I’m under the water, please help me"));
        System.out.println(botHelper("Two pepperoni pizzas please"));
        System.out.println("___10___");
        System.out.println(isAnagram("listen", "silent"));
        System.out.println(isAnagram("eleven plus two", "twelve plus one"));
        System.out.println(isAnagram("hello", "world"));
    }
    public static boolean duplicateChars(String x) {
        int length = x.length();
        char[] letters = new char[length];
        for (int i = 0; i < x.length(); i++) {
            letters[i] = x.charAt(i);
        }
        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                if (letters[i] == letters[j]) {
                    return true;
                }
            }
        }
        return false;
    }
    public static String getInitials(String x) {
        String[] parts = x.split(" ");
        char fn = parts[0].charAt(0);
        char s = parts[1].charAt(0);
        return String.valueOf(fn) + String.valueOf(s);
    }
    public static int differenceEvenOdd(int[] x) {
        int length = x.length;
        int c = 0;
        for (int i = 0; i < length; i++) {
            if (x[i]%2 == 0) {
                c += x[i];
            } else  {
                c -= x[i];
            }
        }
        return Math.abs(c);
    }
    public static boolean equalToAvg(int[] x) {
        float length = x.length;
        float c = 0;
        for (int i = 0; i < length; i++) {
            c += x[i];
        }
        float avg = c / length;
        for (int i = 0; i < length; i++) {
            if (x[i] == avg){
                return true;
            }
        }

        return false;
    }
    public static String indexMult(int[] x) {
        int[] y = new int[x.length];
        for (int i = 0; i < x.length; i++) {
            y[i] = x[i] * i;
        }
        return Arrays.toString(y);
    }
    public static char[] reverse(String x) {
        char[] letters = new char[x.length()];
        char[] reverse1 = new char[x.length()];
        for (int i = 0; i < x.length(); i++) {
            letters[i] = x.charAt(i);
        }
        int j = 0;
        for (int i = x.length() - 1; i > (-1); i--) {
            reverse1[j] = letters[i];
            j += 1;
        }
        return reverse1;
    }
    public static int Tribonacci(int x) {
        int[] y = new int[x];
        y[2] = 1;
        for (int i = 3; i < x; i++) {
            y[i] = y[i - 3] + y[i - 2] + y[i - 1];
        }
        return y[x - 1];
    }
    public static StringBuilder pseudoHash(int x) {
        String characters = "abcdef1234567890";
        Random random = new Random();
        StringBuilder randomize = new StringBuilder();
        for (int i = 0; i < x; i++) {
            int randomIndex = random.nextInt(characters.length());
            char randomChar = characters.charAt(randomIndex);
            randomize.append(randomChar);
        }
        return randomize;
    }
    public static String botHelper(String x){
        String y = x.toLowerCase();
        y = y.replaceAll("\\p{P}","" );
        String[] parts = y.split(" ");
        for (String element : parts) {
            if (element.equals("help")) {
                return "Calling for a staff member";
            }
        }
        return "Keep waiting";
    }
    public static boolean isAnagram(String x, String y) {
        String nope_Space_x = x.replaceAll(" ", "");
        String nope_Space_y = y.replaceAll(" ", "");
        char[] letters_x = nope_Space_x.toCharArray();
        char[] letters_y = nope_Space_y.toCharArray();
        Arrays.sort(letters_x);
        Arrays.sort(letters_y);
        String x1 = new String(letters_x);
        String y1 = new String(letters_y);
        return (x1.equals(y1));
    }
}

