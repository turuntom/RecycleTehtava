package m.e.recycleviewkoitos;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface UserEntityDAO {

    @Query("Select * from UserEntity")List<UserEntity> userEntityLista();

    @Query("Select * from UserEntity")
    LiveData<List<UserEntity>> haeLiveDatalista();

    @Insert
    void InsertUserEntity(UserEntity userEntity);

}
