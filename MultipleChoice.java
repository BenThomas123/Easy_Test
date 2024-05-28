public class MultipleChoice extends Question {

    LinkedList<QuestionChoice> choices = new LinkedList<QuestionChoice>();

    public MultipleChoice(String prompt, double pointValue) {
        super(prompt, pointValue);
    }

    public LinkedList<QuestionChoice> getParts() {
        return this.choices;
    }

    public int partCount() {
        return choices.getSize();
    }

    public void addPart(QuestionChoice choice)  {
        choices.add(choice);
    }

    public void removePart(QuestionChoice choice) {
        choices.remove(choice);
    }

}