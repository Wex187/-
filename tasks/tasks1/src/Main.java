public class Main {
    public static void main(String[] args) {
        System.out.println("___1___");
        System.out.println(convert(5));
        System.out.println(convert(3));
        System.out.println(convert(8));
        System.out.println("___2___");
        System.out.println(fitCalc(15, 1));
        System.out.println(fitCalc(24, 2));
        System.out.println(fitCalc(41, 3));
        System.out.println("___3___");
        System.out.println(containers(3, 4, 2));
        System.out.println(containers(5, 0, 2));
        System.out.println(containers(4, 1, 4));
        System.out.println("___4___");
        System.out.println(triangleType(5, 5, 5));
        System.out.println(triangleType(5, 4, 5));
        System.out.println(triangleType(3, 4, 5));
        System.out.println(triangleType(5, 1, 1));
        System.out.println("___5___");
        System.out.println(ternaryEvaluation(8, 4));
        System.out.println(ternaryEvaluation(1, 11));
        System.out.println(ternaryEvaluation(5, 9));
        System.out.println("___6___");
        System.out.println(howManyItems(22, 1.4, 2));
        System.out.println(howManyItems(45, 1.8, 1.9));
        System.out.println(howManyItems(100, 2, 2));
        System.out.println("___7___");
        System.out.println(factorial(3));
        System.out.println(factorial(5));
        System.out.println(factorial(7));
        System.out.println("___8___");
        System.out.println(gcd(48, 18));
        System.out.println(gcd(52, 8));
        System.out.println(gcd(259, 28));
        System.out.println("___9___");
        System.out.println(ticketSaler(70, 1500));
        System.out.println(ticketSaler(24, 950));
        System.out.println(ticketSaler(53, 1250));
        System.out.println("___10___");
        System.out.println(tables(5, 2));
        System.out.println(tables(31, 20));
        System.out.println(tables(123, 58));
    }

    public static double convert(int x) {
        return x * 3.785d;
    }

    public static int fitCalc(int t, int i) {
        if (i >= 1 && i <= 3) {
            return t * i;
        } else {
            System.out.print("Значение интенсивности (i) должно быть в диапазоне от 1 до ");
            return 3;
        }
    }

    public static int containers(int a, int b, int c) {
        return a * 20 + b * 50 + c * 100;
    }

    public static String triangleType(int a, int b, int c) {
        if (a + b <= c | a + c <= b | b + c <= a){
            return "not a triangle";
        } else if (a==b & a == c) {
            return "isosceles";
        } else if (a==b | a==c | b==c) {
            return "equilateral";
        } else {
            return "different-sided";
        }
    }
    public static int ternaryEvaluation(int a, int b) {
        return (a > b) ? a : b;
    }
    public static int howManyItems(int x, double y, double z) {
        return (int) (x / (2 * y * z));
    }
    public static int factorial(int x) {
        int c = 1;
        for (int i = 1; i <= x; i++) {
            c *= i;
        }
        return c;
    }
    public static int gcd(int x, int y) {
        while ( x != 0 && y != 0) {
            if (x > y){
                x = x % y;
            } else {
                y = y % x;
            }
        }
        return x + y;
    }
    public static int ticketSaler(int x, int y) {
        return (int) ((y - y * 0.28) * x);
    }
    public static int tables(float x, float y) {
        if (x > y * 2) {
            return (int) Math.ceil((x - (y * 2)) / 2);
        }else {
            return 0;
        }
    }
}
