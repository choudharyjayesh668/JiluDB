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
        String content = "{";
        int collectionCounter = 0 ;
        for (Map.Entry<String,Collection>collectionentry:collections.entrySet()){
            if(collectionCounter != 0){
                content = content + ",";
            }
            collectionCounter++;
            Collection documentvalue = collectionentry.getValue();
            HashMap<String, Document> documents = documentvalue.getDocuments();
            content = content+"\""+collectionentry.getKey()+"\""+": "+"{";
            int documentCounter = 0;
            for(Map.Entry<String, Document> documentEntry : documents.entrySet()){
                if (documentCounter != 0){
                    content = content +",";
                }
                documentCounter++;
                Document data = documentEntry.getValue();
                HashMap<String, Object> fields = data.getdata();
                content=content+"\""+documentEntry.getKey()+"\""+": "+"{";
                int dataCounter = 0;
                for(Map.Entry<String, Object> fieldEntry : fields.entrySet()){
                    if (dataCounter != 0) {
                        content = content + ",";
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
                    content=content+"\""+fieldEntry.getKey()+"\""+":"+valueString;
                }
                content = content +"}";
            }
            content = content +"}";
        }
        content = content +"}";
        Files.writeString(path, content);
    }
    public void load() throws Exception {
        Collection currentCollection = null;
        Document currentDocument = null;
        String content = Files.readString(path);
        boolean insideQuotes = false;
        StringBuilder currentString = new StringBuilder();
        String key = null;
        int depth = 0 ;
        boolean waitingForValue = false;
        for (int i = 0; i < content.length(); i++) {
            char currentChar = content.charAt(i);
            if (currentChar == '{') {
                depth++;
            } else if (currentChar == '}') {
                depth--;
            } else if (currentChar == '"') {
                insideQuotes = !insideQuotes;
                if (!insideQuotes) {
                if (waitingForValue) {
                    String value = currentString.toString();
                    currentDocument.put(key, value);
                    waitingForValue = false;
                } else {
                    key = currentString.toString();
                }

                currentString.setLength(0);
            }
            } else if (insideQuotes) {
                currentString.append(currentChar);
                
            }
            if(currentChar == ':' && !insideQuotes){
                if (depth == 1){
                    currentCollection = new Collection();
                    put(key,currentCollection);
                }else if(depth == 2){
                    currentDocument = new Document();
                    currentCollection.put(key,currentDocument);
                }else if(depth == 3){
                    waitingForValue = true;
                }
            }
            if (waitingForValue && !insideQuotes) {
                if (Character.isDigit(currentChar)) {
                    currentString.append(currentChar);
                }
                if (currentChar == ',' || currentChar == '}') {
                    String valueString = currentString.toString();
                    if (!valueString.isEmpty()) {
                        int value = Integer.parseInt(valueString);
                        currentDocument.put(key, value);
                    }
                    currentString.setLength(0);
                    waitingForValue = false;
                }
            }
        }
    }
}