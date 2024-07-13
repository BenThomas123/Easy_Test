public class Account {
    private String username;
    private String password;
    private LinkedList<Clas> Class = new LinkedList<Clas>();

    // Constructor
    public Account(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Getter for username
    public String getUsername() {
        return username;
    }

    // Setter for username
    public void setUsername(String username) {
        this.username = username;
    }

    // Getter for password
    public String getPassword() {
        return password;
    }

    // Setter for password
    public void setPassword(String password) {
        this.password = password;
    }

    // Getter for questionBank
    public LinkedList<Clas> getClasses() {
        return Class;
    }

    // Setter for questionBank
    public void setClass(LinkedList<Clas> classes) {
        this.Class = classes;
    }

    // Method to add a Test to the questionBank
    public void addTestToQuestionBank(Clas c) {
        this.Class.add(c);
    }

    // Method to remove a Test from the questionBank
    public void removeTestFromQuestionBank(Clas c) {
        this.Class.remove(c);
    }
}
