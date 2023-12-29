import java.util.*;
import java.util.stream.Collectors;

public class MainP {
    private static String getMostCommon(LinkedList<Product> list) {
        Map<String, Long> map = list.stream().collect(Collectors.groupingBy(Product::getName, Collectors.counting()));
        return map.entrySet().stream().max(Map.Entry.comparingByValue()).map(Map.Entry::getKey).orElse(null);
    }


    public static void main(String[] args) {
        LinkedList<Product> goods = new LinkedList<>();
        goods.add(new Product("notebook", 187));
        goods.add(new Product("saint spring", 60));
        goods.add(new Product("notebook", 187));
        goods.add(new Product("pen", 20));
        goods.add(new Product("pen", 20));
        goods.add(new Product("pen", 20));
        goods.add(new Product("pen", 20));
        goods.add(new Product("iphone", 200));
        goods.add(new Product("green pen", 25));
        goods.add(new Product("saint spring", 60));
        goods.add(new Product("saint spring", 60));
        goods.add(new Product("saint spring", 60));
        goods.add(new Product("saint spring", 60));
        goods.add(new Product("Rezero", 208));

        System.out.println(goods);
        System.out.println(goods.stream().collect(Collectors.summarizingInt(Product::getCost)).getSum());
        System.out.println(getMostCommon(goods));
    }
}
