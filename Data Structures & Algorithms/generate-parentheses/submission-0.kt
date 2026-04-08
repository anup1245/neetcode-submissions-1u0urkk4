class Solution {
    fun generateParenthesis(n: Int): List<String> {
        val list = mutableListOf<String>()
        val sb = StringBuilder()
        backtrack(sb, list, n, n)
        return list
    }

    fun backtrack(sb: StringBuilder, list: MutableList<String>, open:Int, close:Int) {
        if(open == 0 && close == 0){
            list.add(sb.toString())
            return
        }

        if(open > 0){
            sb.append("(")
            backtrack(sb, list, open - 1, close)
            sb.deleteCharAt(sb.length-1);
        }

        if(close > open){
            sb.append(")")
            backtrack(sb, list, open, close-1)
            sb.deleteCharAt(sb.length-1);
        }
    }
}
