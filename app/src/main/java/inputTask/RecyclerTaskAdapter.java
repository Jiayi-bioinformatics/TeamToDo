package inputTask;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.icu.text.Transliterator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.teamtodo.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class RecyclerTaskAdapter extends RecyclerView.Adapter<RecyclerTaskAdapter.ViewHolder> {
    Context context;
    ArrayList<TaskModule> arrTasks;

    RecyclerTaskAdapter(Context context, ArrayList<TaskModule> arrTasks) {
        this.context = context;
        this.arrTasks = arrTasks;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.task_row, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder,int position) {

        TaskModule module = (TaskModule) arrTasks.get(position);
        holder.imgTask.setImageResource(module.img);
        holder.txtTitle.setText(module.title);
        holder.txtDetails.setText(module.detail);
        holder.llRow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialog = new Dialog(context);
                dialog.setContentView(R.layout.addtask);

                EditText edtTitle = dialog.findViewById(R.id.inputTaskTitle);
                EditText edtDetails = dialog.findViewById(R.id.inputTaskDetails);
                FloatingActionButton fab2 = dialog.findViewById(R.id.Fab2);

                edtTitle.setText((arrTasks.get(holder.getAdapterPosition())).title);
                edtDetails.setText((arrTasks.get(holder.getAdapterPosition())).detail);

                fab2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String title = "", details = "";
                        if (!edtTitle.getText().toString().equals("")) {
                            title = edtTitle.getText().toString();
                        } else {
                            Toast.makeText(context, "Please Enter Task Title~", Toast.LENGTH_SHORT).show();
                        }
                        if (!edtDetails.getText().toString().equals("")) {
                            details = edtTitle.getText().toString();
                        } else {
                            Toast.makeText(context, "Please Enter Task Details~", Toast.LENGTH_SHORT).show();
                        }
                        arrTasks.set(holder.getAdapterPosition(), new TaskModule(title, details));
                        notifyItemChanged(holder.getAdapterPosition());
                        dialog.dismiss();
                    }
                });
                dialog.show();
            }
        });
        holder.llRow.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context)
                        .setTitle("Delete Task")
                        .setMessage("Have you finished the task?")
                        .setIcon(R.drawable.baseline_delete_24)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                arrTasks.remove(holder.getAdapterPosition());
                                notifyItemRemoved(holder.getAdapterPosition());
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });
                builder.show();
                return true;


            }
        });
    }

    @Override
    public int getItemCount() {
        return arrTasks.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView txtTitle, txtDetails;
        ImageView imgTask;
        LinearLayout llRow;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtTitle = itemView.findViewById(R.id.txtTitle);
            txtDetails = itemView.findViewById(R.id.txtDetails);
            imgTask = itemView.findViewById(R.id.imgTask);
            llRow = itemView.findViewById(R.id.llrow);


        }
    }
}
