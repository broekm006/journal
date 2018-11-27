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

    public Cursor selectAll(){
        String query = ("Select * FROM entries");
        return getWritableDatabase().rawQuery(query, null);
    }

    public void insert(JournalEntry insertion){
        ContentValues value = new ContentValues();
        value.put("title", insertion.getTitle());
        value.put("content", insertion.getContent());
        value.put("mood", insertion.getMood());
        value.put("timestamp", insertion.getTimestamp());
        getWritableDatabase().insert("entries", null, value);
    }

    public void delete(long id){
        sqLiteDatabase = getWritableDatabase();
        sqLiteDatabase.execSQL("delete from entries where _id='"+id+"'");
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = ("create table entries (_id INTEGER PRIMARY KEY, title TEXT, content TEXT, mood TEXT, timestamp TEXT)");
        sqLiteDatabase.execSQL(query);

        String initial = ("insert into entries(_id, title, content, mood, timestamp) VALUES('1', 'is een titel', 'Dit is echt wel content', 'great' ,'2018-11-26 13:20:20')");
        sqLiteDatabase.execSQL(initial);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String query = ("drop table entries");
        sqLiteDatabase.execSQL(query);
        onCreate(sqLiteDatabase);

    }
}
