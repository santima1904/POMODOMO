package es.iesnervion.smartinez.ejerciciovm1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    MiViewModel miViewModel;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        miViewModel = new ViewModelProvider(this).get(MiViewModel.class);
        listView = findViewById(R.id.list_nba);

    }
}