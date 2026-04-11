class Solution {
    fun evalRPN(tokens: Array<String>): Int {
        val stack = Stack<Int>()
        var result = 0

        for(s in tokens) {
            if(s == "*" || s == "+" || s == "/" || s == "-") {
                val a = stack.pop()
                val b = stack.pop()
                if(s == "*") {
                    stack.push(a*b)
                } else if(s == "+") {
                    stack.push(a+b) 
                } else if(s == "-") {
                    stack.push(b-a) 
                } else {
                    stack.push(b/a) 
                }
            } else {
                stack.push(Integer.parseInt(s))
            }
        }
        return stack.pop()
    }
}
