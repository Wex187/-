public class Palindrome {

    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) {
            String s = args[i];
            String s2 = reverseString(s);
            System.out.println(args[i] + ":" + isPalindrome(s, s2));
        }
    }
    public static String reverseString(String s) {
        char[] letters = new char[s.length()];
        String reversed_string = "";
        for (int i = 0; i < s.length(); i++) {
            letters[i] = s.charAt(i);
        }
        for (int i = s.length() - 1; i > - 1; i--) {
            reversed_string = reversed_string + letters[i];
        }
        return reversed_string;
    }

    public static boolean isPalindrome(String s, String s2) {
        if (s.equals(s2)) {
            return true;
        }
        return false;
    }
}