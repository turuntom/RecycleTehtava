package m.e.recycleviewkoitos;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

public class UserViewModel extends AndroidViewModel {

    private UserEntityRepository userEntityRepository;

    LiveData<List<UserEntity>> listLiveData;

    public UserViewModel(@NonNull Application application){
        super(application);
        this.userEntityRepository = new UserEntityRepository(application);
        this.listLiveData = userEntityRepository.haeUserLista();
    }

    public void insert(String name, String email, String city) {userEntityRepository.insert(name, email,city);}

    public LiveData<List<UserEntity>> getAllUserEntities(){
        listLiveData = userEntityRepository.haeUserLista();
        return listLiveData;
    }

}