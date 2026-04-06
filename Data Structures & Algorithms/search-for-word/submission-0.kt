class Solution {
    var R = 0
    var C = 0
    lateinit var visited: Array<BooleanArray>
    val dirs = arrayOf(intArrayOf(1,0), intArrayOf(-1,0), intArrayOf(0,1), intArrayOf(0,-1))

    fun exist(board: Array<CharArray>, word: String): Boolean {
        R = board.size
        C = board[0].size
        visited = Array(R) { BooleanArray(C) }

        for (i in 0 until R) {
            for (j in 0 until C) {
                if (board[i][j] == word[0]) {
                    if (dfs(board, i, j, word, 0)) return true
                }
            }
        }
        return false
    }

    fun dfs(board: Array<CharArray>, r: Int, c: Int, word: String, index: Int): Boolean {
        if (index >= word.length) return true
        if (r < 0 || r >= R || c < 0 || c >= C) return false
        if (board[r][c] != word[index] || visited[r][c]) return false

        visited[r][c] = true
        for (d in dirs) {
            if (dfs(board, r + d[0], c + d[1], word, index + 1)) return true
        }
        visited[r][c] = false  // backtrack
        return false
    }
}