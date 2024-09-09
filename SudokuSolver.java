import java.util.*;
public class SudokuSolver {
  
    public static void main(String[] args) {
        int[][] board = {
            {5, 3, 0, 0, 7, 0, 0, 0, 0},
            {6, 0, 0, 1, 9, 5, 0, 0, 0},
            {0, 9, 8, 0, 0, 0, 0, 6, 0},
            {8, 0, 0, 0, 6, 0, 0, 0, 3},
            {4, 0, 0, 8, 0, 3, 0, 0, 1},
            {7, 0, 0, 0, 2, 0, 0, 0, 6},
            {0, 6, 0, 0, 0, 0, 2, 8, 0},
            {0, 0, 0, 4, 1, 9, 0, 0, 5},
            {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };
        if(SolveBoard(board))
        {
            for(int i=0;i<9;i++)
            {
                for(int j=0;j<9;j++)
                {
                    System.out.print(board[i][j]+" ");
                }System.out.println();
            }
        }
    }
    public static boolean isValidRow(int[][] board,int num,int row)
    {
        for(int i=0;i<9;i++)
        {
            if(board[row][i]==num)
            {

                return true;
            }
            
        }
        return false;
    }
    public static boolean isValidCol(int[][] board,int num,int col)
    {
        for(int i=0;i<9;i++)
        {
            if(board[i][col]==num)
            {

                return true;
            }
            
        }
        return false;
    }
    public static boolean isValidBox(int[][] board,int num,int row,int col)
    {
        int box_col = col-col%3;
        int box_row = row-row%3;
        for(int i=box_row;i<box_row+3;i++)
        {
            for(int j=box_col;j<box_col+3;j++)
            {
                if(board[i][j]==num)
                {
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean isValidBoard(int[][] board,int num,int row,int col)
    {
        return !isValidBox(board, num, row, col) && !isValidCol(board, num, col) && !isValidRow(board, num, row);
    }
    public static boolean SolveBoard(int[][] board)
    {
        for(int i=0;i<9;i++)
        {
            for(int j=0;j<9;j++)
            {
                if(board[i][j]==0)
                {
                    for(int num=1;num<=9;num++)
                    {

                        if(isValidBoard(board,num,i,j))
                        {
                            board[i][j] = num;
                            if(SolveBoard(board))
                            {
                                return true;
                            }
                            else
                            {
                                board[i][j] = 0;
                            }
                        }
                        
                    }
                    return false;
                }
            }
        }
        return true;
    }
    
}
// import java.util.*;

// public class Main {
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         int[][] board = new int[9][9];
        
//         for (int i = 0; i < 9; i++) {
//             for (int j = 0; j < 9; j++) {
//                 board[i][j] = sc.nextInt();
//             }
//         }

//         long startTime = System.currentTimeMillis();
//         int timeLimit = 2000; // 2 seconds

//         boolean isSolved = solveBoard(board, startTime, timeLimit);
//         if (isSolved && isBoardFilled(board)) {
//             printBoard(board);
//         } else {
//             System.out.println("No solution");
//         }
//     }

//     private static boolean solveBoard(int[][] board, long startTime, int timeLimit) {
//         for (int i = 0; i < 9; i++) {
//             for (int j = 0; j < 9; j++) {
//                 if (board[i][j] == 0) {
//                     for (int num = 1; num <= 9; num++) {
//                         if (isValidBoard(board, num, i, j)) {
//                             board[i][j] = num;
//                             long elapsedTime = System.currentTimeMillis() - startTime;
//                             if (elapsedTime > timeLimit || solveBoard(board, startTime, timeLimit)) {
//                                 return true;
//                             }
//                             board[i][j] = 0; // backtrack
//                         }
//                     }
//                     return false;
//                 }
//             }
//         }
//         return true; // all cells filled
//     }

//     private static boolean isValidBoard(int[][] board, int num, int row, int col) {
//         return isValidRow(board, num, row) &&
//                isValidCol(board, num, col) &&
//                isValidBox(board, num, row, col);
//     }

//     private static boolean isValidRow(int[][] board, int num, int row) {
//         for (int i = 0; i < 9; i++) {
//             if (board[row][i] == num) {
//                 return false;
//             }
//         }
//         return true;
//     }

//     private static boolean isValidCol(int[][] board, int num, int col) {
//         for (int i = 0; i < 9; i++) {
//             if (board[i][col] == num) {
//                 return false;
//             }
//         }
//         return true;
//     }

//     private static boolean isValidBox(int[][] board, int num, int row, int col) {
//         int boxRowStart = row - row % 3;
//         int boxColStart = col - col % 3;
//         for (int i = boxRowStart; i < boxRowStart + 3; i++) {
//             for (int j = boxColStart; j < boxColStart + 3; j++) {
//                 if (board[i][j] == num) {
//                     return false;
//                 }
//             }
//         }
//         return true;
//     }

//     // Check if the board is completely filled
//     private static boolean isBoardFilled(int[][] board) {
//         for (int i = 0; i < 9; i++) {
//             for (int j = 0; j < 9; j++) {
//                 if (board[i][j] == 0) {
//                     return false;
//                 }
//             }
//         }
//         return true;
//     }

//     // Print the Sudoku board
//     private static void printBoard(int[][] board) {
//         for (int i = 0; i < 9; i++) {
//             for (int j = 0; j < 9; j++) {
//                 System.out.print(board[i][j] + " ");
//             }
//             System.out.println();
//         }
//     }
// }
