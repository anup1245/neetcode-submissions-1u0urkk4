class Solution {
    fun validTree(n: Int, edges: Array<IntArray>): Boolean {
        // a tree must have exactly n-1 edges
        if (edges.size != n - 1) return false

        val map = HashMap<Int, ArrayList<Int>>()
        for (i in 0 until n) map[i] = ArrayList()

        for ((a, b) in edges) {
            map.getOrPut(a) { ArrayList() }.add(b)
            map.getOrPut(b) { ArrayList() }.add(a)  // undirected
        }

        val visited = BooleanArray(n)

        fun dfs(node: Int, parent: Int): Boolean {
            visited[node] = true
            for (neighbor in map[node] ?: emptyList()) {
                if (!visited[neighbor]) {
                    if (!dfs(neighbor, node)) return false
                } else if (neighbor != parent) {
                    return false  // cycle detected
                }
            }
            return true
        }

        // start dfs from node 0, -1 means no parent
        if (!dfs(0, -1)) return false

        // all nodes must be visited (connected)
        return visited.all { it }
    }
}