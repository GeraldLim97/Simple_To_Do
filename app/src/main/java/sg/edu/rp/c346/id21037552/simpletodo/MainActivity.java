package sg.edu.rp.c346.id21037552.simpletodo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText etNewTodo;
    Button btnAdd;
    Button btnClearAll;
    ListView lvTodo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    etNewTodo = findViewById(R.id.editNewTodo);
    btnAdd = findViewById(R.id.buttonAddItem);
    btnClearAll = findViewById(R.id.buttonClearItem);
    lvTodo = findViewById(R.id.listViewTodo);

    ArrayList<String>alTodo;
    ArrayAdapter<String> aaTodo;

    alTodo = new ArrayList<>();

    aaTodo = new ArrayAdapter<>(this,
            android.R.layout.simple_list_item_1, alTodo);
    lvTodo.setAdapter(aaTodo);

    btnAdd.setOnClickListener(view -> {
        String newTodo = etNewTodo.getText().toString();
        alTodo.add(newTodo);
        aaTodo.notifyDataSetChanged();
        etNewTodo.setText(null);
    });

    btnClearAll.setOnClickListener(view -> {
        alTodo.clear();
        aaTodo.notifyDataSetChanged();
    });

    }
}