public class Main {

    public static void main(String[] args) {
        WordFinder.initGrid();
        System.out.println("\nDisplaying the grid\n");
        WordFinder.printGrid();
        System.out.println("\nFinding the words\n");
        WordFinder.find();
    }
}
