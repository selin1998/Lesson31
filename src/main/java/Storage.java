import java.util.ArrayList;
import java.util.Optional;

public class Storage {


    ArrayList<History> historyList=new ArrayList<>();

    public void saveHistory(String username, History history){
        if(getAllbyUser(username).isPresent()){
            historyList.set(historyList.indexOf(history),history);
        }
        else{
            historyList.add(history);
        }

    }
    public Optional<History> getAllbyUser(String username){
        return historyList.stream().filter(h->h.username.equals(username)).findAny();
    }

}
