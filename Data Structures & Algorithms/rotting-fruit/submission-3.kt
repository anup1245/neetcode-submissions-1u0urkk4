class Solution {
    fun orangesRotting(grid: Array<IntArray>): Int {
        val rows = grid.size
        val cols = grid[0].size
        val queue: Queue<IntArray> = LinkedList()
        val visited = Array(rows) { BooleanArray(cols) }
        for (r in 0 until rows) {
            for (c in 0 until cols) {
                if(grid[r][c] ==2) {
                    visited[r][c] = true
                    queue.add(intArrayOf(r, c))
                    grid[r][c] = 0
                }  
            }
        }
        while(!queue.isEmpty()) {
            val curr = queue.poll()
            val r = curr[0]
            val c = curr[1]
            if(r+1 < grid.size && grid[r+1][c] == 1 && visited[r+1][c] == false) {
                visited[r+1][c] = true
                grid[r+1][c] = 1 + grid[r][c]
                queue.add(intArrayOf(r+1, c))
            }
            if(r-1 >= 0 && grid[r-1][c] == 1 && visited[r-1][c] == false) {
                visited[r-1][c] = true
                grid[r-1][c] = 1+ grid[r][c]
                queue.add(intArrayOf(r-1, c))
            }
            if(c-1 >= 0 && grid[r][c-1] == 1 && visited[r][c-1] == false) {
                visited[r][c-1] = true
                grid[r][c-1] = 1+ grid[r][c]
                queue.add(intArrayOf(r, c-1))
            }
            if(c+1 < grid[0].size && grid[r][c+1] == 1 && visited[r][c+1] == false) {
                visited[r][c+1] = true
                grid[r][c+1] = 1+ grid[r][c]
                queue.add(intArrayOf(r, c+1))
            }
        }
        var time = 0
        for (r in 0 until rows) {
            for (c in 0 until cols) {
                if(visited[r][c] == false && grid[r][c] == 1) {
                    return -1
                }  
                time = Math.max(time, grid[r][c])
            }
        }
        return time
    }
}
