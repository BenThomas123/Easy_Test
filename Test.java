import java.util.Random;

public class Test {

    private String nameOfExam;
    private int questionCount;
    private int totalPointsAvailable;
    private LinkedList<Test> pastVersions;
    private String sortingMethod;
    private LinkedList<BinarySearchTree<Integer, QuestionPart>> questionList;
    private LinkedList<BinarySearchTree<Integer, QuestionPart>> questionBank;
    private LinkedList<String> groups;

    // Default constructor
    public Test() {
        this.nameOfExam = "";
        this.questionCount = 0;
        this.totalPointsAvailable = 0;
        this.pastVersions = new LinkedList<>();
        this.sortingMethod = "";
        this.questionList = new LinkedList<>();
        this.questionBank = new LinkedList<>();
    }

    // Constructor with all fields
    public Test(String nameOfExam, int questionCount, int totalPointsAvailable, LinkedList<Test> pastVersions, String sortingMethod, LinkedList<BinarySearchTree<Integer, QuestionPart>> questionList, LinkedList<BinarySearchTree<Integer, QuestionPart>> questionBank) {
        this.nameOfExam = nameOfExam;
        this.questionCount = questionCount;
        this.totalPointsAvailable = totalPointsAvailable;
        this.pastVersions = pastVersions;
        this.sortingMethod = sortingMethod;
        this.questionList = questionList;
        this.questionBank = questionBank;
    }

    // Getter and setter methods for nameOfExam
    public String getNameOfExam() {
        return nameOfExam;
    }

    public void setNameOfExam(String nameOfExam) {
        this.nameOfExam = nameOfExam;
    }

    // Getter and setter methods for questionCount
    public int getQuestionCount() {
        return questionCount;
    }

    public void setQuestionCount(int questionCount) {
        this.questionCount = questionCount;
    }

    // Getter and setter methods for totalPointsAvailable
    public int getTotalPointsAvailable() {
        return totalPointsAvailable;
    }

    public void setTotalPointsAvailable(int totalPointsAvailable) {
        this.totalPointsAvailable = totalPointsAvailable;
    }

    // Getter and setter methods for pastVersions
    public LinkedList<Test> getPastVersions() {
        return pastVersions;
    }

    public void setPastVersions(LinkedList<Test> pastVersions) {
        this.pastVersions = pastVersions;
    }

    // Getter and setter methods for sortingMethod
    public String getSortingMethod() {
        return sortingMethod;
    }

    public void setSortingMethod(String sortingMethod) {
        this.sortingMethod = sortingMethod;
    }

    // Getter and setter methods for questionList
    public LinkedList<BinarySearchTree<Integer, QuestionPart>> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(LinkedList<BinarySearchTree<Integer, QuestionPart>> questionList) {
        this.questionList = questionList;
    }

    // Getter and setter methods for questionBank
    public LinkedList<BinarySearchTree<Integer, QuestionPart>> getQuestionBank() {
        return questionBank;
    }

    public void setQuestionBank(LinkedList<BinarySearchTree<Integer, QuestionPart>> questionBank) {
        this.questionBank = questionBank;
    }

    public void buildTest () {
        this.resetTest();
        if (this.sortingMethod.equals("Inorder Sort")) {
            this.inOrderSort();
        } else if (this.sortingMethod.equals("Random Sort")){
            this.randomSort();
        } else if (this.sortingMethod.equals("Circular Sort")) {
            this.circularSort();
        } else {
            this.alphabeticalSort();
        }
    }

    public void inOrderSort() {
        for (int i = 0; i < this.questionCount; i++) {
            questionList.add(questionBank.get(i));
        }
    }

    // Method to build the test
    public void randomSort() {
        LinkedList<Integer> alreadyChosenNumbers = new LinkedList<>();
        Random random = new Random();

        while (questionList.getSize() < questionCount) {
            int randomQuestion = random.nextInt(questionBank.getSize());
            if (!alreadyChosenNumbers.contains(randomQuestion)) {
                alreadyChosenNumbers.add(randomQuestion);
                questionList.add(questionBank.get(randomQuestion));
            }
        }
    }

    public static LinkedList<BinarySearchTree<Integer, QuestionPart>> randomSort(LinkedList<BinarySearchTree<Integer, QuestionPart>> questionBank, LinkedList<BinarySearchTree<Integer, QuestionPart>> list, int questionCount) {
        LinkedList<Integer> alreadyChosenNumbers = new LinkedList<Integer>();
        Random random = new Random();

        while (list.getSize() < questionCount) {
            int randomQuestion = random.nextInt(questionBank.getSize());
            if (!alreadyChosenNumbers.contains(randomQuestion)) {
                alreadyChosenNumbers.add(randomQuestion);
                list.add(questionBank.get(randomQuestion));
            }
        }
        return list;
    }

    public void alphabeticalSort() {
        for (int i = 0; i < this.questionCount - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < this.questionCount; j++) {
                String currentQuestionPrompt = this.questionBank.get(j).get(j).getPrompt();
                String minQuestionPrompt = this.questionBank.get(minIndex).get(minIndex).getPrompt();
                if (currentQuestionPrompt.compareTo(minQuestionPrompt) < 0) {
                    minIndex = j;
                }
            }
            // Swap the found minimum element with the element at index 'i'
            BinarySearchTree<Integer, QuestionPart> temp = this.questionBank.get(i);
            this.questionBank.add(i, this.questionBank.get(minIndex));
            this.questionBank.add(minIndex, temp);
        }
    }

    public void groupSort() {
        for (int i = 0; i < groups.getSize(); i++) {
            String desiredGroup = groups.get(i);
            LinkedList<BinarySearchTree<Integer, QuestionPart>> list = new LinkedList<BinarySearchTree<Integer, QuestionPart>>();
            list.clear();
            for (int j = 0; j < this.questionCount; j++) {
                String currentGroup = groups.get(j);
                if (currentGroup.equals(desiredGroup)) {
                    list.add(this.questionBank.get(i));
                }
            }
            list = Test.randomSort(list, list, questionCount);
            for (int x = 0; x < list.getSize(); x++) {
                questionList.add(list.get(x));
            }
        }
    }

    public void circularSort() {
        Random random = new Random();
        int randomQuestion = random.nextInt(questionCount);

        for (int i = randomQuestion; i < questionBank.getSize(); i++) {
            questionList.add(questionBank.get(i));
        }

        for (int i = 0; i < randomQuestion; i++) {
            questionList.add(questionBank.get(i));
        }
    }

    // Method to reset the test
    public void resetTest () {
        questionList.clear();
    }
}