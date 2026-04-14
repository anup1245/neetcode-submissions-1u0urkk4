class Solution {
    fun minEatingSpeed(piles: IntArray, h: Int): Int {
        var sum = 0
        for(pile in piles) {
            sum+=pile
        }
        var left = 1
        var right = piles.max()
        var result = 0
        while(left <= right) {
            var mid = left + (right - left) / 2
            if(check(piles,h, mid)){
                result = mid
                right = mid - 1
            } else {
                left = mid+1
            }
        }
        return result


    }

    fun check(piles: IntArray, h: Int, count: Int): Boolean {
        var total = 0
        for (pile in piles) {
            total += (pile + count - 1) / count
        }
    return total <= h
}
}
