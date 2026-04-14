class Solution {
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
         var left = 0
         var right = matrix.size-1

         while(left <= right) {
            var mid = left + (right - left) / 2
            if(matrix[mid][0] == target) {
                return true
            } else if(target < matrix[mid][0]) {
                right = mid-1
            } else {
                left = mid+1
            }
         }
        
         if(right < 0) return false
         var row = right
         left = 0
         right = matrix[0].size-1
         while(left <= right) {
            var mid = left + (right - left) / 2
            if(matrix[row][mid] == target) {
                return true
            } else if(target < matrix[row][mid]) {
                right = mid-1
            } else {
                left = mid+1
            }
         }
         return false
    }
}
