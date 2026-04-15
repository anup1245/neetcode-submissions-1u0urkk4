class Solution {
    fun longestCommonSubsequence(text1: String, text2: String): Int {

        var array = Array(text1.length + 1) {
            IntArray(text2.length+1) {0}
        }

        for(i in text1.length - 1 downTo 0) {
            for(j in text2.length - 1 downTo 0) {
                if(text1[i]==text2[j]) {
                    array[i][j] = array[i+1][j+1] + 1
                } else {
                    array[i][j] = maxOf(array[i][j+1], array[i+1][j])
                }
            }
        }
        return array[0][0]
    }
}
