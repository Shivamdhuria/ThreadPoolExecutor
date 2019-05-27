package elixer.com.threadpool;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> mTaskNames = new ArrayList<>();
    private ArrayList<Integer> mTaskProgress = new ArrayList<>();


    private static final String TAG = "DownloadFilesActivity";
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initTaskNames();
        initRecyclerView();

    }

    private void initTaskNames() {
        for (int i = 1; i < 5; i++) {
            mTaskNames.add("Task Number " + i);

        }
    }

    private void initRecyclerView() {
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        mAdapter = new RecyclerViewAdapter(this, mThreadNames);
        recyclerView.setAdapter(mAdapter);

    }

}


