package es.iesnervionsmartinez.pruebaexamen;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

String [] content = {"aaaaa", "asddddd", "sdadasdas"};
ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = findViewById(R.id.list_a);
        list.setAdapter(new ArrayAdapter<String>(this, R.layout.activity_main, content));

    }
    
    class IconicAdapter extends ArrayAdapter {

        public IconicAdapter(Context context, int resource, Object[] objects) {
            super(context, resource, objects);
        }
    }
}