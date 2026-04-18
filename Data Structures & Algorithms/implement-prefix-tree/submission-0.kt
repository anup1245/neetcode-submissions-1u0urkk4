class PrefixTree {

    val root = TrieNode()

    fun insert(word: String) {
        var temp: TrieNode = root
        for (c in word) {
            if (temp.map.contains(c)) {
                temp = temp.map[c]!!
                continue
            } else {
                val newNode = TrieNode()
                temp.map[c] = newNode
                temp = newNode
            }
        }
        temp.isEnd = true

    }

    fun search(word: String): Boolean {
        var temp: TrieNode = root
        for (c in word) {
           if (temp.map.contains(c)) {
                temp = temp.map[c]!!
                continue
            } else {
                return false
            } 
        }
        return temp.isEnd
    }

    fun startsWith(prefix: String): Boolean {
        var temp: TrieNode = root
        for (c in prefix) {
           if (temp.map.contains(c)) {
                temp = temp.map[c]!!
                continue
            } else {
                return false
            } 
        }
        return true
    }
}

class TrieNode() {
    val map = HashMap<Char,TrieNode>()
    var isEnd = false
}
