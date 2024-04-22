public class Counter {
    public static int counter = 0;
    public static final int COUNTS = 10000;
    public static final Object lock = new Object();
}


class AddThread extends Thread {
    public void run() {
        for (int i = 0; i < Counter.COUNTS; i++) {
            synchronized (Counter.lock) {
                Counter.counter++;
            }
        }
    }
}

class DecThread extends Thread {
    public void run() {
        for (int i = 0; i < Counter.COUNTS; i++) {
            synchronized (Counter.lock) {
                Counter.counter--;
            }
        }
    }
}