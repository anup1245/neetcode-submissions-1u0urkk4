class Solution {
    fun ladderLength(beginWord: String, endWord: String, wordList: MutableList<String>): Int {
        if (endWord !in wordList) return 0

        val wordToPatterns = HashMap<String, ArrayList<String>>()
        val patternToWords = HashMap<String, ArrayList<String>>()

        for (word in wordList + beginWord) {
            for (c in 0 until word.length) {
                val pattern = word.substring(0, c) + "*" + word.substring(c + 1)
                wordToPatterns.getOrPut(word) { ArrayList() }.add(pattern)
                patternToWords.getOrPut(pattern) { ArrayList() }.add(word)
            }
        }

        val visited = HashSet<String>()
        visited.add(beginWord)

        val q: Queue<String> = LinkedList()
        q.add(beginWord)
        var res = 1

        while (q.isNotEmpty()) {
            val size = q.size
            for (i in 0 until size) {
                val word = q.poll()
                if (word == endWord) return res

                // word → patterns → neighbors
                for (pattern in wordToPatterns[word] ?: emptyList()) {
                    for (neighbor in patternToWords[pattern] ?: emptyList()) {
                        if (!visited.contains(neighbor)) {
                            visited.add(neighbor)
                            q.add(neighbor)
                        }
                    }
                }
            }
            res++
        }

        return 0
    }
}