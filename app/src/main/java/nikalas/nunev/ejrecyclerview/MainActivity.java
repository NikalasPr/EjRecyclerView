package nikalas.nunev.ejrecyclerview;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;

import java.util.ArrayList;

import nikalas.nunev.ejrecyclerview.adapters.ToDoAdapter;
import nikalas.nunev.ejrecyclerview.databinding.ActivityMainBinding;
import nikalas.nunev.ejrecyclerview.modelos.ToDo;


public class MainActivity extends AppCompatActivity {


    private ActivityMainBinding binding;

    private ArrayList<ToDo> todoList;

    private ToDoAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        todoList = new ArrayList<>();
        crearTareas();

        adapter = new ToDoAdapter(todoList, R.layout.todo_view_model, MainActivity.this);
        binding.contentMain.contenedor.setAdapter(adapter);
        layoutManager = new LinearLayoutManager(MainActivity.this);
        binding.contentMain.contenedor.setLayoutManager(layoutManager);

        binding.fab.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

            }
        });
    }

    private void crearTareas(){
        for (int i = 0; i < 1000000; i++) {
            todoList.add(new ToDo("Titulo"+i,"Contenido"+i));
        }
    }
}