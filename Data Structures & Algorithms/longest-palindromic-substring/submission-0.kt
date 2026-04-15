class Solution {
    fun longestPalindrome(s: String): String {
        var l = 0
        var r = 0
        var result = ""

        for(i in 0 until s.length) {
            l=i
            r=i
            while(l>=0 && r < s.length && s[l] == s[r]){
                if(r - l +1 > result.length) {
                    result = s.substring(l, r+1)
                }
                l--
                r++
            }
        }
        

        for(i in 0 until s.length) {
            l=i
            r=i+1
            while(l>=0 && r < s.length && s[l] == s[r]){
                if(r - l +1 > result.length) {
                    result = s.substring(l, r+1)
                }
                l--
                r++
            }
        }
        return result

    }
}
