class Solution {
    fun findOrder(numCourses: Int, prerequisites: Array<IntArray>): IntArray {
        val map = HashMap<Int, ArrayList<Int>>()
        val result = ArrayList<Int>()
        for(course in prerequisites) {
            val before = course[1]
            val start = course[0]
            map[start] = map.getOrDefault(start, ArrayList<Int>()).also {it.add(before)}
        }

        for(course in 0 until numCourses) {
            if(!map.containsKey(course)) {
                result.add(course)
            }
        }
        val visited = BooleanArray(numCourses)
        for(course in 0 until numCourses) {
            if(cycle(map, course, visited, result)) {
                return intArrayOf()
            }
        }
        return result.toIntArray()

    }


    fun cycle(map: HashMap<Int, ArrayList<Int>>, course:Int, visited: BooleanArray, result:ArrayList<Int>) : Boolean {
        
        if(!map.containsKey(course)) {
            return false
        }
        
        if(map[course]!!.isEmpty()){
            return false
        }
        if(visited[course]){
            return true
        }
        visited[course] = true
        var isCycle = false
        for(c in map[course]!!) {
            if(cycle(map, c, visited, result)){
                isCycle = true
                break
            }
        }
        visited[course] = false
        map[course]!!.clear()
        result.add(course)
        return isCycle
    }
}
