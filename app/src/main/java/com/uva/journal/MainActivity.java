package com.uva.journal;

import android.content.Intent;
import android.support.annotation.MainThread;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ListView listview = (ListView) findViewById(R.id.listy);
        //listview.setOnItemClickListener(new ListViewClickListener());
        EntryDatabase db = EntryDatabase.getInstance(getApplicationContext());
    }

    public void onClick(View v){
        startActivity(new Intent(MainActivity.this, InputActivity.class));
    }

    private class ListViewClickListener implements AdapterView.OnItemClickListener{
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

        }
    }

    private class ListViewLongClickListener implements AdapterView.OnItemLongClickListener{
        @Override
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {

            return true;
        }
    }


}
