package project;

import java.sql.Timestamp;

public class Entry implements Comparable<Entry> {
    private String type;
    private Timestamp entryTime;
    private String entry;

    public Entry(String type, Timestamp entryTime, String entry) {
        this.type = type;
        this.entryTime = entryTime;
        this.entry = entry;
    }

    public String getType() {
        return type;
    }

    public Timestamp getEntryTime() {
        return entryTime;
    }

    public String getEntry() {
        return entry;
    }

    @Override
    public int compareTo(Entry other) {
        return this.getEntryTime().compareTo(other.getEntryTime());
    }
}
