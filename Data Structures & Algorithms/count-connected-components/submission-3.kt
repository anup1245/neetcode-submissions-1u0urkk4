class Solution {
    fun countComponents(n: Int, edges: Array<IntArray>): Int {
        val parent = IntArray(n) { it }   // ← n nodes, not edges.size
        val rank = IntArray(n) { 1 }

        fun find(x: Int): Int {
            if (parent[x] == x) return x
            parent[x] = find(parent[x])
            return parent[x]
        }

        fun union(x: Int, y: Int): Boolean {
            val px = find(x)
            val py = find(y)
            if (px == py) return false
            if (rank[px] > rank[py]) {
                parent[py] = px
                rank[px] += rank[py]
            } else {
                parent[px] = py
                rank[py] += rank[px]
            }
            return true
        }

        var component = n  // start with n components
        for ((a, b) in edges) {
            if (union(a, b)) component--  // each successful union reduces by 1
        }
        var components = 0
        for (i in 0 until n) {
            if (parent[i] == i) components++
        }
        return components
    }
}