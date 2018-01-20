import java.util.Random;

public class ThreadParty implements Runnable {

    private int delay;
    private String title;
    private Thread thread;
    private long[] data;
    private int uno;
    private int length;

    public ThreadParty(int delay, String title, long[] data, int uno, int length) {
        this.delay = delay;
        this.title = title;
        this.data = data;
        this.uno = uno;
        this.length = length;
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        if (uno < 4) {
            synchronized (this) {
                for (int i = 0; i < length - 3; i = i + 3) {
                    Random rand = new Random();
                    data[i + uno] = rand.nextInt(100) + 1;
                    if (length % 3 == 1) {
                        data[length - 1] = rand.nextInt(100) + 1;
                    }
                    if (length % 3 == 2) {
                        data[length - 1] = rand.nextInt(100) + 1;
                        data[length - 2] = rand.nextInt(100) + 1;
                    }
                    System.out.println(title + " thread " + "added " + data[i + uno]);
                    try {
                        Thread.sleep(delay);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        if (5 == uno) {
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
