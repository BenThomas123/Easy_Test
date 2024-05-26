public class QuestionPart {
    
    // prompt for the question
    private String prompt;

    // the part of the question
    private char part;

    // the amount of the room under the question
    private int space;

    // the amount of questions
    private double pointValue;

    // Constructor with all attributes
    public QuestionPart(String prompt, char part, double pointValue, int space) {
        this.prompt = prompt;
        this.part = part;
        this.pointValue = pointValue;
        this.space = space;
    }

    // Accessors (Getters)
    public String getPrompt() {
        return prompt;
    }

    public char getPart() {
        return part;
    }

    public double getPointValue() {
        return pointValue;
    }

    public int getSpace() {
        return space;
    }

    // Mutators (Setters)
    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }

    public void setPart(char part) {
        this.part = part;
    }

    public void setPointValue(double pointValue) {
        this.pointValue = pointValue;
    }

    public void setSpace(int space){
        this.space = space;
    }

}