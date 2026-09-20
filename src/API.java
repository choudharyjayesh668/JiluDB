import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class API {
    private final Database database;

    public API(Database database) {
        this.database = database;
    }
    public void insert(String collectionName,String documentName,String key,Object value){
        Collection currentCollection = null;
        if(database.containsKey(collectionName)){
            // System.out.println("Collection Exists");
            currentCollection = database.get(collectionName);
        }else{
            Collection newCollection = new Collection();
            currentCollection= newCollection;
            database.put(collectionName, currentCollection);
        }
        Document currDocument = null;
        if(currentCollection.containsKey(documentName)){
            // System.out.println("Document Exists");
            currDocument = currentCollection.get(documentName);
        }else{
            Document newDocument = new Document();
            currDocument = newDocument;
            currentCollection.put(documentName,currDocument);
        }
        currDocument.put(key, value);
    }
    public HashMap<String, Document> find(String collectionName, String key, Object value) {
        HashMap<String, Document> result = new HashMap<>();
        
        if (database.containsKey(collectionName)) {
            Collection currCollection = database.get(collectionName);
            HashMap<String, Document> allDocument = currCollection.getAll();
            for (Map.Entry<String, Document> entry : allDocument.entrySet()) {
                Document currLoopDocument = entry.getValue();
                HashMap<String, Object> documentData = currLoopDocument.getAll();
                if (documentData.containsKey(key)) {
                    Object currentValue = documentData.get(key);
                    if (Objects.equals(currentValue, value)) {
                        // System.out.println("Found");
                        result.put(entry.getKey(), entry.getValue());
                    }
                }
            }
            return result;
        } else {
            System.out.println("Collection Doesent exist");
            return null;
        }
    }
    public void update(String collectionName,String searchKey,Object searchValue,String updateKey,Object updateValue){
        HashMap<String,Document>result = find(collectionName, searchKey, searchValue);
        if (result == null) {
            System.out.println("Collection not found");
        }
        for(Map.Entry<String,Document> entry : result.entrySet()){
            Document document = entry.getValue();
            document.put(updateKey,updateValue);
        }
    }
    public void delete(String collectionName, String searchKey, Object searchValue) {
        HashMap<String, Document> result = find(collectionName, searchKey, searchValue);
        Collection currCollection = database.get(collectionName);
        for (Map.Entry<String, Document> entry : result.entrySet()) {
            currCollection.remove(entry.getKey());
        }
    }
}
