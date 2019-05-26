package elixer.com.threadpool;

import android.app.Activity;
import android.content.Context;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Random;

public class Task implements Runnable {
    public static final String TAG = "RUNANABLE";

    private String taskName;
    private Context mContext;

    private ProgressBar progressBar;
    private TextView statusTextView;


    public Task(Context mContext, String taskName, ProgressBar progressBar, TextView statusTextView) {
        this.taskName = taskName;
        this.mContext = mContext;
        this.progressBar = progressBar;
        this.statusTextView = statusTextView;
    }

    /*
    Task to be done in background.
     */
    @Override
    public void run() {

        int step = generateRandomStep();

        // Log.d("Task", String.valueOf(step));
        try {

            for (int i = 0; i < 100; ) {
                i = i + step;

                //Update Ui
                final int finalI = i;
                ((Activity) mContext).runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        statusTextView.setText(String.valueOf(finalI) + "%");
                        progressBar.setProgress(finalI);
                    }
                });
                Thread.sleep(500);
            }


        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    //Generate a Random number that is a factor of 100
    private int generateRandomStep() {

        int multiple[] = new int[]{2,5, 10, 20, 25, 50};
        final int random = new Random().nextInt(5);
        return multiple[random];
    }


}
