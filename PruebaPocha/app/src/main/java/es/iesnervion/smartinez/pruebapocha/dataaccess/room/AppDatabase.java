package es.iesnervion.smartinez.pruebapocha.dataaccess.room;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import es.iesnervion.smartinez.pruebapocha.dataaccess.ShoppingCartDAO;
import es.iesnervion.smartinez.pruebapocha.dataaccess.entities.dbo.ProductDBO;

@Database(entities = ProductDBO.class, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract ShoppingCartDAO shoppingCartDAO();

    private  AppDatabase APPDATABASE = null;

    public AppDatabase getInstance(Context context){
        if (APPDATABASE == null){
            synchronized (AppDatabase.class){
                APPDATABASE = Room.databaseBuilder(context.getApplicationContext(),AppDatabase.class, "ShoppingCart.db").build();
            }
        }
        return APPDATABASE;
    }
}
