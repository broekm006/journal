package com.uva.journal;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    EntryDatabase db;
    EntryAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = EntryDatabase.getInstance(getApplicationContext());
        adapter = new EntryAdapter(this, db.selectAll());

        // set listeners > onclick
        ListView listview = (ListView) findViewById(R.id.listy);
        listview.setAdapter(adapter);
        listview.setOnItemClickListener(new ListViewClickListener());
        listview.setOnItemLongClickListener(new ListViewLongClickListener());

    }


    // on click allow for new input
        public void onClick(View v){
        startActivity(new Intent(MainActivity.this, InputActivity.class));
    }

    // when list item is clicked get information from cursor and open detail page
    private class ListViewClickListener implements AdapterView.OnItemClickListener{
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            Cursor anotherOne = (Cursor) adapterView.getItemAtPosition(i);

            Intent intent = new Intent(MainActivity.this, DetailActivity.class);
            intent.putExtra("title", anotherOne.getString(anotherOne.getColumnIndex("title")));
            intent.putExtra("content", anotherOne.getString(anotherOne.getColumnIndex("content")));
            intent.putExtra("mood", anotherOne.getString(anotherOne.getColumnIndex("mood")));
            intent.putExtra("timestamp", anotherOne.getString(anotherOne.getColumnIndex("timestamp")));

            startActivity(intent);
        }
    }

    // if item in list is clicked for longer period of time delete object
    private class ListViewLongClickListener implements AdapterView.OnItemLongClickListener{
        @Override
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
            Cursor cursor = (Cursor) adapterView.getItemAtPosition(i);
            long position = cursor.getLong(cursor.getColumnIndex("_id"));

            // delete current entry
            db.delete(position);

            // refresh page
            updateData();
            return true;
        }
    }

    // method to refresh the page after each action (delete or insert)
    public void updateData(){
        Cursor second_cursor= db.selectAll();
        adapter.swapCursor(second_cursor);
    }

    public void onResume(){
        super.onResume();
    }

}
