import java.util.Scanner;

public class MainTest {
    public static void main(String[] args) {
        /* Input things */
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter the size of the board");
        int input = keyboard.nextInt();
        //Create an object with a size of user choice
        Matrix matrix = new Matrix(input);
        for(int i = 0; i < input ; i++)
        {
            System.out.println("===========================Adding Queen to the " + i + " row==========================");
            /* First of all we are adding  a queen in first row and first column */
            matrix.addQueen(i,0);
            /* Calling a method to start putting queens */
            addQueenAndCheck(matrix);
            // Everytime we are adding a new queen in a row, we are cleaning old solutions.
            matrix.fillMatrix();
        }
    }

    private static void addQueenAndCheck(Matrix matrix)
    {
        /* Getting a size of the board */
        int[][] board = matrix.getBoard();

        for(int i = 0; i < board.length; i++)
        {
            for(int j = 1; j < board[i].length; j++) {

                /* Checking all of the rules, so that queen could be placed. i = row, j = column */
                if(matrix.isTopRightOk(i, j) && matrix.isTopLeftOk(i, j) && matrix.isBotLeftOk(i, j) && matrix.isBotRightOk(i, j)&& matrix.isRowOk(i) && matrix.isColOk(j) )
                {
                    matrix.addQueen(i, j);
                }
            }
        }
        /* dummy code, if it has a solution, it just prints board */
        if(matrix.hasSolution())
        {
            matrix.printBoard();
        }
        else{
            /* if not, prints text that this is not a solution and prints the table which had no solutions */
            System.out.println("Not a solution");
            matrix.printBoard();
        }
    }
} 