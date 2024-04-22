import java.util.Arrays;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class RWCounter {
    private final ReadWriteLock rwLock = new ReentrantReadWriteLock();
    private final Lock readLock = rwLock.readLock();
    private final Lock writeLock = rwLock.writeLock();
    private int[] counts = new int[10];

    public void inc(int index) {
        writeLock.lock();
        try {
            counts[index]++;
        } finally {
            writeLock.unlock();
        }
    }

    public int[] get() {
        readLock.lock();
        try {
            return Arrays.copyOf(counts, counts.length);
        } finally {
            readLock.unlock();
        }
    }
}
