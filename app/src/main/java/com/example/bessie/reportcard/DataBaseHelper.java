package com.example.bessie.reportcard;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Bessie on 21/10/2016.
 */
public class DataBaseHelper extends SQLiteOpenHelper {

     public static final String DATABASE_NAME = "Student.db";
    public static final String TABLE_NAME = "student_table";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "NAME";
    public static final String COL_3 = "SURNAME";
    public static final String COL_4 = "MARKS";
    public static final String TABLE_NAME2 = "register_table";
    public static final String COL2_1 = "ID";
    public static final String COL2_2 = "name";
    public static final String COL2_3 = "username";
    public static final String COL2_4 = "password";
    public static final String COL2_5 = "numbers";



    public DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT , SURNAME TEXT, MARKS INTEGER)" );
        db.execSQL("create table " + TABLE_NAME2 + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT , USERNAME TEXT, MARKS INTEGER, PASSWORD INTEGER, NUMBERS INTEGER)" );


    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME );
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME2 );
        onCreate(db);

    }

    public boolean insertData(String name, String surname, String marks){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2,name);
        contentValues.put(COL_3,surname);
        contentValues.put(COL_4,marks);
        long result = db.insert(TABLE_NAME,null,contentValues);

        if (result==-1)
            return false;
        else
            return true;


    }

    public boolean insertData2 (String name, String username, int numbers, int password){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL2_2,name);
        contentValues.put(COL2_3,username);
        contentValues.put(COL2_4,numbers);
        contentValues.put(COL2_5,password);
        long results = db.insert(TABLE_NAME2,null,contentValues);

        if (results == -1)
            return false;
        else
            return true;




    }

    public Cursor getAllData(){

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_NAME,null );
        return res;


    }

    public Cursor getAllData2(){

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = db.rawQuery("select * from "+TABLE_NAME2,null );
        return c;


    }



    public boolean updateData(String id, String name, String surname, String marks){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1,id);
        contentValues.put(COL_2,name);
        contentValues.put(COL_3,surname);
        contentValues.put(COL_4,marks);
        db.update(TABLE_NAME, contentValues, "ID = ?",new String[] { id });
        return true;


    }

    public Integer deleteData (String id){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME,"ID = ?",new String[] { id } );
    }

}
