public interface Loader extends Runnable{
    int take();
    void put(int cargo);
}
