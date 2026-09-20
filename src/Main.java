public class Main{
    public static void main(String[] args) throws Exception {
        
        Database database = new Database();
        API api = new API(database);
        // database.load();
        // Insert API
        api.insert("users", "user1", "name", "Jayesh");
        api.insert("users", "user1", "age", 21);
        api.insert("users", "user2", "name", "Dharmendra");
        api.insert("users", "user2", "age", 24);
        //Update API
        api.update("users", "name", "Jayesh", "age", 23);
        //Find API
        System.out.println(api.find("users", "name", "Jayesh"));
        //DELETE API 
        api.delete("users", "name", "Jayesh");
        //SAVE()
        database.save();
        System.out.println("Database saved!");
    }
}