import java.nio.file.*;
import java.util.HashMap;
import java.util.Map;

public class Database{

    private final HashMap<String,Collection>collections;
    private final Path path;

    public Database()throws Exception{
        path = Path.of("DataBase","database.txt");
        if (!Files.exists(path)) {
            Files.createFile(path);
            System.out.println("File Created");
        }else{
            System.out.println("File Already Exist!");
        }
        collections = new HashMap<>();
    }    
    public void put(String key,Collection value){
        collections.put(key , value);
    }
    public Collection get(String key){
        return collections.get(key);
    }
    public void remove(String key){
        collections.remove(key);
    }
    public boolean containsKey(String key){
        return collections.containsKey(key);
    }
    public HashMap<String,Collection> getAll(){
        return collections;
    }
    public void save() throws Exception {
        String content = "{"+"\n ";
        int collectionCounter = 0 ; 
        for (Map.Entry<String,Collection>collectionentry:collections.entrySet()){
            if(collectionCounter != 0){
                content = content + ","+"\n";
            }
            collectionCounter++;
            Collection documentvalue = collectionentry.getValue();
            HashMap<String, Document> documents = documentvalue.getDocuments();
            content = content+"\""+collectionentry.getKey()+"\""+": "+"{"+"\n   ";
            int documentCounter = 0;
            for(Map.Entry<String, Document> documentEntry : documents.entrySet()){
                if (documentCounter != 0){
                    content = content +","+ "\n   ";
                }
                documentCounter++;
                Document data = documentEntry.getValue();
                HashMap<String, Object> fields = data.getdata();
                content=content+"\""+documentEntry.getKey()+"\""+": "+"{"+"\n    ";
                int dataCounter = 0;
                for(Map.Entry<String, Object> fieldEntry : fields.entrySet()){
                    if (dataCounter != 0) {
                        content = content + ","+"\n    ";
                    }
                    String valueString;
                    String escapedValue;
                    if (fieldEntry.getValue() instanceof String){
                        String stringValue = (String) fieldEntry.getValue();
                        escapedValue = stringValue.replace("\"","\\\"");
                        valueString = "\"" + escapedValue + "\"";
                    }else if(fieldEntry.getValue() == null){
                        valueString = "null";
                    }
                    else{
                        valueString = String.valueOf(fieldEntry.getValue());
                    }
                    dataCounter++;
                    // System.out.println(fieldEntry.getKey() + " = " + fieldEntry.getValue());
                    content=content+"\""+fieldEntry.getKey()+"\""+":"+valueString;
                }
                content = content +"\n   "+"}";
            }
            content = content +"\n "+"}";
        }
        content = content +"\n"+"}"+"\n";
        Files.writeString(path, content);
    }
    public void load() throws Exception {
        String loadData = Files.readString(path);
        System.out.println(loadData);
    }
}