class Solution {
     val directions = arrayOf(
        intArrayOf(1, 0),
        intArrayOf(-1, 0),
        intArrayOf(0, 1),
        intArrayOf(0, -1)
    )
    fun solve(board: Array<CharArray>) {
        val rows = board.size
        val cols = board[0].size
        val queue:Queue<IntArray> = LinkedList<IntArray>()
        for (c in 0 until cols) {
            if(board[0][c] == 'O') {
                queue.add(intArrayOf(0,c))
            }
            if(board[rows - 1][c] == 'O') {
                queue.add(intArrayOf(rows - 1, c))
            }
        }
        for (r in 0 until rows) {
            if(board[r][0] == 'O') {
                queue.add(intArrayOf(r,0))
            } 
            if(board[r][cols-1] == 'O') {
                queue.add(intArrayOf(r, cols-1))
            }
        }
        System.out.println(queue)
        while(!queue.isEmpty()) {
            val (r,c) = queue.poll()
            board[r][c] = 'Z'
            for(dir in directions) {
                val newR = r + dir[0]
                val newC = c + dir[1]
                if(newR in 0 until rows && newC in 0 until cols && board[newR][newC] == 'O'){
                    board[r][c] = 'Z'
                    queue.add(intArrayOf(newR, newC))
                } 
            }
        }

        for(i in 0 until rows) {
            for(j in 0 until cols) {
                if(board[i][j] == 'O') {
                    board[i][j] = 'X'
                } else if(board[i][j] == 'Z'){
                    board[i][j] = 'O'
                }
            }
        }
    }
}
