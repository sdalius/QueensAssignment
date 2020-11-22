public class MainTest {
    public static void main(String args[]) {
        Matrix matrix = new Matrix(5,5);
        for(int i = 0; i < 5 ; i++)
        {
            System.out.println("===========================Adding Queen to the " + i + " row==========================");
            matrix.addQueen(i,0,2);
            addQueenAndCheck(matrix);
            matrix.fillMatrix();
        }
    }

    public static void addQueenAndCheck(Matrix matrix)
    {
        int[][] board = matrix.getBoard();

        for(int i = 0; i < board.length; i++)
        {
            for(int j = 1; j < board[i].length; j++) {

                if(matrix.isTopRightOk(i, j) && matrix.isTopLeftOk(i, j) && matrix.isBotLeftOk(i, j) && matrix.isBotRightOk(i, j)&& matrix.isRowOk(j) && matrix.isColOk(j) )
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
        }
    }
} 