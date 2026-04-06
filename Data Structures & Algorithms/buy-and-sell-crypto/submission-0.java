class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int result = 0;
        for(int i=0; i<prices.length; i++) {
            minPrice = Math.min(minPrice, prices[i]);
            result = Math.max(result, prices[i]-minPrice);
        }
        return result;
    }
}