public class SyncCounter {
    private int counter = 0;

    public void add(int n) {
        synchronized (this) {
            counter += n;
        }
    }

    public synchronized void dec(int n) {
        counter -= n;
    }

    public synchronized int get() {
        return counter;
    }
}
