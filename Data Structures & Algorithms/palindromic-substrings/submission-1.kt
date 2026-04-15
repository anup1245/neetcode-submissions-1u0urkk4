class Solution {
    fun countSubstrings(s: String): Int {
         var l = 0
        var r = 0
        var result = 0

        for(i in 0 until s.length) {
            l=i
            r=i
            while(l>=0 && r < s.length && s[l] == s[r]){
                result++
                l--
                r++
            }
        }
        

        for(i in 0 until s.length) {
            l=i
            r=i+1
            while(l>=0 && r < s.length && s[l] == s[r]){
                result++
                l--
                r++
            }
        }
        return result
    }
}
