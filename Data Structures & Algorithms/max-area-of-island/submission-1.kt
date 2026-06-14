class Solution {
    fun maxAreaOfIsland(grid: Array<IntArray>): Int {
        var islands = 0

        for(row in 0 until grid.size) {
            for(col in 0 until grid[0].size) {
                if(grid[row][col] == 1){
                    val max = dfs(grid, row, col)
                    islands = Math.max(islands, max)
                }
            }
        }
        return islands
    }

    fun dfs(grid: Array<IntArray>, i:Int, j:Int): Int {
        val rows = grid.size
        val cols = grid[0].size
        if(i<0 || i>= rows || j<0 || j>= cols || grid[i][j] == 0) {
            return 0
        }
        grid[i][j] = 0
        return dfs(grid, i+1, j) + dfs(grid, i-1, j) + dfs(grid, i, j+1) + dfs(grid, i, j-1) +1
    }
}
