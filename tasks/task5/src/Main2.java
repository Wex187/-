import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.Set;

public class Main2 {
    public static void main(String[] args)
    {
        System.out.println("sameLetterPattern-----------------");
        System.out.println(sameLetterPattern("ABAB", "CDCD"));
        System.out.println(sameLetterPattern("ABCBA", "BCDCB"));
        System.out.println(sameLetterPattern("FFGG", "CDCD"));
        System.out.println(sameLetterPattern("FFFF", "ABCD"));
        System.out.println();

        System.out.println(spiderVsFly("H3", "E2")); // ➞ "H3-H2-H1-A0-E1-E2"
        System.out.println(spiderVsFly("A4", "B2")); // ➞ "A4-A3-A2-B2"
        System.out.println(spiderVsFly("A4", "C2")); // ➞ "A4-A3-A2-B2-C2"
        System.out.println();

        System.out.println("digitsCount-----------------------");
        System.out.println(digitsCount(4666));
        System.out.println(digitsCount(544));
        System.out.println(digitsCount(121317));
        System.out.println(digitsCount(0));
        System.out.println(digitsCount(12345));
        System.out.println(digitsCount(1289396387328L));
        System.out.println();

        System.out.println("totalPoints-------------------------");
        System.out.println(totalPoints(new String[] {"cat", "create", "sat"}, "caster"));
        System.out.println(totalPoints(new String[] {"trance", "recant"}, "recant"));
        System.out.println(totalPoints(new String[] {"dote", "dotes", "toes", "set", "dot", "dots", "sted"}, "tossed"));
        System.out.println();

        System.out.println("sumsUp----------------------------");
        System.out.println(sumsUp(new int[] {1, 2, 3, 4, 5}));
        System.out.println(sumsUp(new int[] {1, 2, 3, 7, 9}));
        System.out.println(sumsUp(new int[] {10, 9, 7, 2, 8}));
        System.out.println(sumsUp(new int[] {1, 6, 5, 4, 8, 2, 3, 7}));
        System.out.println();

        System.out.println("setSetup-------------------");
        System.out.println(setSetup(5, 3));
        System.out.println(setSetup(7, 3));
        System.out.println();

        System.out.println("takeDownAverage-----------------");
        System.out.println(takeDownAverage(new String[] {"95%", "83%", "90%", "87%", "88%", "93%"}));
        System.out.println(takeDownAverage(new String[] {"10%"}));
        System.out.println(takeDownAverage(new String[] {"53%", "79%"}));
        System.out.println();

        System.out.println("caesarCipher");
        System.out.println(caesarCipher("encode", "hello world", 3));
        System.out.println(caesarCipher("decode", "EPQSWX PEWX XEWO!", 4));
        System.out.println();

        System.out.println("isNew---------------------");
        System.out.println(isNew(3));
        System.out.println(isNew(201));
        System.out.println(isNew(102));
        System.out.println(isNew(123));
        System.out.println(isNew(154));
        System.out.println(isNew(1504));
        System.out.println(isNew(30000000));
        System.out.println(isNew(1045));
        System.out.println();
    }

    public static boolean sameLetterPattern(String s, String t)
    {
        if(s.length() != t.length()) return false;

        HashMap<Character, Integer> smap = new HashMap<>();
        HashMap<Character, Integer> tmap = new HashMap<>();

        for(int i = 0; i < s.length(); i++)
        {
            if(smap.get(s.charAt(i)) != tmap.get(t.charAt(i))) return false;
            smap.put(s.charAt(i), i);
            tmap.put(t.charAt(i), i);
        }
        return true;
    }

    public static String spiderVsFly(String sp, String fl) {
        char[] letters = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'};
        int x1 = sp.codePointAt(0);
        int x2 = sp.codePointAt(1);
        int y1 = fl.codePointAt(0);
        int y2 = fl.codePointAt(1);

        if (x1 == y1 && x2 == y2) return fl;
        if (x2 == 48) x1 = y1;
        int firstWay;
        int secondWay;
        if (x1 > y1)
        {
            firstWay = letters.length - (x1-65) + (y1-65);
            secondWay = x1-y1;
        }
        else
        {
            firstWay = y1 - x1;
            secondWay = letters.length - (y1-65) + (x1-65);
        }
        int min = Math.min(firstWay, secondWay);
        int numberDiff = (x2 - y2 >= 0 ? (x2 - y2 > 0 ? -1 : 0) : 1);
        int wordDiff = ((x1 > y1 && min == secondWay) || (x1 < y1 && min == secondWay)) ? -1 : 1;
        System.out.println(firstWay + " " + secondWay);
        System.out.println(sp + " " + fl);
        String toCenter = Character.toString((char) (x1)) + Character.toString((char) (x2-1));
        String newNumber = Character.toString((char) x1) + Character.toString((char) (x2 + numberDiff));
        String newWord = Character.toString(letters[(x1-65+wordDiff > 0 ? x1-65+wordDiff : x1-65+wordDiff + 8) % 8])
                + Character.toString((char) x2);
        if (min >= 3 && min <= 4) return sp + "-" + spiderVsFly(toCenter, fl);
        else {
            if (x2 > y2) {
                return sp + "-" + spiderVsFly(newNumber, fl);
            } else {
                if (x1 != y1) {
                    return sp + "-" + spiderVsFly(newWord, fl);
                } else {
                    return sp + "-" + spiderVsFly(newNumber, fl);
                }
            }
        }
    }

    public static int digitsCount(long num)
    {
        int count = 1;
        return recurse(num, count);
    }

    public static int recurse(long num, int count)
    {
        if(num / 10 > 0) return recurse(num / 10, count + 1);
        return count;
    }

    public static int totalPoints(String[] words, String guess)
    {
        int points = 0;
        for (String word : words)
        {
            List<Character> chars = new ArrayList<Character>();
            for (char c : guess.toCharArray()) chars.add(c);

            int count = 0;
            boolean flag = true;
            for (int i = 0; i < word.length(); i++)
            {
                if (chars.contains((Character)word.charAt(i)))
                {
                    count++;
                    chars.remove((Character)(word.charAt(i)));
                }
                else
                {
                    flag = false;
                    break;
                }
            }
            if(flag)
            {
                if(count == 3) points+=1;
                if(count == 4) points+=2;
                if(count == 5) points+=3;
                if(count == 6) points+=54;
            }
        }
        return points;
    }

    public static String sumsUp(int[] arr)
    {
        HashMap<Integer, Integer> map = new HashMap<>();
        List<int[]> result = new ArrayList<int[]>();

        for(int i = 0; i < arr.length; i++)
        {
            if(map.containsKey(arr[i]))
            {
                result.add(new int[] {arr[map.get(arr[i])], arr[i]});
                map.remove(arr[map.get(arr[i])]);
            }
            else map.put(8 - arr[i], i);
        }

        for (int[] is : result) {
            Arrays.sort(is);
            System.out.print(Arrays.toString(is) + " ");
        }
        if(result.size() == 0) System.out.print("[]");
        return "";
    }

    public static int setSetup(int n, int k)
    {
        if (k == 0 || k == n) return 1;
        return factorial(n) / (factorial(n - k));
    }

    private static int factorial(int num)
    {
        if (num <= 1) return 1;
        else return num * factorial(num - 1);
    }

    public static String takeDownAverage(String[] arr)
    {
        int sum = 0;
        for (String str : arr)
        {
            sum += Integer.parseInt(str.substring(0, str.length() - 1));
        }
        String result = "";
        for(int i = 0; i <= 100; i++)
        {
            if((float)(sum + i)/(float)(arr.length + 1) == (float)(((sum)/arr.length) - 5)) result =  i + "%";
        }
        return result;
    }

    public static String caesarCipher(String mode, String message, int shift)
    {
        StringBuilder result = new StringBuilder();
        if (mode == "encode")
        {
            for (char c : message.toCharArray())
            {
                if (Character.isLetter(c))
                {
                    char base = Character.isUpperCase(c) ? 'A' : 'a';
                    char s = ((char) ((c - base + shift) % 26 + base));
                    result.append(String.valueOf(s).toUpperCase());
                }
                else result.append(c);
            }
        }
        else
        {
            for (char c : message.toCharArray())
            {
                if (Character.isLetter(c))
                {
                    char base = Character.isUpperCase(c) ? 'A' : 'a';
                    char s = ((char) ((c - base - shift) % 26 + base));
                    result.append(String.valueOf(s).toUpperCase());
                }
                else result.append(c);
            }
        }
        return result.toString();
    }

    public static boolean isNew(int num)
    {
        String str = String.valueOf(num);
        for(int i = 1; i < str.length(); i++)
        {
            if(!(str.charAt(i) == '0' && i==1) && str.charAt(i - 1) > str.charAt(i)) return false;
        }
        return true;
    }
}
