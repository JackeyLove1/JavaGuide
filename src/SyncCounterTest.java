import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SyncCounterTest {
    final SyncCounter syncCounter = new SyncCounter();
    final int numberOfThreads = 10;
    final int numberOfIncrements = 1000;

    @BeforeEach
    void setUp() {

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void run() throws InterruptedException {
        Thread[] threads = new Thread[numberOfThreads];
        for (int i = 0; i < numberOfThreads; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < numberOfIncrements; j++) {
                    syncCounter.add(1);
                }
            });
            threads[i].start();
        }

        for (Thread t : threads) {
            t.join();
        }

        for (int i = 0; i < numberOfThreads; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < numberOfIncrements; j++) {
                    syncCounter.dec(1);
                }
            });
            threads[i].start();
        }

        for (Thread t : threads) {
            t.join();
        }

        assertEquals(0, syncCounter.get());

    }
}