package elixer.com.threadpool;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private ArrayList<String> mThreadNames;
    private Context mContext;

    public RecyclerViewAdapter(Context mContext, ArrayList<String> mThreadNames) {
        this.mThreadNames = mThreadNames;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_layout, viewGroup, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        viewHolder.threadName.setText(mThreadNames.get(i));
        viewHolder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, mThreadNames.get(i), Toast.LENGTH_SHORT).show();
                runTask(i);
            }
        });

    }


    @Override
    public int getItemCount() {
        return mThreadNames.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView threadName;
        ProgressBar progressBar;
        LinearLayout parentLayout;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            threadName = itemView.findViewById(R.id.thread_name);
            progressBar = itemView.findViewById(R.id.progressBar);
            parentLayout = itemView.findViewById(R.id.parent_layout);
        }
    }

    private void runTask(int i) {
        Task task = new Task("Task" + String.valueOf(i));
        Manager.getManagerInstance().runTask(task);
    }



}