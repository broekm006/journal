package com.uva.journal;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

import java.nio.charset.IllegalCharsetNameException;

public class EntryDatabase extends SQLiteOpenHelper {

    private static EntryDatabase instance;

    private EntryDatabase(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }


    public static EntryDatabase getInstance(Context context){
        if (instance == null){
            return instance = new EntryDatabase(context, "com.uva.journal", null, 1);
        }

        else{
            return instance;
        }
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = ("create table entries (_id INTEGER PRIMARY KEY, title TEXT, content TEXT, mood TEXT, timestamp TEXT)");
        sqLiteDatabase.execSQL(query);

        String initial = ("insert into entries(_id, title, content, mood, time) VALUES('1', 'Dit is een titel', 'Dit is echt wel content', 'great...' ,'2018-11-26 13:20:20')");
        sqLiteDatabase.execSQL(initial);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String query = ("drop table entries");
        sqLiteDatabase.execSQL(query);
        onCreate(sqLiteDatabase);

    }
}
