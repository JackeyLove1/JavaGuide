import java.util.LinkedList;
import java.util.Queue;

public class TaskQueue<T> {
    Queue<T> queue = new LinkedList<>();

    public synchronized void addTask(T s) {
        this.queue.add(s);
        this.notifyAll();
    }

    public synchronized T getTask() throws InterruptedException {
        while (queue.isEmpty()) {
            this.wait();
        }
        return this.queue.remove();
    }

}
