import java.util.UUID;

public class Task implements Runnable {
    private final String name;

    public Task(String name) {
        this.name = name + "-" + UUID.randomUUID();
    }

    @Override
    public void run() {
        System.out.println("start task " + name);
        try {
            Thread.sleep(100);
        } catch (InterruptedException _) {
        }
        System.out.println("end task " + name);
    }
}
