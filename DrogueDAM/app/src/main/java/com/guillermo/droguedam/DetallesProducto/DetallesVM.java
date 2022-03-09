package com.guillermo.droguedam.DetallesProducto;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import com.guillermo.droguedam.Objetos.ClsProducto;

public class DetallesVM extends AndroidViewModel {

    private ClsProducto productoSelecciondo;

    public DetallesVM(Application app){
        super(app);
    }

    //Getters and setters

    public ClsProducto getProductoSelecciondo() {
        return productoSelecciondo;
    }

    public void setProductoSelecciondo(ClsProducto productoSelecciondo) {
        this.productoSelecciondo = productoSelecciondo;
    }
}
