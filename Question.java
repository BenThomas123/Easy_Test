public class Question {
    
    private String prompt;
    private String group;
    private double pointValue;

    // Constructors
    public Question(double pointValue) {
        this.prompt = null;
        this.group = null;
        this.pointValue = pointValue;
    }

    public Question(String prompt, double pointValue) {
        this.prompt = prompt;
        this.group = null;
        this.pointValue = pointValue;
    }

    public Question(String prompt, String group, double pointValue) {
        this.prompt = prompt;
        this.group = group;
        this.pointValue = pointValue;
    }

    // Accessors (Getters)
    public String getPrompt() {
        return prompt;
    }

    public String getGroup() {
        return group;
    }

    public double getPointValue() {
        return pointValue;
    }

    // Mutators (Setters)
    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public void setPointValue(double pointValue) {
        this.pointValue = pointValue;
    }
}