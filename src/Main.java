public class Main{
    public static void main(String[] args) {
        Collection collectionTrial = new Collection();
        Document Trial = new Document();
        Document Trial2 = new Document();
        Trial.put("name", "Jayesh");
        Trial.put("age","21");
        Trial2.put("name", "Dharmendra");
        Trial2.put("age", "24");
        collectionTrial.put("user1",Trial);
        collectionTrial.put("user2",Trial2);
        Document collectionsdata = collectionTrial.get("user1");
        Document collectionsdata2 = collectionTrial.get("user2");

        String name = (String) collectionsdata.get("name");
        String age = (String) collectionsdata.get("age");

        String name2 = (String) collectionsdata2.get("name");
        String age2 = (String) collectionsdata2.get("age");

        System.out.println(name);
        System.out.println(age);

        System.out.println(name2);
        System.out.println(age2);

    }
}