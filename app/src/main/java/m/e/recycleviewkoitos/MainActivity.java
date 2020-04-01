package m.e.recycleviewkoitos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecycleAdapteri adapter;
    public static ArrayList<UserEntity> jsonLista;

    Button nappi;
    RecyclerView rulla;
    private Context context;
    UserViewModel userViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.context = getApplicationContext();
        this.userViewModel = ViewModelProviders.of(this).get(UserViewModel.class);


        jsonLista = new ArrayList<>();
        //jsonLista.add(new UserEntity("Huikki","tidi@gmail.com","Kuopoio"));

        nappi = findViewById(R.id.haeNappi);

        nappi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                GetRawJSON getRawJSON = new GetRawJSON();
                getRawJSON.execute();
                if(jsonLista != null){
                    for (int i = 0; i < jsonLista.size(); i++) {
                        String name = jsonLista.get(i).name;
                        String email = jsonLista.get(i).email;
                        String city = jsonLista.get(i).city;
                        userViewModel.insert(name,email,city);
                    }
                    //jsonLista = null;
                }
            }
        });

        LiveData<List<UserEntity>> lista = userViewModel.listLiveData;

        userViewModel.getAllUserEntities().observe(this, new Observer<List<UserEntity>>() {
            @Override
            public void onChanged(List<UserEntity> lista) {


                ArrayList<UserEntity> adapteriLista = new ArrayList<>();
                for (int i = 0; i < lista.size(); i++) {
                    adapteriLista.add(lista.get(i));
                }

                RecyclerView rulla = findViewById(R.id.rullaView);
                rulla.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                adapter = new RecycleAdapteri(context, adapteriLista);
                rulla.setAdapter(adapter);
            }
        });




        /*RecyclerView rulla = findViewById(R.id.rullaView);
        rulla.setLayoutManager(new LinearLayoutManager(this));
        adapter = new RecycleAdapteri(this, lista);
        rulla.setAdapter(adapter);*/

    }
}
