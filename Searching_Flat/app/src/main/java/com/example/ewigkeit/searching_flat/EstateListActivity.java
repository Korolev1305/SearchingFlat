package com.example.ewigkeit.searching_flat;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.example.ewigkeit.searching_flat.Adapters.PageAdapter;
import com.example.ewigkeit.searching_flat.AddData.AddDataAddressActivity;
import com.example.ewigkeit.searching_flat.AddData.AddDataDistrictActivity;
import com.example.ewigkeit.searching_flat.AddData.AddDataEstateActivity;
import com.example.ewigkeit.searching_flat.AddData.AddDataFlatTypeActivity;
import com.example.ewigkeit.searching_flat.AddData.AddDataPhotosActivity;
import com.example.ewigkeit.searching_flat.AddData.AddDataRepairTypeActivity;
import com.example.ewigkeit.searching_flat.Tables.Estate;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ewigkeit on 01/12/2018.
 */

public class EstateListActivity extends AppCompatActivity implements PageAdapter.OnDeleteListener{

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estatelist);
        ButterKnife.bind(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false));
        databaseHelper = App.getDatabaseInstance();
        databaseHelper=App.getDatabaseInstance();
    }

    @SuppressLint("ResourceType")
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.layout.menu_add_button, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_add_address: {
                startActivity(new Intent(this, AddDataAddressActivity.class));
                break;
            }
            case R.id.action_add_district: {
                startActivity(new Intent(this, AddDataDistrictActivity.class));
                break;
            }
            case R.id.action_add_estate: {
                startActivity(new Intent(this, AddDataEstateActivity.class));
                break;
            }
            case R.id.action_add_flattype: {
                startActivity(new Intent(this, AddDataFlatTypeActivity.class));
                break;
            }
            case R.id.action_add_photos: {
                startActivity(new Intent(this, AddDataPhotosActivity.class));
                break;
            }
            case R.id.action_add_repairtype: {
                startActivity(new Intent(this, AddDataRepairTypeActivity.class));
                break;
            }
        }
        return false;
    }

    @Override
    protected void onResume() {
        super.onResume();
        PageAdapter recyclerAdapter = new PageAdapter(this, databaseHelper.getEstateDao().getAllData());
        recyclerAdapter.setOnDeleteListener(this);
        recyclerView.setAdapter(recyclerAdapter);
    }

    @Override
    public void onDelete(Estate dataModel) {
        databaseHelper.getEstateDao().delete(dataModel);
    }
}
