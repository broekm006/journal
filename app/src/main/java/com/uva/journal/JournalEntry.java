package com.uva.journal;

import java.io.Serializable;
import java.sql.Time;

public class JournalEntry implements Serializable {
    private int id;
    private String title, content, mood;
    private Time timestamp;

    public JournalEntry(int id, String title, String content, String mood, Time timestamp) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.mood = mood;
        this.timestamp = timestamp;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getMood() {
        return mood;
    }

    public Time getTimestamp() {
        return timestamp;
    }


}


