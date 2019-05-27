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

    private ArrayList<String> mTaskNames;
    private Context mContext;

    public RecyclerViewAdapter(Context mContext, ArrayList<String> mTaskNames) {
        this.mTaskNames = mTaskNames;
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
        viewHolder.taskNameTextView.setText(mTaskNames.get(i));
        final TextView statusTextView = viewHolder.statusTextView;
        final ProgressBar progressBar = viewHolder.progressBar;

        viewHolder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, mTaskNames.get(i), Toast.LENGTH_SHORT).show();
                runTask("Task No" + i, statusTextView, progressBar);
            }
        });

    }


    @Override
    public int getItemCount() {
        return mThreadNames.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView taskNameTextView;
        ProgressBar progressBar;
        TextView statusTextView;
        LinearLayout parentLayout;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            taskNameTextView = itemView.findViewById(R.id.task_name);
            progressBar = itemView.findViewById(R.id.progressBar);
            statusTextView = itemView.findViewById(R.id.status);
            parentLayout = itemView.findViewById(R.id.parent_layout);
        }
    }

    private void runTask(String taskName, TextView statusTextView, ProgressBar progressBar) {

        Task task = new Task(mContext, taskName, progressBar, statusTextView);
        Manager.getManagerInstance().runTask(task);
    }


}
