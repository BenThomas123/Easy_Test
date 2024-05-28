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

    public String toString() {
        String str = "";
        str += super.getPrompt() + "\n\n";
        for (int i = 0; i < parts.getSize(); i++){
            str += (parts.get(i).getData().getPart() + ". " + parts.get(i).getData().getPrompt());
            for (int j = 0; j < parts.get(i).getData().getSpace(); j++) {
                str += "\n";
            }
        }
        return str;
    }

    public void printOut(){
        //todo
    }

}
