class Solution {
    fun isHappy(n: Int): Boolean {
        val set = HashSet<Int>()
        var sum = getList(n)
        System.out.println(sum)
        while(true) {
            if(set.contains(sum)) {
                return false
            } else if(sum == 1) {
                return true
            } else {
                set.add(sum)
            }
            sum = getList(sum)
        }
        return true

    }

    fun getList(n:Int):Int {
        var sum = 0
        var value = n
        while(value>0) {
            val a = value%10
            sum+= a*a
            value = value/10
        }
        return sum
    }
}
