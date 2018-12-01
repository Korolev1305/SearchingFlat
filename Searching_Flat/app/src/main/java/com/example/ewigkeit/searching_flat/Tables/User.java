package com.example.ewigkeit.searching_flat.Tables;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

/**
 * Created by ewigkeit on 01/12/2018.
 */

@Entity
public class User {

    @NonNull
    @PrimaryKey(autoGenerate = true)
    private int id;

    private String login;

    private String password;

    private String name;

    private String secondName;

    private String patronymic;

    private String role;

    private String phoneNumber;

    public User(String login, String password, String name, String secondName, String patronymic, String role, String phoneNumber) {
        this.login = login;
        this.password = password;
        this.name = name;
        this.secondName = secondName;
        this.patronymic = patronymic;
        this.role = role;
        this.phoneNumber = phoneNumber;
    }

    @NonNull
    public int getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public String getRole() {
        return role;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setId(@NonNull int id) {
        this.id = id;
    }
}
