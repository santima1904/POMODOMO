package com.guillermo.droguedam;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.guillermo.droguedam.Login.LoginActivity;
import com.guillermo.droguedam.MiCuenta.MiCuentaFragment;
import com.guillermo.droguedam.Productos.FragmentProductos;
import com.guillermo.droguedam.Productos.ViewPagerAdapter;

public class PaginaPrincipal extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.getOverflowIcon().setColorFilter(Color.BLUE , PorterDuff.Mode.SRC_ATOP);

        //Las distintas pestañas de las que se compone la pantalla principal.
        ViewPager mViewPager = findViewById(R.id.viewpager);
        ViewPagerAdapter mViewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        mViewPagerAdapter.addFragment(FragmentProductos.newInstance(), "Compras");
        mViewPagerAdapter.addFragment(MiCuentaFragment.newInstance(), "Mi cuenta");
        mViewPager.setAdapter(mViewPagerAdapter);

        //Pagina principal
        TabLayout tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_scrolling, menu);
        return true;
    }

    /**
     * Metodo sobreescrito que maneja la pulsacion sobre algun elemento de tipo ItemMenu.
     * @param item Item sobre el que se ha pulsado.
     * @return True para indicar que se ha seleccionado algun elemento.
     * Si pulsa sobre el boton de cerrar sesion hará eso, volviendo ademas a la actividad de LoginActivity.
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.action_settings){
            //Cerramos la sesion
            CerrarSesion();
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * Cierra la sesion abierta y vuelve a la pantalla de login.
     */
    private void CerrarSesion(){
        FirebaseAuth.getInstance().signOut();
        finish();
        Intent i = new Intent(getApplicationContext(), LoginActivity.class);
        startActivity(i);
    }
}