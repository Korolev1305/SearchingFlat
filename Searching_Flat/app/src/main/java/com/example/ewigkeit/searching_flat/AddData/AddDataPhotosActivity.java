package com.example.ewigkeit.searching_flat.AddData;

import android.app.AlertDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import com.example.ewigkeit.searching_flat.App;
import com.example.ewigkeit.searching_flat.DatabaseHelper;
import com.example.ewigkeit.searching_flat.R;
import com.example.ewigkeit.searching_flat.Tables.Photos;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by ewigkeit on 01/12/2018.
 */

public class AddDataPhotosActivity extends AppCompatActivity{
    @BindView(R.id.url_photos)
    EditText url;
    @BindView(R.id.name_photos)
    EditText name;
    @BindView(R.id.estateid_photos)
    EditText estateId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_photos);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.save_photos)
    public void onSaveClick() {
        DatabaseHelper databaseHelper = App.getDatabaseInstance();
        Photos model = new Photos(name.getText().toString(),url.getText().toString(),Integer.parseInt(estateId.getText().toString()));
        if(databaseHelper.getPhotosDao().getPhotosEquals(name.getText().toString(),url.getText().toString(),Integer.parseInt(estateId.getText().toString()))==null) {

            databaseHelper.getPhotosDao().insert(model);

            finish();
        }
        else {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                    this);

            // set title
            alertDialogBuilder.setTitle("Ошибка ввода");

            // set dialog message
            alertDialogBuilder
                    .setMessage("Такое фото уже существует")
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
