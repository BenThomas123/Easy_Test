public class Question {
    
    private String prompt;
    private double pointValue;

    public Question(double pointValue) {
        this.prompt = null;
        this.pointValue = pointValue;
    }

    public Question(String prompt, double pointValue) {
        this.prompt = prompt;
        this.pointValue = pointValue;
    }

    // Accessors (Getters)
    public String getPrompt() {
        return prompt;
    }

    public double getPointValue() {
        return pointValue;
    }

    // Mutators (Setters)
    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }

    public void setPointValue(double pointValue) {
        this.pointValue = pointValue;
    }


}
