
import java.util.HashMap;

public class Collection{
    private final HashMap<String,Document>documents;
    public Collection(){
        documents = new HashMap<>();
    }
    public void put(String key , Document value){
        documents.put(key , value);
    }
    public Document get(String key){
        return documents.get(key);
    }
    public void remove(String key){
        documents.remove(key);
    }
    public boolean containsKey(String key){
        return documents.containsKey(key);
    }
    public HashMap<String, Document> getAll(){
        return documents;
    }
    @Override 
    public String toString(){
        return documents.toString();
    }
    public HashMap<String, Document> getDocuments(){
        return documents;
    }
}