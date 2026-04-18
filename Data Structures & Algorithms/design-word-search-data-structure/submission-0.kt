class WordDictionary {
    val root = TrieNode()

    fun addWord(word: String) {
        var temp = root
        for (c in word) {
            temp = temp.map.getOrPut(c) { TrieNode() }
        }
        temp.isEnd = true
    }

    fun search(word: String): Boolean {
        return dfs(word, 0, root)
    }

    private fun dfs(word: String, index: Int, node: TrieNode): Boolean {
        if (index == word.length) return node.isEnd

        val c = word[index]

        if (c == '.') {
            // try every child
            for (child in node.map.keys) {
                if (dfs(word, index + 1, node.map[child]!!)) return true
            }
            return false
        } else {
            val next = node.map[c] ?: return false
            return dfs(word, index + 1, next)
        }
    }
}

class TrieNode {
    val map = HashMap<Char, TrieNode>()
    var isEnd = false
}