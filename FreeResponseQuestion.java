public class FreeResponseQuestion extends Question {
    
    private LinkedList<QuestionPart> parts;

    public FreeResponseQuestion(String prompt, double pointValue) {
        super(prompt, pointValue);
    }

    public LinkedList<QuestionPart> getParts() {
        return this.parts;
    }

    public int partCount() {
        return parts.getSize();
    }

    public void addPart(QuestionPart part) {
        parts.add(part);
    }

    public void removePart(QuestionPart part) {
        parts.remove(part);
    }

}
