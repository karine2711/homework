package threads;

public class Main {
    int counter;

    public static void main(String[] args) {
        Main obj = new Main();
        MyThread karine = new MyThread("Karine", obj);
        MyThread marine = new MyThread("Marine", obj);
        MyThread ani = new MyThread("Ani", obj);
        karine.start();
        marine.start();
        ani.start();
    }

    public synchronized void print() {
        if ((Thread.currentThread().getName() == "Karine" && counter % 3 == 0) ||
                (Thread.currentThread().getName() == "Marine" && counter % 3 == 1) ||
                (Thread.currentThread().getName() == "Ani" && counter % 3 == 2)) {
            System.out.println(Thread.currentThread().getName());
            System.out.println(System.currentTimeMillis());
            notify();
            counter++;
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            notify();
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

