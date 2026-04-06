class Solution {
    fun findRedundantConnection(edges: Array<IntArray>): IntArray {
        val n = edges.size
        val parent = IntArray(n + 1) { it }  
        val rank = IntArray(n + 1) { 0 }

        fun find(x: Int): Int {
            if (parent[x] == x) {
                return x
            }
            parent[x] = find(parent[x]) 
            return parent[x]
        }

        fun union(x: Int, y: Int): Boolean {
            val px = find(x)
            val py = find(y)

            if (px == py) return false  // same root = cycle!

            // union by rank
            if (rank[px] > rank[py]) parent[py] = px
            else if (rank[px] < rank[py]) parent[px] = py
            else {
                parent[py] = px
                rank[px]++
            }
            return true
        }

        for ((a, b) in edges) {
            if (!union(a, b)) return intArrayOf(a, b)  // union failed = redundant edge
        }
        return intArrayOf()
    }

}
