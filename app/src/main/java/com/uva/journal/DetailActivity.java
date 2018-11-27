package com.uva.journal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        // retrieve data from Main
        Intent intent = getIntent();
        String titleRetrieved = (String) intent.getSerializableExtra("title");
        String contentRetrieved = (String) intent.getSerializableExtra("content");
        String moodRetrieved = (String) intent.getSerializableExtra("mood");
        String timestampRetrieved = (String) intent.getSerializableExtra("timestamp");

        // get location fields from .xml based on resource id
        TextView title = findViewById(R.id.Title_detail);
        TextView content = findViewById(R.id.Description_detail);
        TextView mood = findViewById(R.id.Mood_detail);
        TextView timestamp = findViewById(R.id.Date_detail);

        // update .xml fields based on retrieved data
        title.setText(titleRetrieved);
        content.setText(contentRetrieved);
        mood.setText(moodRetrieved);
        timestamp.setText(timestampRetrieved);
    }
}
