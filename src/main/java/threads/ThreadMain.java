package threads;

import static java.lang.Thread.sleep;

public class ThreadMain {

    public static void main(String[] args) {

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("in Thread");
                try {
                    sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("in Thread");
            }
        });

        System.out.println("MainThread");
        thread1.start();

        try {
            sleep(1000);
            System.out.println("MainThread");
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Listener listener = new Listener();



        CodeExecutedInThread clazz = new CodeExecutedInThread(listener);

        Thread threadClass = new Thread(clazz);
        threadClass.start();

        listener.setData("");




    }


}
