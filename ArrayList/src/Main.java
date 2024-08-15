import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        List<Integer> list = new ArrayList<>(2000);

      /*   race condition occur. not thread safe

       Runnable task = () -> {

            for(int i = 0; i < 1000; i++){
                list.add(i);
            }
        };

         thread safe with synchronization */

        Runnable task = () -> {

            synchronized (list) {
                for (int i = 0; i < 1000; i++) {
                    list.add(i);
                }
            }
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(list.size());

    }
}