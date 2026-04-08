class Solution {
    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        val map = HashMap<Int, Int>()
        val pq = PriorityQueue<Int> { a, b -> map[a]!! - map[b]!! }
        val set = HashSet<Int>()
        for(num in nums) {
            map[num] = map.getOrPut(num){0}+1
            set.add(num)
        }

        for(num in set) {
            pq.add(num)
        }

        while(pq.size > k) {
            pq.poll()
        }

        return pq.toIntArray() 
    }
}
