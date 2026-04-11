class Solution {
    fun isValid(s: String): Boolean {
        val stack = Stack<Char>() 
        for(c in s) {
            if(c == '{' || c == '[' || c == '(') {
                stack.push(c)
                continue
            }
            if(c == ']' || c == '}' || c == ')') {
                if(stack.isEmpty()) {
                    return false
                }
            }
            if(c == '}') {
                val temp = stack.pop()
                if(temp == '{') {
                    continue
                } else {
                    return false
                }
            }
            if(c == ')') {
                val temp = stack.pop()
                if(temp == '(') {
                    continue
                } else {
                    return false
                }
            }
            if(c == ']') {
                val temp = stack.pop()
                if(temp == '[') {
                    continue
                } else {
                    return false
                }
            }

        }
        return stack.isEmpty()
    }
}
