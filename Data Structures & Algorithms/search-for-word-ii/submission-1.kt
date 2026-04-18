class Solution {
    fun findWords(board: Array<CharArray>, words: Array<String>): List<String> {
        val root = TrieNode()

        for(word in words) {
            var temp = root
            for (c in word) {
                temp.map.getOrPut(c) {TrieNode()}
                temp = temp.map[c]!!
            }
            temp.word = word
        }
        val list = ArrayList<String>()
        var r = board.size
        var c = board[0].size

        for(i in 0 until r) {
            for(j in 0 until c) {
                if(root.map.contains(board[i][j])){
                    dfs(i,j, r, c,board, list, root)
                }
            }
        }

        return list
    }

    fun dfs(i: Int, j: Int, r: Int, c: Int, board: Array<CharArray>, list:ArrayList<String>, root:TrieNode) {
        if (i < 0 || i >= r || j < 0 || j >= c) return
        val ch = board[i][j]
        if(ch == '#') return
        if (ch == '#') return
        val node = root.map[ch] ?: return
        

        node.word?.let {
            list.add(it)
            node.word = null
        }

        board[i][j] = '#'
        dfs(i + 1, j,r,c, board, list, node)
        dfs(i - 1, j, r,c,board, list, node)
        dfs(i, j + 1, r,c,board, list, node)
        dfs(i, j - 1, r,c,board, list, node)
        board[i][j] = ch

        if(node.map.isEmpty()) {
            root.map.remove(ch)
        }
    }
}

class TrieNode {
    val map = HashMap<Char, TrieNode>()
    var word: String? = null
}
