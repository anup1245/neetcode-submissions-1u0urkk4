class TrieNode {
    val children = HashMap<Char, TrieNode>()
    var word: String? = null // store the complete word at the end node
}

class Solution {
    fun findWords(board: Array<CharArray>, words: Array<String>): List<String> {
        val root = TrieNode()

        // build trie
        for (word in words) {
            var node = root
            for (c in word) {
                node = node.children.getOrPut(c) { TrieNode() }
            }
            node.word = word
        }

        val result = mutableListOf<String>()
        val rows = board.size
        val cols = board[0].size

        fun dfs(r: Int, c: Int, node: TrieNode) {
            if (r < 0 || r >= rows || c < 0 || c >= cols) return
            val ch = board[r][c]
            if (ch == '#') return // already visited

            val child = node.children[ch] ?: return

            // found a word
            child.word?.let {
                result.add(it)
                child.word = null // avoid duplicates
            }

            // mark visited
            board[r][c] = '#'

            dfs(r + 1, c, child)
            dfs(r - 1, c, child)
            dfs(r, c + 1, child)
            dfs(r, c - 1, child)

            // restore
            board[r][c] = ch

            // prune: remove leaf nodes to speed up future searches
            if (child.children.isEmpty()) {
                node.children.remove(ch)
            }
        }

        for (r in 0 until rows) {
            for (c in 0 until cols) {
                dfs(r, c, root)
            }
        }

        return result
    }
}