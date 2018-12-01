package com.example.ewigkeit.searching_flat;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by ewigkeit on 01/12/2018.
 */

public class LoginActivity extends Activity {
    @BindView(R.id.login_login)
    EditText login;
    @BindView(R.id.login_password)
    EditText password;

    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        databaseHelper = App.getDatabaseInstance();
    }

    @OnClick(R.id.login_b)
    public void onEnterClick() {
        DatabaseHelper databaseHelper = App.getDatabaseInstance();

        if (databaseHelper.getUserDao().getUser(login.getText().toString(),password.getText().toString())!=null)
        {
            Intent intent = new Intent(LoginActivity.this,EstateListActivity.class);
            startActivity(intent);
        }
        else {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                    this);

            // set title
            alertDialogBuilder.setTitle("Ошибка ввода");

            // set dialog message
            alertDialogBuilder
                    .setMessage("Неправильный логин/пароль")
                    .setCancelable(false)
                    .setNegativeButton("Продолжить", (dialog, id) -> {
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

    @OnClick(R.id.registration_b_l)
    public void onRegistrationClick() {
        Intent intent = new Intent(LoginActivity.this,RegistrationActivity.class);
        startActivity(intent);
    }
}

