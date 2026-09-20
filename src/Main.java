public class Main{
    public static void main(String[] args) throws Exception {
    
        Database database = new Database();
        // database.load();
        // Insert API
        database.insert("users", "user1", "name", "Jayesh");
        database.insert("users", "user1", "age", 21);
        database.insert("users", "user2", "name", "Dharmendra");
        database.insert("users", "user2", "age", 24);
        database.insert("users", "user3", "name", "Dharmedscsdcdscndra");
        database.insert("users", "user3", "age", 24);
        //Update API
        database.update("users", "name", "Jayesh", "age", 23);
        //Find API
        System.out.println(database.find("users", "name", "Jayesh"));
        //SAVE()
        database.save();
        System.out.println("Database saved!");
    }
}