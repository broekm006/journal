package com.uva.journal;

import android.content.Intent;
import android.database.Cursor;
import android.support.annotation.MainThread;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.Map;

public class MainActivity extends AppCompatActivity {
    EntryDatabase db;
    EntryAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = EntryDatabase.getInstance(getApplicationContext());
        adapter = new EntryAdapter(this, db.selectAll());

        ListView listview = (ListView) findViewById(R.id.listy);
        listview.setAdapter(adapter);
        listview.setOnItemClickListener(new ListViewClickListener());
        listview.setOnItemLongClickListener(new ListViewLongClickListener());

    }

    public void onClick(View v){
        startActivity(new Intent(MainActivity.this, InputActivity.class));
    }

    private class ListViewClickListener implements AdapterView.OnItemClickListener{
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            //JournalEntry entry = (JournalEntry) adapterView.getItemAtPosition(i);
            Cursor anotherOne = (Cursor) adapterView.getItemAtPosition(i);

            Intent intent = new Intent(MainActivity.this, DetailActivity.class);
            intent.putExtra("title", anotherOne.getString(anotherOne.getColumnIndex("title")));
            intent.putExtra("content", anotherOne.getString(anotherOne.getColumnIndex("content")));
            intent.putExtra("mood", anotherOne.getString(anotherOne.getColumnIndex("mood")));
            intent.putExtra("timestamp", anotherOne.getString(anotherOne.getColumnIndex("timestamp")));

            startActivity(intent);
        }
    }

    private class ListViewLongClickListener implements AdapterView.OnItemLongClickListener{
        @Override
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
            Cursor cursor = (Cursor) adapterView.getItemAtPosition(i);
            long position = cursor.getLong(cursor.getColumnIndex("_id"));
            System.out.println(position);
            db.delete(position);
            updateData();
            return true;
        }
    }

    public void updateData(){
        Cursor second_cursor= db.selectAll();
        adapter.swapCursor(second_cursor);
    }

    public void onResume(){
        super.onResume();
    }


}
