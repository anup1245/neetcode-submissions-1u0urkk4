class Solution {
    fun countSubstrings(s: String): Int {
        var count =0
        for (i in s.indices) {
            for (j in i + 1..s.length) {
                val sub = s.substring(i, j)
                if (sub == sub.reversed()) {
                    count++
                }
            }
        }
        return count
    }
}
