package m.e.recycleviewkoitos;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class UserEntity implements Serializable {

    @PrimaryKey(autoGenerate = true)
    public int Id;

    public String name;
    public String email;
    public String city;

    public UserEntity(String name, String email, String city){
        this.name = name;
        this.email = email;
        this.city = city;
    }
}

/*
"id": 1,
        "name": "Leanne Graham",
        "username": "Bret",
        "email": "Sincere@april.biz",
        "address": {
        "street": "Kulas Light",
        "suite": "Apt. 556",
        "city": "Gwenborough",
        "zipcode": "92998-3874",
        "geo": {
        "lat": "-37.3159",
        "lng": "81.1496"*/
