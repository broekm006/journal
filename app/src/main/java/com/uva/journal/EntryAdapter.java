package com.uva.journal;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.widget.ImageView;
import android.widget.ResourceCursorAdapter;
import android.widget.TextView;


public class EntryAdapter extends ResourceCursorAdapter{

    public EntryAdapter(Context context, Cursor cursor) {
        super(context, R.layout.entry_row, cursor);
    }

    // get information and fill listview
    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView title = view.findViewById(R.id.text_title);
        TextView date = view.findViewById(R.id.text_date);
        TextView mood = view.findViewById(R.id.text_mood);
        ImageView img = view.findViewById(R.id.text_image);

        // replace current information with the correct information from the database
        title.setText(cursor.getString(cursor.getColumnIndex("title")));
        date.setText(cursor.getString(cursor.getColumnIndex("timestamp")));
        mood.setText(cursor.getString(cursor.getColumnIndex("mood")));
        img.setImageResource(context.getResources().getIdentifier(cursor.getString(cursor.getColumnIndex("mood")), "drawable", context.getPackageName()));
        }
}
