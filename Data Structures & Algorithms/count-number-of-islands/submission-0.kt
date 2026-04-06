class Solution {
    fun numIslands(grid: Array<CharArray>): Int {
        var islands = 0
        val rows = grid.size
        val cols = grid[0].size

        for (r in 0 until rows) {
            for (c in 0 until cols) {
                if(grid[r][c] =='1') {
                    dfs(grid, r, c)
                    islands++
                }  
            }
        }
        return islands
    }

    fun dfs(grid: Array<CharArray>, i: Int, j: Int) {
        if(i<0 || i>=grid.size || j < 0 || j >= grid[i].size) {
            return
        }
        
        if(grid[i][j] == '0') {
            return
        }

        if(grid[i][j] == '1') {
            grid[i][j] = '0'
        }

        dfs(grid, i+1, j)
        dfs(grid, i-1, j)
        dfs(grid, i, j+1)
        dfs(grid, i, j-1)
    }
}
