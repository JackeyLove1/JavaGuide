import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;

public class TaskQueueTest {

    @BeforeEach
    public void setUp() {
    }

    @AfterEach
    public void tearDown() {
    }

    @Test
    public void run() throws InterruptedException {
        var q = new TaskQueue<String>();
        var threads = new ArrayList<Thread>();
        for (int i = 0; i < 10; i++) {
            var t = new Thread(() -> {
                while (true) {
                    try {
                        var s = q.getTask();
                        System.out.println("execute task: " + s);
                    } catch (InterruptedException e) {
                        return;
                    }
                }
            });
            t.start();
            threads.add(t);
        }
        var add = new Thread(() -> {
            String s = "t-" + Math.random();
            System.out.println("add task: " + s);
            q.addTask(s);
            try {
                Thread.sleep(1);
            } catch (InterruptedException _) {
            }
        });
        add.start();
        add.join();
        Thread.sleep(200);
        for (Thread t : threads) {
            t.interrupt();
        }
    }
}