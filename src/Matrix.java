import java.util.Arrays;

class Matrix {
    private int[][] board;
    private int row;
    private int col;

    // 0 - area is not touched
    // 1 - danger zone, other queen can attack
    // 2 - queen

    Matrix(int sizeofboard)
    {
        if (!(sizeofboard > 3))
        {
            System.out.println("n must be bigger than 3. Quitting...");
            System.exit(1);
        }
        else{
            board = new int[sizeofboard][sizeofboard];
            fillMatrix();
        }
    }

    void fillMatrix()
    {
        for(int i=0; i < board.length ;i++)
        {
            for(int j = 0; j<board[i].length; j++)
            {
                board[i][j] = 0;
            }
        }
    }

    int[][] getBoard() {
        return board;
    }

    void printBoard()
    {
        for (int[] row : board)
            System.out.println(Arrays.toString(row));
    }

    /* add queen on the board */
    void addQueen(int row, int col, int val)
    {
        System.out.println("Adding queen to " + "Row: " +  row + " " + "Col: " + col);
        board[row][col] = val;
        /* Fill the board according to the algorithm */
        fillRow(row);
        fillCol(col);
        fillTopLeft(row,col);
        fillTopRight(row,col);
        fillBotLeft(row,col);
        fillBotRight(row,col);
    }

    /* ===================================== Fill Danger Zones =========================================*/
    /* filling row with danger zones */
    private boolean fillRow(int row)
    {
        for(int i=0; i < board.length ;i++)
        {
            if(board[row][i] != 0)
            {
                continue;
            }
            else if( board[row][i] == 2)
            {
                continue;
            }
            board[row][i] = 1;
        }
//        System.out.println("Print board after filling row");
//        printBoard();
//        System.out.println("============================");
        return true;
    }

    /* filling column with danger zones */
    private boolean fillCol(int col)
    {
        for(int i=0; i < board.length ;i++)
        {
            if(board[i][col] != 0)
            {
                continue;
            }
            else if( board[i][col] == 2)
            {
                continue;
            }
            board[i][col] = 1;
        }
//        System.out.println("Print board after filling col");
//        printBoard();
//        System.out.println("============================");
        return true;
    }

    /* Top right filling with danger zones */
    private boolean fillTopRight(int row, int col)
    {
        while(row > -1 && col < board.length )
        {
            if( board[row][col] == 2)
            {
                row--;
                col++;
                continue;
            }
            board[row][col] = 1;
            row--;
            col++;
        }
//        System.out.println("Print board top right");
//        printBoard();
//        System.out.println("============================");
        return true;
    }

    /* Top left filling with danger zones */
    private boolean fillTopLeft(int row, int col)
    {
        while(row > -1 && col > -1 )
        {
            if( board[row][col] == 2)
            {
                row--;
                col--;
                continue;
            }
            board[row][col] = 1;
            row--;
            col--;
        }
//        System.out.println("Print board top left");
//        printBoard();
//        System.out.println("============================");
        return true;
    }

    /* Bot left filling with danger zones */
    private boolean fillBotLeft(int row, int col)
    {
        while(row < board.length && col > -1 )
        {
            if( board[row][col] == 2)
            {
                row++;
                col--;
                continue;
            }
            board[row][col] = 1;
            row++;
            col--;
        }
//        System.out.println("Print board bot left");
//        printBoard();
//        System.out.println("============================");
        return true;
    }

    /* Bot right filling with danger zones */
    private boolean fillBotRight(int row, int col)
    {
        while(row < board.length && col < board.length)
        {
            if( board[row][col] == 2)
            {
                row++;
                col++;
                continue;
            }
            board[row][col] = 1;
            row++;
            col++;
        }
//        System.out.println("Print board bot right");
//        printBoard();
//        System.out.println("============================");
        return true;
    }
    /* ===================================== Checks ====================================================*/

    /* checking if row doesn't have any other queens */
    boolean isRowOk(int row)
    {
        for(int i=0; i < board.length ;i++)
        {
            if(board[row][i] == 0 )
            {
                return true;
            }
        }
        return false;
    }

    /* checking if column doesn't have any other queens */
    boolean isColOk(int col)
    {
        for(int[] ints : board) {
            if(ints[col] != 0) {
                continue;
            }
            return true;
        }
        return false;
    }

    /* Checking if the top right side doesn't have queens, by given the current location of the queen */
    public boolean isTopRightOk(int row, int col)
    {
        while(row > -1 && col < board.length )
        {
            if(board[row][col] == 0)
            {
                return true;
            }
            row--;
            col++;
        }
        return false;
    }

    //Checking if we have queens from top to the left
    public boolean isTopLeftOk(int row, int col)
    {
        while(row > -1 && col > -1 )
        {
            if(board[row][col] == 0)
            {
                return true;
            }
            row--;
            col--;
        }
        return true;
    }

    //Checking if we have queens from bottom to the left
    public boolean isBotLeftOk(int row, int col)
    {
        while(row < board.length && col > -1 )
        {
            if(board[row][col] == 0)
            {
                return true;
            }
            row++;
            col--;
        }
        return false;
    }

    //Checking if we have queens from bottom to the right
    public boolean isBotRightOk(int row, int col)
    {
        while(row < board.length && col < board.length)
        {
                if(board[row][col] == 0)
                {
                    return true;
                }
            row++;
            col++;
        }
        return false;
    }

    boolean hasSolution()
    {
        int size = 0;
        for(int i=0; i < board.length ;i++)
        {
            for(int j = 0; j < board[i].length; j++)
            {
                if(board[i][j] == 2) {
                    size++;
                }
            }
        }
        if(board.length == size)
        {
            return true;
        }
        return false;
    }
}
