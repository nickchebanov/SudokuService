import java.util.Arrays;

/**
 * Created by nickc on 3/12/16.
 */
public class Sudoku {

//
//    private int[][] board = {{0, 6, 0, 1, 0, 4, 0, 5, 0},
//                             {0, 0, 8, 3, 0, 5, 6, 0, 0},
//                             {2, 0, 0, 0, 0, 0, 0, 0, 1},
//                             {8, 0, 0, 4, 0, 7, 0, 0, 6},
//                             {0, 0, 6, 0, 0, 0, 3, 0, 0},
//                             {7, 0, 0, 9, 0, 1, 0, 0, 4},
//                             {5, 0, 0, 0, 0, 0, 0, 0, 2},
//                             {0, 0, 7, 2, 0, 6, 9, 0, 0},
//                             {0, 4, 0, 5, 0, 8, 0, 7, 0}};

    private int[][] board = {
            {5, 3, 4, 6, 7, 8, 9, 1, 2},
            {6, 7, 2, 1, 9, 5, 3, 4, 8},
            {1, 9, 8, 3, 4, 2, 5, 6, 7},

            {8, 5, 9, 7, 6, 1, 4, 2, 3},
            {4, 2, 6, 8, 5, 3, 7, 9, 1},
            {7, 1, 3, 9, 2, 4, 8, 5, 6},

            {9, 6, 1, 5, 3, 7, 2, 8, 4},
            {2, 8, 7, 4, 1, 9, 6, 3, 5},
            {3, 4, 5, 2, 8, 6, 1, 7, 9}
        };

    public static void main(String[] args) {
        Sudoku sudoku = new Sudoku();
        System.out.println("Checking move = " +sudoku.checkMove(5,5,4));
        System.out.println("Checking board = " + sudoku.checkSudokuStatus());
    }

    /**
     * Checks that sudoku is resolved or not
     * @return true if solution found, else false
     */
    private boolean checkSudokuStatus() {
        for (int i = 0; i < 9; i++) {

            int[] row = new int[9];
            int[] square = new int[9];
            int[] column = board[i].clone();

            for (int j = 0; j < 9; j++) {
                row[j] = board[j][i];
                square[j] = board[(i / 3) * 3 + j / 3][i * 3 % 9 + j % 3];
            }
            if (validateStatus(column) && validateStatus(row) && validateStatus(square))
                return false;
        }
        return true;
    }


    /**
     * Checks that no missing elements in the array
     * @param array - array to check
     * @return - true if element is missing, esle false
     */
    private boolean validateStatus(int[] array) {
        int i = 0;
        Arrays.sort(array);
        for (int element : array) {
            if (element != ++i)
                return true;
        }
        return false;
    }


    /**
     * Checks if move on board is right and doesn't violates sudoku rules
     * @param x - row number on the board
     * @param y - column number on the board
     * @param value - value to check
     * @return - true if move is valid , else false
     */
    private boolean checkMove(int x, int y, int value){

        if(x>8 && x<0){
            return false;
        }
        if(y>8 && y<0){
            return false;
        }
        if(value>8 && value<0){
            return false;
        }

        int[] column = new int[9];
        int[] square = new int[9];
        int[] row = board[x].clone();

        for (int j = 0; j < 9; j++) {
            column[j] = board[j][x];
            square[j] = board[((x-1) / 3) * 3 + j / 3][(x-1) * 3 % 9 + j % 3];
        }
            System.out.println("Grid values : ");

        if (validateMove(column, value) && validateMove(row,value) && validateMove(square,value))
            return false;

        return true;
    }

    /**
     * Checks that value occures in array
     * @param array - array to check
     * @param value - value to check
     * @return - true if occures, else false
     */
    private boolean validateMove(int[] array, int value) {

        boolean result = false;

        for(int element : array){
            if(value == element){
                result = true;
                break;
            }
        }

        return result;
    }

    public int[][] getBoard() {
        return board;
    }

    public void setBoard(int[][] board) {
        this.board = board;
    }
}
