import java.util.Stack;

public class LoaderRealization implements Loader {
    static int created = 1;
    static int sum = 0;
    static final Object monitor = new Object();
    private static boolean isFull = false;
    private static boolean isStockEmpty = false;
    private static final boolean[] isCargoEmpty = new boolean[]{true, true, true};

    Stack<Integer> cargos;
    Stack<Integer> firstStock;
    Stack<Integer> secondStock;
    int id;

    public LoaderRealization(Stack<Integer> firstStock, Stack<Integer> secondStock) {
        this.firstStock = firstStock;
        this.secondStock = secondStock;
        id = created;
        created++;
        cargos = new Stack<>();
    }

    @Override
    public synchronized int take() {
        if (firstStock.isEmpty()) {
            isStockEmpty = true;
            return -1;
        }
        int cargo = firstStock.peek();
        if (sum + cargo > 150) {
            isFull = true;
            return -1;
        }
        cargo = firstStock.pop();
        sum += cargo;
        System.out.println("Loader " + id + " took " + cargo + ". Sum is " + sum + " now");
        isCargoEmpty[id-1] = false;
        return cargo;
    }

    @Override
    public synchronized void put(int cargo) {
        secondStock.push(cargo);
        sum -= cargo;
        System.out.println("Loader " + id + " put " + cargo + ". Sum is " + sum + " now");
    }

    private boolean areCargosEmpty() {
        return isCargoEmpty[0] && isCargoEmpty[1] && isCargoEmpty[2];
    }

    @Override
    public void run() {
        while (!isStockEmpty) {
            while (!isStockEmpty && !isFull) {
                int cargo = take();
                if (cargo != -1) {
                    cargos.push(cargo);
                }
                try {
                    Thread.sleep(id * 500L);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            while (!cargos.isEmpty()) {
                put(cargos.pop());
                try {
                    Thread.sleep(id * 500L);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            isCargoEmpty[id-1] = true;
            synchronized (monitor) {
                if (areCargosEmpty()) {
                    System.out.println(id + " notified all");
                    monitor.notifyAll();
                } else {
                    System.out.println(id + " is waiting");
                    try {
                        while (!areCargosEmpty()) {
                            monitor.wait();
                        }
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
            isFull = false;
        }

    }
}