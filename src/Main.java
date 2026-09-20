public class Main{
    public static void main(String[] args) throws Exception {
        Database database = new Database();

        // Collection 1
        Collection users = new Collection();

        Document jayesh = new Document();
        jayesh.put("name", "Jayesh");
        jayesh.put("age", 21);
        jayesh.put("active", true);
        
        Document dharmendra = new Document();
        dharmendra.put("name", "Dharmendra");
        dharmendra.put("age", 24);

        users.put("user1", jayesh);
        users.put("user2", dharmendra);

        database.put("users", users);
        database.insert("InsertAPI", "user3", "name", "Leela");
        // Save database
        database.save();

        System.out.println("Database saved!");
    }
}