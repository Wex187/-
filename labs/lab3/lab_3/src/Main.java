public class Main {
    public static void main(String[] args){
        HashTable<String, Product> products = new HashTable<>();
        products.put("Aa", new Product("milk", "pasteurized", 99.9f, 12));
        products.put("BB", new Product("coffee", "Black", 249.99f, 78));
        products.put("23363", new Product("Water", "still", 52.23f, 117));
        System.out.print("Пустой массив: ");
        System.out.println(products.isEmpty());
        System.out.print("Сколько товаров: ");
        System.out.println(products.size());
        products.remove("23363");
        System.out.print("Количество товаров после удаления: ");
        System.out.println(products.size());
        System.out.println(products.get("Aa"));
        System.out.println(products.get("BB"));
        System.out.println(products.get("23363"));
    }
}
