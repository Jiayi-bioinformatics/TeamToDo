package inputTask;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.teamtodo.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class inputTaskDetails extends AppCompatActivity {
    private FloatingActionButton fab2;

    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.addtask);
        fab2.findViewById(R.id.Fab2);
        fab2.setOnClickListener(new View.OnClickListener() {

                                    public void onClick(View v) {

                                        Intent intent = new Intent();
                                        intent.setClass(inputTaskDetails.this, taskList.class);
                                        startActivity(intent);
                                        inputTaskDetails.this.finish();
                                    }
                                }

        );


    }

}
