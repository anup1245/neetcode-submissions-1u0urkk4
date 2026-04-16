class Solution {
    fun isValidSudoku(board: Array<CharArray>): Boolean {
        val set = HashSet<String>()
        for (i in board.indices) {
            for (j in board[i].indices) {
                val c = board[i][j]
                if (c != '.') {
                    if (!set.add("${c}in row$i") ||
                        !set.add("${c}in col$j") ||
                        !set.add("${c}in grid${i / 3}-${j / 3}")) {
                        return false
                    }
                }
            }
        }
        return true
    }
}