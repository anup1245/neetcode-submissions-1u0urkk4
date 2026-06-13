class Solution {
    fun maxProfit(prices: IntArray): Int {
        var max = 0
        var curr = prices[0]
        for(price in prices) {
            if(price < curr) {
                curr = price
                continue
            } else {
                max = Math.max(max, price - curr)
            }
        }
        return max
    }
}
