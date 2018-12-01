package com.example.ewigkeit.searching_flat.AddData;

import android.app.AlertDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import com.example.ewigkeit.searching_flat.App;
import com.example.ewigkeit.searching_flat.DatabaseHelper;
import com.example.ewigkeit.searching_flat.R;
import com.example.ewigkeit.searching_flat.Tables.Address;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by ewigkeit on 01/12/2018.
 */

public class AddDataAddressActivity extends AppCompatActivity {
    @BindView(R.id.district_id_address)
    EditText districtId;
    @BindView(R.id.house)
    EditText house;
    @BindView(R.id.street)
    EditText street;
    @BindView(R.id.floor)
    EditText floor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_address);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.save_address)
    public void onSaveClick() {
        DatabaseHelper databaseHelper = App.getDatabaseInstance();
        Address model = new Address(Integer.parseInt(districtId.getText().toString()),street.getText().toString(),house.getText().toString(),Integer.parseInt(floor.getText().toString()));
        if(databaseHelper.getAddressDao().getAddressEquals(Integer.parseInt(districtId.getText().toString()),street.getText().toString(),house.getText().toString(),Integer.parseInt(floor.getText().toString()))==null) {

            databaseHelper.getAddressDao().insert(model);

            finish();
        }
        else {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                    this);

            // set title
            alertDialogBuilder.setTitle("Ошибка ввода");

            // set dialog message
            alertDialogBuilder
                    .setMessage("Такой адрес уже существует")
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
}
