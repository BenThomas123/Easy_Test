public class Clas {

    // Private fields
    private LinkedList<Test> tests;
    private String name;

    // Constructor
    public Clas(String name) {
        this.tests = new LinkedList<>();
        this.name = name;
    }

    // Getter for tests
    public LinkedList<Test> getTests() {
        return tests;
    }

    // Setter for tests
    public void setTests(LinkedList<Test> tests) {
        this.tests = tests;
    }

    // Method to add a test
    public void addTest(Test test) {
        this.tests.add(test);
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Setter for name
    public void setName(String name) {
        this.name = name;
    }

    // Additional method to get a specific test by index
    public Test getTest(int index) {
        if (index >= 0 && index < tests.getSize()) {
            return tests.get(index);
        }
        return null;  // or throw an exception
    }
    
    // Additional method to remove a specific test by index
    public void removeTest(int index) {
        if (index >= 0 && index < tests.getSize()) {
            tests.remove(index);
        }
    }
}