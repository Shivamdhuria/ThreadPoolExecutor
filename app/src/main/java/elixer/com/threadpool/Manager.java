package elixer.com.threadpool;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Manager {


    private static final int CORE_POOL_SIZE = 10;
    private static final int MAX_POOL_SIZE = 10;
    private static final int KEEP_ALIVE_TIME = 50;

    private static Manager managerInstance = null;
    //A Queue for Runnables

    final BlockingQueue<Runnable> WorkQueue;
    private final ThreadPoolExecutor threadPoolExecutor;


    static {

        /*
        Static instance of Manager
         */
        managerInstance = new Manager();

    }

    /*
    Make sure Manager is a SingleTon Hence private;
     */

    private Manager() {


        WorkQueue = new LinkedBlockingQueue<Runnable>();

        threadPoolExecutor = new ThreadPoolExecutor(CORE_POOL_SIZE, MAX_POOL_SIZE, KEEP_ALIVE_TIME,
                TimeUnit.MILLISECONDS, WorkQueue);
    }

    public void runTask(Runnable task) {
        threadPoolExecutor.execute(task);

    }

    public static Manager getManagerInstance() {
        return managerInstance;
    }
}