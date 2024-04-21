import java.util.ArrayList;
import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");

        for (int i = 1; i <= 5; i++) {
            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
            System.out.println("i = " + i);
        }
        System.out.println("Hello World!");
        String s = "Hello World!";
        int[] a = {1,2,3,4,5};
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
        for (var element : arrayList){
            System.out.println(element);
        }

        var arrIter = arrayList.iterator();
        while (arrIter.hasNext()){
            System.out.println(arrIter.next());
        }

        Person p1 = new Person();
        var p2 = new Person();
        System.out.println(p1.equals(p2));
        System.out.println(p1 == p2);
    }
}
