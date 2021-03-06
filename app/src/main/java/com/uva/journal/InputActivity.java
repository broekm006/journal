package com.uva.journal;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.Date;

public class InputActivity extends AppCompatActivity implements View.OnClickListener {
    String mood;
    Button btn;
    ImageButton dead;
    ImageButton sad;
    ImageButton happy;
    ImageButton happyCry;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);

        // find image buttons and set click listener
        dead = (ImageButton) findViewById(R.id.dead);
        dead.setOnClickListener(this);
        sad = (ImageButton) findViewById(R.id.sad);
        sad.setOnClickListener(this);
        happy = (ImageButton) findViewById(R.id.happy);
        happy.setOnClickListener(this);
        happyCry = (ImageButton) findViewById(R.id.happy_joke);
        happyCry.setOnClickListener(this);

        // disable submit button untill emoji is clicked
        btn = (Button) findViewById(R.id.button);
        btn.setEnabled(false);
    }

    // add new entry to journal
    public void addEntry(View view){
        TextView title = findViewById(R.id.Title);
        TextView content = findViewById(R.id.editText);

        String currentDateTimeString = DateFormat.getDateTimeInstance().format(new Date());

        JournalEntry some_entry = new JournalEntry(title.getText().toString(), content.getText().toString(), mood, currentDateTimeString);
        EntryDatabase db = EntryDatabase.getInstance(this);
        db.insert(some_entry);

        startActivity(new Intent(InputActivity.this, MainActivity.class));

    }

    // check which emoji is clicked and re-enable submit button
    // set a green ish color when button is clicked and reset the others to blank
    @Override
    public void onClick(View view){

        switch(view.getId()){
            case R.id.dead:
                mood = "dead";
                btn.setEnabled(true);
                dead.setBackgroundColor(Color.parseColor("#9dada0"));
                sad.setBackgroundColor(Color.parseColor("#00000000"));
                happy.setBackgroundColor(Color.parseColor("#00000000"));
                happyCry.setBackgroundColor(Color.parseColor("#00000000"));
                break;

            case R.id.sad:
                mood = "sad";
                btn.setEnabled(true);
                sad.setBackgroundColor(Color.parseColor("#9dada0"));
                dead.setBackgroundColor(Color.parseColor("#00000000"));
                happy.setBackgroundColor(Color.parseColor("#00000000"));
                happyCry.setBackgroundColor(Color.parseColor("#00000000"));
                break;

            case R.id.happy:
                mood = "happy";
                btn.setEnabled(true);
                happy.setBackgroundColor(Color.parseColor("#9dada0"));
                sad.setBackgroundColor(Color.parseColor("#00000000"));
                dead.setBackgroundColor(Color.parseColor("#00000000"));
                happyCry.setBackgroundColor(Color.parseColor("#00000000"));
                break;

            case R.id.happy_joke:
                mood = "happy_joke";
                btn.setEnabled(true);
                happyCry.setBackgroundColor(Color.parseColor("#9dada0"));
                dead.setBackgroundColor(Color.parseColor("#00000000"));
                sad.setBackgroundColor(Color.parseColor("#00000000"));
                happy.setBackgroundColor(Color.parseColor("#00000000"));
                break;

            default:
                mood = "happy";
                break;
        }
    }

}
