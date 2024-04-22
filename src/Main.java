import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.text.NumberFormat;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Logger;
import java.security.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws Exception {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.print("Hello and welcome!");

        for (int i = 1; i <= 5; i++) {
            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
            System.out.println("i = " + i);
        }
        System.out.println("Hello World!");
        String s = "Hello World!";
        int[] a = {1, 2, 3, 4, 5};
        var b = new int[10];
        String[] c = new String[10];
        final int constNumber = 10;
        String[] arr = new String[]{"村雨遥", "海贼王", "进击的巨人", "鬼灭之刃", "斗罗大陆"};
        Arrays.sort(arr);
        for (final String string : arr) {
            System.out.println(string);
        }

        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        arrayList.add(1);
        arrayList.add(2);
        for (var element : arrayList) {
            System.out.println(element);
        }

        var arrIter = arrayList.iterator();
        while (arrIter.hasNext()) {
            System.out.println(arrIter.next());
        }

        Person p1 = new Person();
        var p2 = new Person();
        System.out.println(p1.equals(p2));
        System.out.println(p1 == p2);

        BigInteger();

        LoggerTest();

        CollectionTest();

        DateFormat();

        ReTest();

        EncodeDecodeTest();

        Threads1();

        Threads2();

        ThreadLockTest();

    }

    public static void BigInteger() {
        var bigInteger = new BigInteger("12345678910");
        System.out.println(bigInteger);
        System.out.println(bigInteger.toString());
        System.out.println(bigInteger.pow(2));

        var bigDecimal = new BigDecimal("123456789.0123456789");
        System.out.println(bigDecimal);

    }

    public static void LoggerTest() {
        Logger logger = Logger.getGlobal();
        logger.info("start process...");
    }

    public static void CollectionTest() {
        Map<String, Integer> map = new HashMap<>();
        map.put("a", 1);
        map.put("b", 2);
        System.out.println(map.get("a"));
        System.out.println(map.get("c"));

        for (var key : map.keySet()) {
            var value = map.get(key);
            System.out.println("key = " + key + " value = " + value);
        }

        for (var entry : map.entrySet()) {
            var key = entry.getKey();
            var value = entry.getValue();
            System.out.println("key = " + key + " value = " + value);
        }

        var treeMap = new TreeMap<>();
        treeMap.put("a", 1);
        treeMap.put("b", 2);
        for (var key : treeMap.keySet()) {
            var value = treeMap.get(key);
            System.out.println("key = " + key + " value = " + value);
        }

        Set<String> set = new HashSet<>();
        set.add("a");
        set.add("b");
        set.add("a");
        System.out.println(set.size());

        Queue<String> queue = new LinkedList<>();
        queue.offer("apple");
        queue.offer("pear");
        queue.offer("banana");
        for (int i = 0; i <= queue.size() + 1; i++) {
            System.out.println(queue.poll());
        }

        Queue<String> q2 = new PriorityQueue<>();
        q2.offer("apple");
        q2.offer("pear");
        q2.offer("banana");
        System.out.println(q2.poll());
        System.out.println(q2.poll());
        System.out.println(q2.poll());
        System.out.println(q2.poll());

        Queue<Student> q3 = new PriorityQueue<>(new StudentComparator());
        q3.offer(new Student("student apple", 1));
        q3.offer(new Student("student pear", 2));
        q3.offer(new Student("student banana", 3));
        System.out.println(q3.poll());
        System.out.println(q3.poll());
        System.out.println(q3.poll());
        System.out.println(q3.poll());

        Deque<String> d = new LinkedList<>();
        d.addFirst("apple");
        d.addFirst("pear");
        d.addLast("banana");
        for (String s : d) {
            System.out.println("deque: " + s);
        }

        List<String> list = List.of("Apple", "Orange", "Pear");
        for (Iterator<String> it = list.iterator(); it.hasNext(); ) {
            var s = it.next();
            System.out.println("list: " + s);
        }
    }

    public static void DateFormat() {
        int n = 123400;
        System.out.println(Integer.toHexString(n));
        System.out.println(Integer.toBinaryString(n));
        System.out.println(Integer.toBinaryString(n >>> 16));
        System.out.println(NumberFormat.getCurrencyInstance(Locale.US).format(n));
    }

    public static void ReTest() {

    }

    public static void EncodeDecodeTest() {
        String encoded = URLEncoder.encode("你是谁", StandardCharsets.UTF_8);
        System.out.println(encoded);
        byte[] input = new byte[]{(byte) 0xe4, (byte) 0xb8, (byte) 0xad};
        String base64 = Base64.getEncoder().encodeToString(input);
        System.out.println(base64);
        byte[] output = Base64.getDecoder().decode("5Lit");
        System.out.println(Arrays.toString(output));

//        var md = MessageDigest.getInstance("SHA-256");
//        md.update("Hello".getBytes(StandardCharsets.UTF_8));
//        md.update("World".getBytes(StandardCharsets.UTF_8));
//        byte[] result = md.digest();
//        System.out.println(Arrays.toString(result));
    }

    public static void Threads1() {
        Thread t = new MyThread();
        t.start();
        t.interrupt();

        Thread t2 = new Thread(new MyRunnable());
        t2.start();

        Thread t3 = new Thread(() -> {
            System.out.println("start new lambda thread");
        });
        t3.start();
    }

    public static void Threads2() throws InterruptedException {
        Thread t = new MyThread();
        t.start();
        Thread.sleep(1);
        t.interrupt();
        t.join();
        System.out.println("end thread");
    }

    public static void ConcurrentCollections() {
        Map<String, Integer> map = new ConcurrentHashMap<>();
        map.put("a", 1);
        var t = new Thread(() -> {
            map.put("b", 2);
        });
        t.start();
        t.interrupt();
    }

    public static void AtomicTest() {

    }

    static ThreadLocal<String> threadLocalString = new ThreadLocal<>();

    public static void ThreadLockTest() {
        String s = threadLocalString.get();
        System.out.println(s);
    }
}
