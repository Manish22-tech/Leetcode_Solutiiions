class Solution {
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0 || word == null || word.length() == 0)
            return false;

        int m = board.length;
        int n = board[0].length;

        // Iterate through each cell in the grid
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // If the first character of the word matches the current cell
                if (board[i][j] == word.charAt(0)) {
                    // Start DFS from this cell
                    if (dfs(board, word, i, j, 0))
                        return true;
                }
            }
        }

        // If the word cannot be found after exploring all cells
        return false;
    }

    private boolean dfs(char[][] board, String word, int i, int j, int index) {
        // If the entire word has been matched
        if (index == word.length())
            return true;

        // If the current cell is out of bounds or doesn't match the current character
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(index))
            return false;

        // Mark the current cell as visited by changing its character temporarily
        char temp = board[i][j];
        board[i][j] = '*';

        // Explore adjacent cells in all four directions
        boolean found = dfs(board, word, i + 1, j, index + 1) ||
                       dfs(board, word, i - 1, j, index + 1) ||
                       dfs(board, word, i, j + 1, index + 1) ||
                       dfs(board, word, i, j - 1, index + 1);

        // Restore the character of the current cell
        board[i][j] = temp;

        return found;
    }
}
