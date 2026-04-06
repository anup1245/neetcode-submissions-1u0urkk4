class Solution {
    fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
        val map = HashMap<Int, ArrayList<Int>>()
        for((a,b) in prerequisites) {
            if(map.containsKey(a)) {
                map[a]?.add(b)
            } else {
                map[a] = ArrayList<Int>()
                map[a]?.add(b)
            }
        }

        for(j in 0 until numCourses) {
            if(!map.containsKey(j)) {
                map[j] = ArrayList<Int>()
            }
        }

        val visited = BooleanArray(numCourses)
        for(i in 0 until numCourses) {
            if(cycle(i, map, visited)) {
                return false
            }
        }
        return true
    }

    fun cycle(course:Int, map:HashMap<Int, ArrayList<Int>>, visisted: BooleanArray): Boolean {
        if(visisted[course]) {
            return true
        }

        visisted[course] = true
        var isCycle = false
        for(deps in map[course]!!) {
            if(cycle(deps, map, visisted)) {
                isCycle = true
                break
            }
        }
        visisted[course] = false
        map[course]!!.clear()
        return isCycle
    }
}
