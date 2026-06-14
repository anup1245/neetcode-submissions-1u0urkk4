class Solution {
    fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
        val map = HashMap<Int, ArrayList<Int>>()


        for(course in prerequisites) {
            val before = course[1]
            val start = course[0]
            map[start] = map.getOrDefault(start, ArrayList<Int>()).also {it.add(before)}
        }

        for(course in 0 until numCourses) {
            map[course] = map.getOrDefault(course, ArrayList<Int>())
        }
        val visited = BooleanArray(numCourses)
        for(course in 0 until numCourses) {
            if(cycle(map, course, visited)) {
                return false
            }
        }
        return true

    }


    fun cycle(map: HashMap<Int, ArrayList<Int>>, course:Int, visited: BooleanArray) : Boolean {
        if(map[course]!!.isEmpty()){
            return false
        }
        if(visited[course]){
            return true
        }
        visited[course] = true
        var isCycle = false
        for(c in map[course]!!) {
            if(cycle(map, c, visited)){
                isCycle = true
                break
            }
        }
        map[course]!!.clear()
        return isCycle
    }
}
