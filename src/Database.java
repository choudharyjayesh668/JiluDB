
import java.util.HashMap;

public class Database{
    private final HashMap<String,Collection>collections;
    public Database(){
        collections = new HashMap<>();
    }    
    public void put(String key,Collection value){
        collections.put(key , value);
    }
    public Collection get(String key){
        return collections.get(key);
    }
    
}