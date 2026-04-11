class Solution {
    fun largestRectangleArea(heights: IntArray): Int {
        val stack = Stack<Pair<Int, Int>>()
        var max = 0

        for(i in 0 until heights.size) {
            var start = i
            while(!stack.isEmpty() && stack.peek().first > heights[i]) {
                val temp = stack.pop()
                max = maxOf(max, (i - temp.second) * temp.first)
                start = temp.second
            }
            stack.push(Pair(heights[i], start))
        }

        while(!stack.isEmpty()) {
            val temp = stack.pop()
            max = maxOf(max, (heights.size - temp.second) * temp.first)
        }
        return max
    }
}
