public class ValidSudoKu {
    public static boolean isValidSudoku(char[][] board) {
        int[][] intBoard = new int[9][9];
        
        // Convert character board to integer board
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (Character.isDigit(board[i][j])) {
                    intBoard[i][j] = Character.getNumericValue(board[i][j]);
                } else if (board[i][j] == '.') {
                    intBoard[i][j] = 0;
                }
            }
        }

        // Validate the board
        return SolveBoard(intBoard);
    }

    public static boolean isValidRow(int[][] board, int row, int num) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == num) {
                return false;
            }
        }
        return true;
    }

    public static boolean isValidCol(int[][] board, int col, int num) {
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == num) {
                return false;
            }
        }
        return true;
    }

    public static boolean isValidBox(int[][] board, int row, int col, int num) {
        int box_row = row - row % 3;
        int box_col = col - col % 3;
        for (int i = box_row; i < box_row + 3; i++) {
            for (int j = box_col; j < box_col + 3; j++) {
                if (board[i][j] == num) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isValidBoard(int[][] board, int row, int col, int num) {
        return isValidBox(board, row, col, num) && isValidRow(board, row, num) && isValidCol(board, col, num);
    }

    public static boolean SolveBoard(int[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != 0) {
                    int num = board[i][j];
                    board[i][j] = 0;  // Temporarily remove the number to check for validity
                    if (!isValidBoard(board, i, j, num)) {
                        return false;
                    }
                    board[i][j] = num;  // Put the number back
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        
        // Sample Sudoku board
        char[][] board = {
            {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
            {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
            {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
            {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
            {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
            {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
            {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
            {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
            {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        
        
        System.out.println(isValidSudoku(board));
    }
}
