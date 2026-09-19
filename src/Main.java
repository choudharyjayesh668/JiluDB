public class Main{
    public static void main(String[] args) throws Exception {
        Database dataBase = new Database();
        Collection collectionTrial = new Collection();
        Collection collectionTrial2 = new Collection();
        Document Trial1 = new Document();
        Document Trial2 = new Document();
        Document Trial3 = new Document();
        Document Trial4 = new Document();
        dataBase.load();
        Trial1.put("name", "Jayesh");
        Trial1.put("age",21);
        Trial2.put("name", "Dharmendra");
        Trial2.put("age", 24);
        collectionTrial.put("user1",Trial1);
        collectionTrial.put("user2",Trial2);    

        Trial3.put("name", "Rajesh");
        Trial3.put("age",21);
        Trial4.put("name", "Anjan");
        Trial4.put("age", 24);
        collectionTrial2.put("user3",Trial3);
        collectionTrial2.put("user4",Trial4);

        Document collectionsdata = collectionTrial.get("user1");
        Document collectionsdata2 = collectionTrial.get("user2");
        Document collectionsdata3 = collectionTrial2.get("user3");
        Document collectionsdata4 = collectionTrial2.get("user4");
        dataBase.put("info1",collectionTrial);
        dataBase.put("info2",collectionTrial2);
        // String name = (String) collectionsdata.get("name");
        // int age = (int) collectionsdata.get("age");

        // String name2 = (String) collectionsdata2.get("name");
        // int age2 = (int) collectionsdata2.get("age");

        // String name3 = (String) collectionsdata3.get("name");
        // int age3 = (int) collectionsdata3.get("age");

        // String name4 = (String) collectionsdata4.get("name");
        // int age4 = (int) collectionsdata4.get("age");

        // System.out.println("Name1 = "+ name);
        // System.out.println( "age1= "+ age);

        // System.out.println("Name 2= "+name2);
        // System.out.println("age 2= "+age2);

        // System.out.println("Name3 = "+ name3);
        // System.out.println( "age 3= "+ age3);

        // System.out.println("Name 4= "+name4);
        // System.out.println("age 4= "+age4);
        // System.out.println(dataBase.getAll());
        dataBase.save();
    }
}