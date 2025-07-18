public abstract class Person {
    protected String url = "jdbc:sqlite:library.db";
    protected String name;
    protected int id;
    protected String access;
    protected String[] accessChoice = {"Member", "Librarian", "Author"}; // 0 - member, 1 - librarian, 2 - author
    //protected static int personCount = 1;


    public Person() {
        this.name = new String();
        this.id = 0;
        this.access = new String();
    }
    // Constructor
    public Person(String name, int id, int access) {
        this.name = name;
        this.id = id;
        this.access = accessChoice[access];
    }

    // Getter
    public String getName() {
        return name;
    }

    public int getID() {
        return id;
    }

    // Setter
    public void setName(String name) {
        this.name = name;
    }

    public void setID(int id) {
        this.id = id;
    }


}
