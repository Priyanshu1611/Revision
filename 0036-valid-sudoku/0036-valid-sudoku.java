import java.util.Arrays;

class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[] row = new int[10];

        // rows
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c == '.') continue;
                int num = c - '0';
                if (row[num] > 0) return false; // was > 1
                row[num]++;
            }
            Arrays.fill(row, 0);
        }

        // columns
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[j][i];
                if (c == '.') continue;
                int num = c - '0';
                if (row[num] > 0) return false; // was > 1
                row[num]++;
            }
            Arrays.fill(row, 0);
        }

        // 3x3 boxes
        for (int l = 0; l < 9; l += 3) {        // box row start: 0,3,6
            for (int r = 0; r < 9; r += 3) {    // box col start: 0,3,6
                for (int i = l; i < l + 3; i++) {
                    for (int j = r; j < r + 3; j++) {
                        char c = board[i][j];
                        if (c == '.') continue;
                        int num = c - '0';
                        if (row[num] > 0) return false; // was > 1
                        row[num]++;
                    }
                }
                Arrays.fill(row, 0);
            }
        }

        return true;
    }
}
