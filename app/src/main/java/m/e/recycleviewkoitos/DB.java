package m.e.recycleviewkoitos;
import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {UserEntity.class},version = 1, exportSchema = false)
public abstract class DB extends RoomDatabase {

    private static final String DB_NAME = "DB";
    private static volatile DB instance;

    static synchronized DB getInstance(Context context){
        if(instance == null){
            instance = create(context);
        }
        return instance;
    }


    private static DB create(final Context context){

        return Room.databaseBuilder(
                context,
                DB.class,
                DB_NAME).allowMainThreadQueries().build();

    }


    public abstract UserEntityDAO getUserEntityDAO();
}
