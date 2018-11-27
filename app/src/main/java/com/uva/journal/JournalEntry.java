package com.uva.journal;

import java.io.Serializable;

public class JournalEntry implements Serializable {
    private int id;
    private String title, content, mood, timestamp;

    // constructor for base items
    public JournalEntry(String title, String content, String mood, String timestamp) {
        this.title = title;
        this.content = content;
        this.mood = mood;
        this.timestamp = timestamp;
    }

    // methods to return specific entries
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

    public String getTimestamp() {
        return timestamp;
    }


}


