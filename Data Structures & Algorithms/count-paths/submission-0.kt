class Solution {
    fun uniquePaths(m: Int, n: Int): Int {
        var array = Array(m) { IntArray(n) {1}}

        for(i in 1 until m) {
            for (j in 1 until n) {
                array[i][j] = array[i][j-1]+array[i-1][j]
            }
        }
        return array[m-1][n-1]

    }
}
