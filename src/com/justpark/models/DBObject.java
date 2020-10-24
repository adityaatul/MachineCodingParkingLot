package com.justpark.models;

import java.util.Objects;

public abstract class DBObject {
    private long uid; //unique id
    //auto incr
    //primary key
    //in memory
    private static long NEW_UID = 0;

    public DBObject() {
        this.uid = ++NEW_UID;
    }

    public long getUid() {
        return uid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true; //memory address comparison
        if (!(o instanceof DBObject)) return false; // because I'm not null, other object should also be an instance of DBObject
        DBObject dbObject = (DBObject) o; //Base class object doesn't have UUId, this is downcast ing
        return uid == dbObject.uid; //uuid comparison
        //is not using hashCode() for object comparison as it can be possible that different objects might have same hashcode.
        //eg. collision in hashing .
    }

    @Override
    public int hashCode() {
        return Objects.hash(uid);
        //hash based on UUId and not on the object address
    }
}
