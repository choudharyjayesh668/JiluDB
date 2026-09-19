public class Main{
    public static void main(String[] args) throws Exception {
        Database database = new Database();

        // Collection 1
        Collection users = new Collection();

        Document jayesh = new Document();
        jayesh.put("name", "Jayesh");
        jayesh.put("age", 21);

        Document dharmendra = new Document();
        dharmendra.put("name", "Dharmendra");
        dharmendra.put("age", 24);

        users.put("user1", jayesh);
        users.put("user2", dharmendra);

        database.put("users", users);


        // Collection 2
        Collection students = new Collection();

        Document rajesh = new Document();
        rajesh.put("name", "Rajesh");
        rajesh.put("age", 22);

        Document anjan = new Document();
        anjan.put("name", "Anjan");
        anjan.put("age", 23);

        students.put("student1", rajesh);
        students.put("student2", anjan);

        database.put("students", students);


        // Collection 3
        Collection employees = new Collection();

        Document rohit = new Document();
        rohit.put("name", "Rohit");
        rohit.put("age", 27);

        Document arjun = new Document();
        arjun.put("name", "Arjun");
        arjun.put("age", 29);

        employees.put("employee1", rohit);
        employees.put("employee2", arjun);

        database.put("employees", employees);


        // Save database
        database.save();

        System.out.println("Database saved!");
    }
}