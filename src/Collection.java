
import java.util.HashMap;

public class Collection{
    private HashMap<String,Document>documents;
    public Collection(){
        documents = new HashMap<>();
    }
    public void put(String key , Document value){
        documents.put(key , value);
    }
    public Document get(String key){
        return documents.get(key);
    }
}