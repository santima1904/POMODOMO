package es.iesnervion.smartinez.pruebapocha.dataaccess.entities.dbo;

import androidx.annotation.Nullable;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

//Objeto de la base de datos
@Entity(tableName = "product")
public class ProductDBO {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @Nullable
    private String name;

    @Nullable
    private double price;

    @Nullable
    private String photo;

}
