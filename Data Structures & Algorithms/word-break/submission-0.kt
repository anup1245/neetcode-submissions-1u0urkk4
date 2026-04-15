class Solution {
    fun wordBreak(s: String, wordDict: List<String>): Boolean {
        val array = BooleanArray(s.length + 1)
        array[s.length] = true

        val set = HashSet<String>(wordDict)

        for (i in s.length - 1 downTo 0) {
            for (word in wordDict) {
                if (i + word.length <= s.length && s.substring(i, i + word.length) == word) {
                    array[i] = array[i + word.length]
                }
                if (array[i]) break
            }
        }
        return array[0]
    }
}