package inputTask;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.teamtodo.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class taskList extends AppCompatActivity {

    private FloatingActionButton fab1;

    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.tasklist);
        fab1.findViewById(R.id.Fab1);
        fab1.setOnClickListener(new View.OnClickListener() {

                                    public void onClick(View v) {

                                        Intent intent = new Intent();
                                        intent.setClass(taskList.this, inputTaskDetails.class);
                                        startActivity(intent);
                                        taskList.this.finish();
                                    }
                                }

        );


    }


}

