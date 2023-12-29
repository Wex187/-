import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ArrayProcessor {

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int numThreads = 10;

        ExecutorService executorService = Executors.newFixedThreadPool(numThreads);

        int chunkSize = array.length / numThreads;
        for (int i = 0; i < numThreads; i++) {
            int startIndex = i * chunkSize;
            int endIndex = (i == numThreads - 1) ? array.length : (i + 1) * chunkSize;

            int[] subArray = new int[endIndex - startIndex];
            System.arraycopy(array, startIndex, subArray, 0, subArray.length);
            //System.out.println(subArray);

            executorService.execute(new ArrayProcessorTask(subArray));
        }

        executorService.shutdown();
        try {
            executorService.awaitTermination(1000, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int totalSum = ArrayProcessorTask.getTotalSum();
        System.out.println("Total Sum: " + totalSum);
    }
}

class ArrayProcessorTask implements Runnable {

    private int[] array;
    private static int totalSum = 0;
    private static final Object lock = new Object();

    public ArrayProcessorTask(int[] array) {
        this.array = array;
    }

    @Override
    public void run() {
        int sum = 0;
        for (int num : array) {
            sum += num;
            System.out.println(num);
        }
        synchronized (lock) {
            totalSum += sum;
        }
    }

    public static int getTotalSum() {
        synchronized (lock) {
            return totalSum;
        }
    }
}