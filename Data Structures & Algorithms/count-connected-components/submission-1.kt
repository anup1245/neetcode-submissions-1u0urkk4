class Solution {
    fun countComponents(n: Int, edges: Array<IntArray>): Int {
        val map = HashMap<Int, ArrayList<Int>>()
        for ((a, b) in edges) {
            if (map.containsKey(a)) map[a]?.add(b) else { map[a] = ArrayList(); map[a]?.add(b) }
            if (map.containsKey(b)) map[b]?.add(a) else { map[b] = ArrayList(); map[b]?.add(a) }  // ← missing
        }
        for(j in 0 until n) {
            if(!map.containsKey(j)) {
                map[j] = ArrayList<Int>()
            }
        }
        var result = 0
        val visited = BooleanArray(n)
        for(i in 0 until n) {
            if(!visited[i]) {
                cycle(i, map, visited)
                result++
            }
        }
        return result
    }

    fun cycle(course:Int, map:HashMap<Int, ArrayList<Int>>, visisted: BooleanArray) {
        visisted[course] = true
        for(deps in map[course]!!) {
            if(!visisted[deps]) {
                cycle(deps, map, visisted)
            }
        }
    }
}
