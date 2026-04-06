class Solution {
    fun validTree(n: Int, edges: Array<IntArray>): Boolean {
        // a valid tree must have exactly n-1 edges
        // too few = disconnected, too many = cycle
        if (edges.size != n - 1) return false

        val map = HashMap<Int, ArrayList<Int>>()
        for ((a, b) in edges) {
            map.getOrPut(a) { ArrayList() }.add(b)
            map.getOrPut(b) { ArrayList() }.add(a)
        }
        for (j in 0 until n) {
            if (!map.containsKey(j)) map[j] = ArrayList()
        }

        val visited = BooleanArray(n)
        dfs(0, map, visited)

        // all nodes must be reachable from node 0
        return visited.all { it }
    }

    fun dfs(node: Int, map: HashMap<Int, ArrayList<Int>>, visited: BooleanArray) {
        visited[node] = true
        for (neighbor in map[node]!!) {
            if (!visited[neighbor]) {
                dfs(neighbor, map, visited)
            }
        }
    }
}