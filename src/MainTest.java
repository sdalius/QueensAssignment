import java.util.Scanner;

public class MainTest {
    public static void main(String args[]) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter the size of the board");
        int input = keyboard.nextInt();
        //Create an object with a size of user choice
        Matrix matrix = new Matrix(input);
        for(int i = 0; i < input ; i++)
        {
            System.out.println("===========================Adding Queen to the " + i + " row==========================");
            matrix.addQueen(i,0,2);
            addQueenAndCheck(matrix);
            // Everytime we are adding a new queen in a row, we are cleaning old solutions.
            matrix.fillMatrix();
        }
    }

    public static void addQueenAndCheck(Matrix matrix)
    {
        int[][] board = matrix.getBoard();

        for(int i = 0; i < board.length; i++)
        {
            for(int j = 1; j < board[i].length; j++) {

                if(matrix.isTopRightOk(i, j) && matrix.isTopLeftOk(i, j) && matrix.isBotLeftOk(i, j) && matrix.isBotRightOk(i, j)&& matrix.isRowOk(i) && matrix.isColOk(j) )
                {
                    matrix.addQueen(i, j, 2);
                }
            }
        }
        if(matrix.hasSolution())
        {
            matrix.printBoard();
        }
        else{
            System.out.println("No Solution");
            matrix.printBoard();
        }
    }
} 