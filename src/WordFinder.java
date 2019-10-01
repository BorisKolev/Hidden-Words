import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

class WordFinder {
    private static final int N = 10;
    private static char[][] grid = new char[N][N];
    private static final String GRID_FILE = "data/grid.txt";
    private static final String WORD_FILE = "data/words.txt";

    // Reading each character from the file "grid.txt" and placing it into [][] grid
    static void initGrid(){
        try(
                FileReader fReader = new FileReader(GRID_FILE);
                BufferedReader bReader = new BufferedReader(fReader)
        ) {
            int y = 0;
            while(true){
                String line = bReader.readLine();
                if(line == null){
                    break;
                }
                for(int x = 0; x <line.length(); x++){
                    grid[y][x] = line.charAt(x);
                }
                y ++;
            }
        }
        catch (Exception e){
            System.out.println("Error");
        }
    }

    // Printing [][] grid
    static void printGrid(){
        try(
                FileReader fReader = new FileReader(GRID_FILE);
                BufferedReader bReader = new BufferedReader(fReader)
        ) {
            while(true){
                String line = bReader.readLine();
                if(line == null){
                    break;
                }
                System.out.println(line);
            }
        }
        catch (Exception e){
            System.out.println("Error");
        }
    }

    // Searching for the word using the grid
    static void find(){
        try(
                FileReader wordReader = new FileReader(WORD_FILE);
                BufferedReader wordBuffReader = new BufferedReader(wordReader)
        ){
            // Getting the column characters from the grid File
            ArrayList<String> columnArrayWords = new ArrayList<>();
            for(int i = 0; i<grid[0].length; i++){
                StringBuilder columnWord = new StringBuilder();
                for (char[] chars : grid) {
                    columnWord.append(chars[i]);
                }
                columnArrayWords.add(columnWord.toString());
            }

            while(true){
                FileReader gridReader = new FileReader(GRID_FILE);
                BufferedReader gridBuffReader = new BufferedReader(gridReader);
                String wordLine = wordBuffReader.readLine();
                if(wordLine == null){
                    break;
                }
                // The words that match in each row
                for(int i = 0; i < grid.length; i++){
                    String gridLine = gridBuffReader.readLine();
                    if(gridLine.contains(wordLine)){
                        int position = gridLine.indexOf(wordLine);
                        System.out.println(wordLine+":: row " + i + " position:: " + position);
                    }
                }
                // The words that match in each column
                for(int i = 0; i < grid.length; i++){
                    if(columnArrayWords.get(i).contains(wordLine)){
                        int position = columnArrayWords.get(i).indexOf(wordLine);
                        System.out.println(wordLine+":: column " + i + " position:: " + position);
                    }
                }
            }
        }
        catch(Exception e){
            System.out.println("Error");
        }
    }
}
