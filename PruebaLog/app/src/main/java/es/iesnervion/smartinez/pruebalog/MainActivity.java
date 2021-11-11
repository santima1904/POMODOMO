package es.iesnervion.smartinez.pruebalog;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    int contador = 0;
    //public final String tag = "MainActivity";
    MiViewModel miViewModel;
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        miViewModel = new ViewModelProvider(this).get(MiViewModel.class);
        Button btn = findViewById(R.id.btn1);
        text = findViewById(R.id.text);
        btn.setOnClickListener(this);

        //Log.i(tag, "Creado");
    }

    //Práctica de Log
//    @Override
//    protected void onPause(){
//        super.onPause();
//
//        Log.i(tag, "Pausado");
//    }
//
//    @Override
//    protected void onStop(){
//        super.onStop();
//
//        Log.i(tag, "Parado");
//    }
//
//    @Override
//    protected void onSaveInstanceState(Bundle savedInstanceState){
//        savedInstanceState.putInt("contador", contador);
//        super.onSaveInstanceState(savedInstanceState);
//
//        Log.i(tag, "Guardado");
//    }
//
//    @Override
//    protected void onRestoreInstanceState(Bundle savedInstanceState){
//        contador = savedInstanceState.getInt("contador");
//        super.onRestoreInstanceState(savedInstanceState);
//
//        Log.i(tag, "Contador restaurado");
//    }
//
//    @Override
//    protected void onRestart(){
//        super.onRestart();
//
//        Log.i(tag, "Restaurado");
//    }
//
//    @Override
//    protected void onDestroy(){
//        super.onDestroy();
//
//        Log.i(tag,"Destruido");
//    }
//
//
//    @Override
//    protected void onResume(){
//        super.onResume();
//
//        Log.i(tag,"Resumido");
//    }

    @Override
    public void onClick(View v) {
        contador++;
        miViewModel.setContador(contador);
        text.setText(""+contador);
    }
}