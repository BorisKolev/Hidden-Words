/*
Program that finds words hidden in a grid
Created: 28/02/2019
Author: Borislav Kolev
*/

public class Main {

    public static void main(String[] args) {
        WordFinder.initGrid();
        System.out.println("\nDisplaying the grid\n");
        WordFinder.printGrid();
        System.out.println("\nFinding the words\n");
        WordFinder.find();
    }
}
