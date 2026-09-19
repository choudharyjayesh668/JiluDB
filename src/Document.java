
import java.util.HashMap;

public class Document{
    private final HashMap<String,Object>data;
    public Document(){
        data = new HashMap<>();
    }
    public void put(String key,Object value){
        data.put(key , value);
    }
    public Object get(String key){
        return data.get(key);
    }
}