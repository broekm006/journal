package com.uva.journal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

public class EntryDatabase extends SQLiteOpenHelper {

    private static EntryDatabase instance;
    SQLiteDatabase sqLiteDatabase;

    // constructor
    private EntryDatabase(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    // return instance (if not exsist make new entry)
    public static EntryDatabase getInstance(Context context){
        if (instance == null){
            return instance = new EntryDatabase(context, "com.uva.journal", null, 1);
        }

        else{
            return instance;
        }
    }

    // database statement to select everything from "entries" table
    public Cursor selectAll(){
        return getWritableDatabase().rawQuery(("Select * FROM entries"), null);
    }

    // database statement to insert a new journal entry to the "entries" table
    public void insert(JournalEntry insertion){
        ContentValues value = new ContentValues();
        value.put("title", insertion.getTitle());
        value.put("content", insertion.getContent());
        value.put("mood", insertion.getMood());
        value.put("timestamp", insertion.getTimestamp());
        getWritableDatabase().insert("entries", null, value);
    }

    // database statement to delete a journal entry from the "entries" table where id == a given id
    public void delete(long id){
        sqLiteDatabase = getWritableDatabase();
        sqLiteDatabase.execSQL("delete from entries where _id='"+id+"'");
    }

    // create a new database
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table entries (_id INTEGER PRIMARY KEY, title TEXT, content TEXT, mood TEXT, timestamp TEXT)");
    }

    // on upgrade drop old table and create a new one
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table entries");
        onCreate(sqLiteDatabase);
    }
}
