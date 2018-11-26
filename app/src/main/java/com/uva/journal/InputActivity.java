package com.uva.journal;

import android.content.Intent;
import android.media.midi.MidiInputPort;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

public class InputActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);
    }

    public void submit(View v){
        startActivity(new Intent(InputActivity.this, DetailActivity.class));
    }
}
