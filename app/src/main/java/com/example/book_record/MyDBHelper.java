package com.example.book_record;


import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public  class MyDBHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "shubham_db";
//    whenever variable access at that time no need to create object its done using static keyword:
//    static keyword bydefault memory allocated
//    final use for no reasign any value
    private static final int DB_VERSION = 4;
    private static final String TABLE_NAME = "book_list";
    private static final String ID_COL = "id";
    private static final String book_COL = "book";
    private static final String AUTHER_COL = "auther";


    public MyDBHelper(Context context)
    {
        super(context, DB_NAME, null,DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query="CREATE TABLE "+ TABLE_NAME +" ("+ ID_COL+" INTEGER PRIMARY KEY AUTOINCREMENT,"
                +book_COL+" TEXT,"
                +AUTHER_COL+" TEXT"+")";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//        if same name table is present then drop
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME);
        onCreate(db);
    }

    public void insert(String name,String auther) {
        SQLiteDatabase db = this.getWritableDatabase();
      //content value use for store the data in the form of key value pair
        ContentValues values = new ContentValues();

        values.put(book_COL,name);
        values.put(AUTHER_COL,auther);
        db.insert(TABLE_NAME,null,values);
      //null coloum hack is use to insert data at particular coloumn=coloumn name otherwise null
        db.close();
        //        use for method not busy....its free
    }



}