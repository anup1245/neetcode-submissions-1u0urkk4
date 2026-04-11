class MinStack() {

    val stack = Stack<Int>()
    val min = Stack<Int>()

    fun push(value: Int) {
        stack.push(value)
        if(min.isEmpty() || min.peek() >= value) {
            min.push(value)
        } 
    }

    fun pop() {
        val temp = stack.pop()
        if(temp == min.peek()) {
            min.pop()
        }
    }

    fun top(): Int {
       return if(!stack.isEmpty()) stack.peek() else 0
    }

    fun getMin(): Int {
        return min.peek()
    }
}
