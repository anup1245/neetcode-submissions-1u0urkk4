class Solution {
    fun isPalindrome(s: String): Boolean {
        var i = 0
        var j = s.length - 1

        while (i < j) {
            while (i < s.length && !s[i].isLetterOrDigit()) i++
            while (j > 0 && !s[j].isLetterOrDigit()) j--

            if (i >= j) return true

            if (s[i].lowercaseChar() != s[j].lowercaseChar()) return false

            i++
            j--
        }
        return true
    }
}