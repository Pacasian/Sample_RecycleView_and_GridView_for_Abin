package me.pacasian.abinsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class create extends AppCompatActivity {
Button btn;
EditText ed;
DatabaseHelper databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=findViewById(R.id.button);
        ed=findViewById(R.id.editText);
        databaseHelper=new DatabaseHelper(this);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String st=ed.getText().toString();
                Date c = Calendar.getInstance().getTime();
                System.out.println("Current time => " + c);

                SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy", Locale.getDefault());
                String formattedDate = df.format(c);
                if(!st.equals("")){
                    boolean isInserted = databaseHelper.insertData(st, formattedDate);
                    if(isInserted == true) {
                        Toast.makeText(create.this, "Data Inserted"+formattedDate+" "+st, Toast.LENGTH_LONG).show();
                        //viewAll();
                    }
                    else
                        Toast.makeText(create.this,"Data not Inserted",Toast.LENGTH_LONG).show();

                }
            }
        });
    }
    public void viewAll() {

                        Cursor res = databaseHelper.getAllData();
                        if(res.getCount() == 0) {
                            // show message
                            Toast.makeText(this, "Error Nothing found", Toast.LENGTH_SHORT).show();
                            return;
                        }

                        StringBuffer buffer = new StringBuffer();
                        while (res.moveToNext()) {
                            buffer.append("Id :"+ res.getString(0)+"\n");
                            buffer.append("Name :"+ res.getString(1)+"\n");
                            buffer.append("Surname :"+ res.getString(2)+"\n");
                            buffer.append("Marks :"+ res.getString(3)+"\n\n");
                        }

                        // Show all data
        Toast.makeText(this, buffer.toString(), Toast.LENGTH_SHORT).show();

                    }


    }