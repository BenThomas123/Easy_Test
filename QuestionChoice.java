public class QuestionChoice {

    private String solution;
    private boolean isCorrect;
    private char option;

    // Parameterized constructor
    public QuestionChoice(String solution, boolean isCorrect, char option) {
        this.solution = solution;
        this.isCorrect = isCorrect;
        this.option = option;
    }

    // Getter for solution
    public String getSolution() {
        return solution;
    }

    // Setter for solution
    public void setSolution(String solution) {
        this.solution = solution;
    }

    // Getter for isCorrect
    public boolean isCorrect() {
        return isCorrect;
    }

    // Setter for isCorrect
    public void setCorrect(boolean isCorrect) {
        this.isCorrect = isCorrect;
    }

    // Getter for option
    public char getOption() {
        return option;
    }

    // Setter for option
    public void setOption(char option) {
        this.option = option;
    }

}