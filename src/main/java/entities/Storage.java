package entities;

import java.util.*;

public class Storage {
    public String username;
    public Operation operation;

    public Storage(String username, Operation operation) {
        this.username = username;
        this.operation=operation;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Storage storage = (Storage) o;
        return username.equals(storage.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username);
    }

    @Override
    public String toString() {
        return "entities.Storage{" +
                "user=" + username +
                ", operation=" + operation +
                '}';
    }
}
