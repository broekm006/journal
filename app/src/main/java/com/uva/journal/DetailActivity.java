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

        Intent intent = getIntent();
        String titleRetreived = (String) intent.getSerializableExtra("title");
        String contentRetreived = (String) intent.getSerializableExtra("content");
        String moodRetreived = (String) intent.getSerializableExtra("mood");
        String timestampRetreived = (String) intent.getSerializableExtra("timestamp");


        TextView title = findViewById(R.id.Title_detail);
        TextView content = findViewById(R.id.Description_detail);
        TextView mood = findViewById(R.id.Mood_detail);
        TextView timestamp = findViewById(R.id.Date_detail);

        title.setText(titleRetreived);
        content.setText(contentRetreived);
        mood.setText(moodRetreived);
        timestamp.setText(timestampRetreived);

        //retrieved.getId();
    }
}
