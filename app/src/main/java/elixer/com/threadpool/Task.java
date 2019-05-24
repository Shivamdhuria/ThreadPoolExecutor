package elixer.com.threadpool;

import android.util.Log;

public class Task implements Runnable {
    public static final String TAG = "RUNANABLE";

    private String TaskNo;

    public Task(String taskNo) {
        TaskNo = taskNo;
    }

    @Override
    public void run() {
        /*
    Task to be done
     */

        int step = (int) Math.floor(Math.random() * 6) * 5;
        // Log.d("Task", String.valueOf(step));
        try {

            for (int i = 0; i < 100; ) {

                i = i + step;

                Thread.sleep(1000);

            }
            Log.d(TAG, "end..." + TaskNo);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
