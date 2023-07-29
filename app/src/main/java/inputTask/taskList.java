package inputTask;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.teamtodo.R;
import com.example.teamtodo.databinding.ContactlistBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class taskList extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<TaskModule> arrTasks = new ArrayList<>();
    RecyclerTaskAdapter adapter;
    private FloatingActionButton fab1;

    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.tasklist);
        recyclerView = findViewById(R.id.recyclerTask);


        fab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialog = new Dialog(taskList.this);
                dialog.setContentView(R.layout.addtask);
                EditText edtTitle = dialog.findViewById(R.id.inputTaskTitle);
                EditText edtDetails = dialog.findViewById(R.id.inputTaskDetails);
                FloatingActionButton fab2 = findViewById(R.id.Fab2);

                fab2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String title = "", details = "";
                        if (!edtTitle.getText().toString().equals("")) {
                            title = edtTitle.getText().toString();
                        } else {
                            Toast.makeText(taskList.this, "Please Enter Task Title~", Toast.LENGTH_SHORT).show();
                        }
                        if (!edtDetails.getText().toString().equals("")) {
                            details = edtTitle.getText().toString();
                        } else {
                            Toast.makeText(taskList.this, "Please Enter Task Details~", Toast.LENGTH_SHORT).show();
                        }
                        arrTasks.add(new TaskModule(title, details));
                        adapter.notifyItemInserted(arrTasks.size() - 1);
                        recyclerView.scrollToPosition(arrTasks.size() - 1);
                        dialog.dismiss();
                    }
                });
                dialog.show();

            }
        });

        arrTasks.add(new TaskModule(R.drawable.baseline_flag_circle_24, "111111", "111111"));
        arrTasks.add(new TaskModule(R.drawable.baseline_flag_circle_24, "111111", "111111"));
        arrTasks.add(new TaskModule(R.drawable.baseline_flag_circle_24, "111111", "111111"));
        arrTasks.add(new TaskModule(R.drawable.baseline_flag_circle_24, "111111", "111111"));
        arrTasks.add(new TaskModule(R.drawable.baseline_flag_circle_24, "111111", "111111"));
        arrTasks.add(new TaskModule(R.drawable.baseline_flag_circle_24, "111111", "111111"));
        arrTasks.add(new TaskModule(R.drawable.baseline_flag_circle_24, "111111", "111111"));
        arrTasks.add(new TaskModule(R.drawable.baseline_flag_circle_24, "111111", "111111"));
        arrTasks.add(new TaskModule(R.drawable.baseline_flag_circle_24, "111111", "111111"));
        arrTasks.add(new TaskModule(R.drawable.baseline_flag_circle_24, "111111", "111111"));
        arrTasks.add(new TaskModule(R.drawable.baseline_flag_circle_24, "111111", "111111"));
        arrTasks.add(new TaskModule(R.drawable.baseline_flag_circle_24, "111111", "111111"));
        arrTasks.add(new TaskModule(R.drawable.baseline_flag_circle_24, "111111", "111111"));
        arrTasks.add(new TaskModule("写代码", "学习AndroidStudio手册"));

        adapter = new RecyclerTaskAdapter(this, arrTasks);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

}

