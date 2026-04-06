class Solution {
    fun ladderLength(beginWord: String, endWord: String, wordList: MutableList<String>): Int {
        val map = HashMap<String, ArrayList<String>>()
        val visited = HashSet<String>()
        if (endWord !in wordList) return 0 
        visited.add(beginWord)

        for(word in wordList) {
            for(c in 0 until word.length) {
                val temp = word.substring(0,c)+"*"+word.substring(c+1);
                if(map.containsKey(temp)) {
                    map[temp]?.add(word)
                } else {
                    map[temp] = ArrayList<String>()
                    map[temp]?.add(word)
                }
            }
        }
        
        val q: Queue<String> = LinkedList<String>()
        q.add(beginWord)
        var res = 1
        while(q.isNotEmpty()) {
            val size = q.size;
            for(i in 0 until size) {
                val word = q.poll()
                if(word == endWord) {
                    return res
                }
                for(j in 0 until word.length) {
                    val temp = word.substring(0,j)+"*"+word.substring(j+1);
                    for(n in map[temp]?:emptyList()) {
                        if(!visited.contains(n)) {
                            visited.add(n)
                            q.add(n)
                    
                        }
                    }
                }
            }
            res++
        }

        return 0
    }
}
