class Solution {
    fun setZeroes(matrix: Array<IntArray>) {
        var rows = HashSet<Int>()
        var cols = HashSet<Int>()
        for(i in 0 until matrix.size) {
            for(j in 0 until matrix[0].size){
                if(matrix[i][j] == 0) {
                    rows.add(i)
                    cols.add(j)
                }
            }
        }

        for(i in 0 until matrix.size) {
            for(j in 0 until matrix[0].size){
                if(rows.contains(i)||cols.contains(j)) {
                    matrix[i][j] = 0
                }
            }
        }


    }
}
