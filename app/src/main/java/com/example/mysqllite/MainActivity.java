package com.example.mysqllite;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    public DB_ADMIN_CLASS admin = new DB_ADMIN_CLASS(MainActivity.this);
    public SQLiteDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        database = admin.getWritableDatabase();


    }



    public void add_values(View view)
    {
        int sno = Integer.parseInt(((EditText)findViewById(R.id.sno)).getText().toString());
        String name = ((EditText)findViewById(R.id.name)).getText().toString();
        admin.insert_names(database,sno,name);
        Toast.makeText(MainActivity.this, "Data Inserted", Toast.LENGTH_LONG).show();
    }
}
