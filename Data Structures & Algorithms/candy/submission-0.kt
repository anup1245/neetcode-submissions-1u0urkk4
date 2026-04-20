class Solution {
    fun candy(ratings: IntArray): Int {
        var array = IntArray(ratings.size) {1}

        for(i in 1 until ratings.size){
            if(ratings[i] > ratings[i-1]){
                array[i] = array[i-1]+1
            }
        }

        for(i in ratings.size-2 downTo 0){
            if(ratings[i] > ratings[i+1]){
                array[i] = maxOf(array[i], array[i+1]+1)
            }
        }

        var sum = 0
        for(i in 0 until ratings.size){
            sum+=array[i]
        }
        return sum
    }
}
