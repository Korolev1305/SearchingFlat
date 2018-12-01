package com.example.ewigkeit.searching_flat;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import com.example.ewigkeit.searching_flat.Tables.User;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by ewigkeit on 01/12/2018.
 */

public class RegistrationActivity extends Activity {
    @BindView(R.id.login)
    EditText login;
    @BindView(R.id.password)
    EditText password;
    @BindView(R.id.rpassword)
    EditText rpassword;
    @BindView(R.id.phonenumber)
    EditText phonenumber;
    @BindView(R.id.role)
    EditText role;
    @BindView(R.id.patronymic)
    EditText patronymic;
    @BindView(R.id.secondname_registration)
    EditText surname;
    @BindView(R.id.name_registration)
    EditText name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.registration_b)
    public void onRegClick() {
        DatabaseHelper databaseHelper = App.getDatabaseInstance();
        if ((password.getText().toString().equals(rpassword.getText().toString())
        &&((role.getText().toString().equalsIgnoreCase("Owner"))||
                (role.getText().toString().equalsIgnoreCase("Client"))))) {
            User user = new User(login.getText().toString(),password.getText().toString(),name.getText().toString(),surname.getText().toString(),
                    patronymic.getText().toString(),role.getText().toString(),phonenumber.getText().toString());
            databaseHelper.getUserDao().insert(user);
            Intent intent = new Intent(RegistrationActivity.this,LoginActivity.class);
            startActivity(intent);
        }
        else {

            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                    this);

            // set title
            alertDialogBuilder.setTitle("Ошибка ввода пароля/Выбор неверной роли");

            // set dialog message
            alertDialogBuilder
                    .setMessage("Пароли не совпадают/Допустимые роли: Owner, Client")
                    .setCancelable(false)
                    .setPositiveButton("Продолжить", (dialog, id) -> {
                        // if this button is clicked, close
                        // current activity
                        dialog.cancel();
                    });

            // create alert dialog
            AlertDialog alertDialog = alertDialogBuilder.create();

            // show it
            alertDialog.show();
        }
    }
}
