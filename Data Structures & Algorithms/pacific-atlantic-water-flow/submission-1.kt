class Solution {
    val directions = arrayOf(
        intArrayOf(1, 0),
        intArrayOf(-1, 0),
        intArrayOf(0, 1),
        intArrayOf(0, -1)
    )

    fun pacificAtlantic(heights: Array<IntArray>): List<List<Int>> {
        val rows = heights.size
        val cols = heights[0].size

        val pacific = Array(rows) { BooleanArray(cols) }
        val atlantic = Array(rows) { BooleanArray(cols) }

        fun dfs(r: Int, c: Int, ocean: Array<BooleanArray>) {
            ocean[r][c] = true
            for (dir in directions) {
                val newR = r + dir[0]
                val newC = c + dir[1]
                if (newR in 0 until rows && newC in 0 until cols
                    && !ocean[newR][newC]
                    && heights[newR][newC] >= heights[r][c]
                ) {
                    dfs(newR, newC, ocean)
                }
            }
        }

        // seed edges
        for (c in 0 until cols) {
            dfs(0, c, pacific)
            dfs(rows - 1, c, atlantic)
        }
        for (r in 0 until rows) {
            dfs(r, 0, pacific)
            dfs(r, cols - 1, atlantic)
        }

        val result = mutableListOf<List<Int>>()
        for (r in 0 until rows) {
            for (c in 0 until cols) {
                if (pacific[r][c] && atlantic[r][c]) {
                    result.add(listOf(r, c))
                }
            }
        }
        return result
    }
}