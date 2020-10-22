package com.justpark.models;

public abstract class DBObject {
    private long uid; //unique id
    //auto incr
    //primary key
    //in memory
    private static long NEW_UID = 0;
    public DBObject(){
        this.uid = ++NEW_UID;
    }

    public long getUid() {
        return uid;
    }
}
