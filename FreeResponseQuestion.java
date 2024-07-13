public class FreeResponseQuestion extends Question {
    
    private BinarySearchTree<Character, QuestionPart> parts;

    public FreeResponseQuestion(String prompt, double pointValue) {
        super(prompt, pointValue);
        BinarySearchTree<Character, QuestionPart> parts = new BinarySearchTree<Character, QuestionPart>();
    }

    public  BinarySearchTree<Character, QuestionPart> getParts() {
        return this.parts;
    }

    public int partCount() {
        return parts.size();
    }

    public void addPart(QuestionPart part) {
        parts.put((char) (parts.size() + 97),part);
    }

    public void removePart(char character) {
        parts.delete(character);
    }

    public void printOut(){
        //todo
    }

}
