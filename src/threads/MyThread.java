package threads;

public class MyThread extends Thread {
    Main resource;

    public MyThread(String name, Main resource) {
        this.setName(name);
        this.resource=resource;
    }

    @Override
    public void run() {
        for(int i=0; i<10; i++){
            resource.print();
        }
    }
}
