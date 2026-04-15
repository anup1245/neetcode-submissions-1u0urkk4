class Solution {
    fun coinChange(coins: IntArray, amount: Int): Int {
       val array = IntArray(amount + 1) { amount + 1 }
       array[0] = 0

        for(i in 1 until amount+1) {
            for(coin in coins) {
                if(coin <= i) {
                    array[i] = minOf(array[i], array[i-coin] + 1)
                }
            }
        }
        return if (array[amount] > amount) -1 else array[amount]
    }
}
