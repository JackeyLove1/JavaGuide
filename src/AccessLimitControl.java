import java.util.UUID;
import java.util.concurrent.Semaphore;

public class AccessLimitControl {
    final Semaphore semaphore = new Semaphore(3);

    public String access() throws Exception{
        semaphore.acquire();
        try {
            return UUID.randomUUID().toString();
        }finally {
            semaphore.release();
        }
    }
}


