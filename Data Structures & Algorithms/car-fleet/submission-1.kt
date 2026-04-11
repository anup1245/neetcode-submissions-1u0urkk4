class Solution {
    fun carFleet(target: Int, position: IntArray, speed: IntArray): Int {
        val pairs = ArrayList<Pair<Int,Int>>()
        for(i in 0 until position.size) {
            pairs.add(Pair(position[i], speed[i]))
        }
        pairs.sortBy { it.first }

        val stack = Stack<Float>()
        var fleet = 0
        for(i in pairs.size - 1 downTo 0) {
            if(stack.isEmpty()){
                val time = (target - pairs[i].first).toFloat() / pairs[i].second
                stack.push(time)
                fleet++
                continue
            }

            val time = (target - pairs[i].first).toFloat() / pairs[i].second
            if(time <= stack.peek()) {
                continue
            }

            if(time > stack.peek()) {
                stack.pop()
                fleet++
                stack.push(time)
            }

        }
        return fleet
    }
}
