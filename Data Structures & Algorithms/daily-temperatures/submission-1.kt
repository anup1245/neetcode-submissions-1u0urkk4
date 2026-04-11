class Solution {
    fun dailyTemperatures(temp: IntArray): IntArray {
        val stack = Stack<Int>()
        val result = IntArray(temp.size)
        result[temp.size - 1] = 0
        stack.push(temp.size - 1)
        for(i in temp.size - 2 downTo 0) {
            while(!stack.isEmpty() && temp[i] >= temp[stack.peek()]) {
                stack.pop()
            }
            if(stack.isEmpty()) {
                result[i] = 0
            } else {
                result[i] = stack.peek() - i
            }
            stack.push(i)
        }
        return result
    }
}
