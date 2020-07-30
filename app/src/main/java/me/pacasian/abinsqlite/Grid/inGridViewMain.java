package me.pacasian.abinsqlite.Grid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

import me.pacasian.abinsqlite.DatabaseHelper;
import me.pacasian.abinsqlite.ModelClass;
import me.pacasian.abinsqlite.R;

public class inGridViewMain extends AppCompatActivity {
DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_in_grid_view_main);
        GridView grill;
        grill=findViewById(R.id.gridview);


        databaseHelper = new DatabaseHelper(this); // Connection Class Initialization


        Cursor res = databaseHelper.getAllData();
        if (res.getCount() == 0) {
            // show message
            Toast.makeText(this, "Nothing found", Toast.LENGTH_SHORT).show();
            return;
        }
        Toast.makeText(this, ""+res.getCount(), Toast.LENGTH_SHORT).show();
        String[] stMatter=new String[res.getCount()];
        String[] stDate=new String[res.getCount()];
        StringBuffer buffer = new StringBuffer();
        int i=0;
        while (res.moveToNext()) {
            //itemArrayList.add(new ModelClass(res.getString(0),res.getString(1),res.getString(2)));
            stMatter[i]=res.getString(1);
            stDate[i]=res.getString(2);
            i++;
            /**
             *
             buffer.append("Id :" + res.getString(0) + "\n");
             buffer.append("Name :" + res.getString(1) + "\n");
             buffer.append("Company Name :" + res.getString(2) + "\n");

             */
        }


        GridModel adapter= new GridModel(inGridViewMain.this,stDate,stMatter);
        grill.setAdapter(adapter);



        grill.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),"You Clicked "+position,
                        Toast.LENGTH_SHORT).show();

            }


        });
    }
}