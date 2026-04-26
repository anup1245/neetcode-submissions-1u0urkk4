class Solution {
    fun climbStairs(n: Int): Int {
        val array = IntArray(n) {0}
        if(n == 1) {
            return 1
        }

        if(n==2) {
            return 2
        }
        array[0] = 1
        array[1] = 2
        for(i in 2 until n) {
            array[i] = array[i-1]+array[i-2]
        }
        return array[n-1]

    }
}
