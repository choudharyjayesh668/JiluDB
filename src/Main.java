public class Main{
    public static void main(String[] args) {
        Document Trial = new Document();
        Trial.put("NAME", "Jayesh");
        String name = (String) Trial.get("NAME");
        System.out.println(name);
    }
}