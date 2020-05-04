import java.util.ArrayList;
import java.util.Objects;

public class History {
    String username;
    ArrayList<Operation> operations=new ArrayList<>();


    public History(String username) {
        this.username = username;
    }
    public void addOperation(Operation op){
        operations.add(op);
    }

    @Override
    public String toString() {
        return "History{" +
                "user=" + username +
                ", operations=" + operations +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        History history = (History) o;
        return Objects.equals(username, history.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username);
    }
}
