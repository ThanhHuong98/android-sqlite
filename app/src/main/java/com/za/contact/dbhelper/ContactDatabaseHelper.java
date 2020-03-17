package com.za.contact.dbhelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.za.contact.Constant;
import com.za.contact.model.Contact;


public class ContactDatabaseHelper extends SQLiteOpenHelper {

    public ContactDatabaseHelper(Context context){
        super(context, Constant.DB_NAME, null, Constant.DB_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create table and insert data
//        String createTableSQL = "CREATE TABLE CONTACT (_id INTEGER PRIMARY KEY AUTOINCREMENT, "
//                + "NAME TEXT, "
//                + "PHONE TEXT, "
//                + "NOTE TEXT";

        db.execSQL("CREATE TABLE CONTACT (_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "NAME TEXT, "
                + "PHONE TEXT, "
                + "NOTE TEXT);");

        // insert data into table
        Contact c1 = new Contact("Thanh Huong", "0969283845", "Huong IT");
        insertData(db,c1);
        Contact c2 = new Contact("Phu Duy", "0825074787", "Duy ban than");
        insertData(db, c2);

    }

    private static void insertData(SQLiteDatabase db, Contact contact){
        ContentValues contactValues = new ContentValues();

        contactValues.put("NAME", contact.getName());
        contactValues.put("PHONE", contact.getPhone());
        contactValues.put("NOTE", contact.getNote());

        db.insert("CONTACT", null, contactValues);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
