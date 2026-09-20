
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
    public boolean containsKey(String key) {
        return data.containsKey(key);
    }
    public void remove(String key){
        data.remove(key);
    }
    public HashMap<String, Object> getAll(){
        return data;
    }
    @Override 
    public String toString() {
        return data.toString();
    }
    public HashMap<String,Object> getdata(){
        return data;
    }
}