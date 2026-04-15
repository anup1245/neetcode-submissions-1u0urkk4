class Solution {
    fun climbStairs(n: Int): Int {
        if(n<=2) {
            return n
        }

        val array = ArrayList<Int>()
        array.add(1)
        array.add(2)
        for(i in 2 until n) {
           val first = array.get(i-1)
           val second = array.get(i-2)
           array.add(first+second)
        }
        return array.get(array.size -1)
    }
}
