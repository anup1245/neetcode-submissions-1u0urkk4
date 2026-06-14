class Solution {
    fun numIslands(grid: Array<CharArray>): Int {

        var islands = 0

        for(row in 0 until grid.size) {
            for(col in 0 until grid[0].size) {
                if(grid[row][col] == '1'){
                    dfs(grid, row, col)
                    islands++
                }
            }
        }
        return islands
    }

    fun dfs(grid: Array<CharArray>, i:Int, j:Int) {
        val rows = grid.size
        val cols = grid[0].size
        if(i<0 || i>= rows || j<0 || j>= cols || grid[i][j] == '0') {
            return
        }
        grid[i][j] = '0'
        dfs(grid, i+1, j)
        dfs(grid, i-1, j)
        dfs(grid, i, j+1)
        dfs(grid, i, j-1)
    }
}
