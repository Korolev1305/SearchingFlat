package com.example.ewigkeit.searching_flat.AddData;

import android.app.AlertDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import com.example.ewigkeit.searching_flat.App;
import com.example.ewigkeit.searching_flat.DatabaseHelper;
import com.example.ewigkeit.searching_flat.R;
import com.example.ewigkeit.searching_flat.Tables.Address;
import com.example.ewigkeit.searching_flat.Tables.Estate;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by ewigkeit on 01/12/2018.
 */

public class AddDataEstateActivity extends AppCompatActivity{
    @BindView(R.id.estate_id_address)
    EditText addressId;
    @BindView(R.id.roomnumber)
    EditText roomNumber;
    @BindView(R.id.square)
    EditText square;
    @BindView(R.id.userid_estate)
    EditText userId;
    @BindView(R.id.flattypeid_estate)
    EditText flatTypeId;
    @BindView(R.id.repairtypeid_estate)
    EditText repairTypeId;
    @BindView(R.id.cost)
    EditText cost;
    @BindView(R.id.balcon)
    EditText balcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_estate);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.save_estate)
    public void onSaveClick() {
        DatabaseHelper databaseHelper = App.getDatabaseInstance();
        Estate model = new Estate(
                Integer.parseInt(addressId.getText().toString()),
                Integer.parseInt(roomNumber.getText().toString()),
                Integer.parseInt(square.getText().toString()),
                Integer.parseInt(userId.getText().toString()),
                Integer.parseInt(flatTypeId.getText().toString()),
                Integer.parseInt(repairTypeId.getText().toString()),
                cost.getText().toString(),
                Integer.parseInt(balcon.getText().toString()));

        if(Integer.parseInt(balcon.getText().toString())==1||Integer.parseInt(balcon.getText().toString())==0)
        {
            databaseHelper.getEstateDao().insert(model);

            finish();
        }
        else {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                    this);

            // set title
            alertDialogBuilder.setTitle("Ошибка ввода");

            // set dialog message
            alertDialogBuilder
                    .setMessage("Балкон есть/нет (1/0) уже существует")
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
