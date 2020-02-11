package threads;

public class Main {
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
            System.out.println(Thread.currentThread().getName());
            System.out.println(System.currentTimeMillis());
            notify();
            try {
                Thread.sleep(2000);
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

