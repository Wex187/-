import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Task3 {
    public static void main(String[] args) throws InterruptedException {
        int[] cargos = new int[]{8, 7, 9, 16, 19, 9, 3, 15, 9, 1, 20, 9, 12, 16, 11, 1, 1, 19, 17, 11, 13, 10, 2, 15, 20, 12, 1, 4, 4, 2, 4, 14, 19, 10, 2, 20, 10, 1, 20, 3, 2, 8, 17, 7, 7, 18, 8, 9, 17, 5, 12};
        Stack<Integer> firstStock = new Stack<>();
        for (int cargo :
                cargos) {
            firstStock.push(cargo);
        }
        Stack<Integer> secondStock = new Stack<>();
        ExecutorService service = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 3; i++) {
            service.submit(new LoaderRealization(firstStock, secondStock));
        }
        service.shutdown();
        if (service.awaitTermination(1000, TimeUnit.SECONDS)) {
            System.out.println("Program has been completed");
            System.out.println("Second stock: " + secondStock);
            Arrays.sort(cargos);
            System.out.println("Sorted first stock: " + Arrays.toString(cargos));
            System.out.println("Sorted second stock: " + secondStock.stream().sorted().toList());
        }else {
            System.out.println("Program hasn't been completed");
        }
    }
}
