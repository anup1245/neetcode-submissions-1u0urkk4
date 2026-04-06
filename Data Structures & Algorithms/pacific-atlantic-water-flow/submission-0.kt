class Solution {
    val directions = arrayOf(intArrayOf(1, 0),
                                 intArrayOf(-1, 0),
                                 intArrayOf(0, 1),
                                 intArrayOf(0, -1))
    fun pacificAtlantic(heights: Array<IntArray>): List<List<Int>> {
        val rows = heights.size
        val cols = heights[0].size
        
                            
        val pacific = Array(rows) { BooleanArray(cols) }
        val atlantic = Array(rows) { BooleanArray(cols) }

        val pac = mutableListOf<IntArray>()
        val atl = mutableListOf<IntArray>()

        
        
        for (c in 0 until cols) {
            pac.add(intArrayOf(0, c))
            atl.add(intArrayOf(rows - 1, c))
        }
        for (r in 0 until rows) {
            pac.add(intArrayOf(r, 0))
            atl.add(intArrayOf(r, cols - 1))
        }

        fun bfs(source: List<IntArray>, ocean: Array<BooleanArray>) {
        val queue:Queue<IntArray> = LinkedList<IntArray>()
        queue.addAll(source) 
        while(queue.isNotEmpty()) {
            val (r, c) = queue.poll()
            ocean[r][c] = true
            for(dir in directions) {
                val newR = r + dir[0]
                val newC = c + dir[1]

                if(newR in 0 until rows && newC in 0 until cols && !ocean[newR][newC] && heights[newR][newC] >= heights[r][c]) {
                    queue.offer(intArrayOf(newR, newC))
                }
            }
        }
    }

        bfs(pac, pacific)
        bfs(atl, atlantic)

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
