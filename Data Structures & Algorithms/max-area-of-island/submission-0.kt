class Solution {
    fun maxAreaOfIsland(grid: Array<IntArray>): Int {
        var maxArea = 0
        val rows = grid.size
        val cols = grid[0].size

        for (r in 0 until rows) {
            for (c in 0 until cols) {
                if(grid[r][c] ==1) {
                    val area = dfs(grid, r, c)
                    maxArea = Math.max(area, maxArea)
                }  
            }
        }
        return maxArea
    }

    fun dfs(grid: Array<IntArray>, i: Int, j: Int):Int {
        if(i<0 || i>=grid.size || j < 0 || j >= grid[i].size) {
            return 0
        }
        
        if(grid[i][j] == 0) {
            return 0
        }
        var flip = 0
        if(grid[i][j] == 1) {
            grid[i][j] = 0
            flip = 1
        }

        return dfs(grid, i+1, j) + dfs(grid, i-1, j) + dfs(grid, i, j+1) + dfs(grid, i, j-1) + flip
        
        
        
    }
}
