package com.uva.journal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.Date;

public class InputActivity extends AppCompatActivity implements View.OnClickListener {
    String mood;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);

        ImageButton dead = (ImageButton) findViewById(R.id.dead);
        dead.setOnClickListener(this);
        ImageButton cry = (ImageButton) findViewById(R.id.sad);
        cry.setOnClickListener(this);
        ImageButton happy = (ImageButton) findViewById(R.id.happy);
        happy.setOnClickListener(this);
        ImageButton happyCry = (ImageButton) findViewById(R.id.happy_joke);
        happyCry.setOnClickListener(this);

        btn = (Button) findViewById(R.id.button);
        btn.setEnabled(false);
    }

    public void addEntry(View view){
        TextView title = findViewById(R.id.Title);
        TextView content = findViewById(R.id.editText);

        String currentDateTimeString = DateFormat.getDateTimeInstance().format(new Date());

        JournalEntry some_entry = new JournalEntry(title.getText().toString(), content.getText().toString(), mood, currentDateTimeString);
        EntryDatabase db = EntryDatabase.getInstance(this);
        db.insert(some_entry);

        startActivity(new Intent(InputActivity.this, MainActivity.class));

    }

    @Override
    public void onClick(View view){

        switch(view.getId()){
            case R.id.dead:
                mood = "dead";
                btn.setEnabled(true);
                break;

            case R.id.sad:
                mood = "sad";
                btn.setEnabled(true);
                break;

            case R.id.happy:
                mood = "happy";
                btn.setEnabled(true);
                break;

            case R.id.happy_joke:
                mood = "happy_joke";
                btn.setEnabled(true);
                break;

            default:
                mood = "happy";
                break;
        }
    }

}
