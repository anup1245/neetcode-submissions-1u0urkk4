class Solution {
    fun islandsAndTreasure(grid: Array<IntArray>) {
        val rows = grid.size
        val cols = grid[0].size
        val queue: Queue<IntArray> = LinkedList()
        for (r in 0 until rows) {
            for (c in 0 until cols) {
                if(grid[r][c] ==0) {
                    queue.add(intArrayOf(r, c))
                }  
            }
        }

        while(!queue.isEmpty()) {
            val curr = queue.poll()
            val r = curr[0]
            val c = curr[1]
            if(r+1 < grid.size && grid[r+1][c] == 2147483647) {
                grid[r+1][c] = 1 + grid[r][c]
                queue.add(intArrayOf(r+1, c))
            }
            if(r-1 >= 0 && grid[r-1][c] == 2147483647) {
                grid[r-1][c] = 1+ grid[r][c]
                queue.add(intArrayOf(r-1, c))
            }
            if(c-1 >= 0 && grid[r][c-1] == 2147483647) {
                grid[r][c-1] = 1+ grid[r][c]
                queue.add(intArrayOf(r, c-1))
            }
            if(c+1 < grid[0].size && grid[r][c+1] == 2147483647) {
                grid[r][c+1] = 1+ grid[r][c]
                queue.add(intArrayOf(r, c+1))
            }

        }
    }
}
