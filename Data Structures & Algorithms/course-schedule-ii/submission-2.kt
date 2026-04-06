class Solution {
    fun findOrder(numCourses: Int, prerequisites: Array<IntArray>): IntArray {
        val map = HashMap<Int, ArrayList<Int>>()
        for((a,b) in prerequisites) {
            if(map.containsKey(a)) {
                map[a]?.add(b)
            } else {
                map[a] = ArrayList<Int>()
                map[a]?.add(b)
            }
        }
        val result = ArrayList<Int>();

        for(i in 0 until numCourses) {
            if(!map.containsKey(i)) {
                result.add(i);
            } 
        }

        val visited = BooleanArray(numCourses)
        for(i in 0 until numCourses) {
            if(cycle(i, map, visited, result)) {
                return intArrayOf()
            }
        }
        return result.toIntArray()
    }

    fun cycle(course:Int, map:HashMap<Int, ArrayList<Int>>, visisted: BooleanArray, result : ArrayList<Int>): Boolean {
        if(visisted[course]) {
            return true
        }

        if(!map.containsKey(course)) {
            return false
        } 
        if(map.get(course)?.isEmpty() == true) return false;

        visisted[course] = true
        var isCycle = false
        for(deps in map[course]!!) {
            if(cycle(deps, map, visisted, result)) {
                isCycle = true
            }
        }
        visisted[course] = false
        map[course]!!.clear()
        result.add(course);
        return isCycle
    }
}
