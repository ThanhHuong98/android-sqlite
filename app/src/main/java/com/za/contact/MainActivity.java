package com.za.contact;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.za.contact.adapter.MyAdapter;
import com.za.contact.dbhelper.ContactDatabaseHelper;
import com.za.contact.model.Contact;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    private SQLiteDatabase db;
    private Cursor cursor;

    private RecyclerView list;
    private MyAdapter adapter;

    ArrayList<Contact> data = new ArrayList<Contact>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = findViewById(R.id.recyclerView);
        list.setLayoutManager(new LinearLayoutManager(this));


        try{
            SQLiteOpenHelper contactDatabaseHelper = new ContactDatabaseHelper(this);
            db = contactDatabaseHelper.getReadableDatabase();

            cursor = db.query("CONTACT",
                    new String[]{"_id", "NAME"},
                    null, null, null, null, null);

            cursor.moveToFirst();

            while (!cursor.isAfterLast()){
                String name = cursor.getString(1);
                Log.e(TAG, "Data " + name);
                Contact c = new Contact(cursor.getString(0), cursor.getString(1));
                data.add(c);
                cursor.moveToNext();

            }

            adapter = new MyAdapter(MainActivity.this, data);
            list.setAdapter(adapter);


        }catch (SQLException e){
            Toast toast = Toast.makeText(this, "Database unavailable", Toast.LENGTH_SHORT);
            toast.show();
            Log.e(TAG, "Fail: " + "Database unavailable");

        }

    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        cursor.close();
        db.close();
    }






}
