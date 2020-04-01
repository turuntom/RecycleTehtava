package m.e.recycleviewkoitos;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

public class UserEntityRepository {

    private UserEntityDAO userDAO;
    private LiveData<List<UserEntity>> userEntityLiveData;

    UserEntityRepository(Application application) {
        DB t = DB.getInstance(application.getApplicationContext());
        this.userDAO = t.getUserEntityDAO();
        this.userEntityLiveData = userDAO.haeLiveDatalista();
    }

    public LiveData<List<UserEntity>> haeUserLista() {
        return userEntityLiveData;
    }

    public void insert(String name, String email, String city){
        userDAO.InsertUserEntity(new UserEntity(name, email, city));
    }

}
