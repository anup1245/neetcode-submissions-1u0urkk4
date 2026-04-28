class Solution {
    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        // Always binary search on the smaller array
        if (nums1.size > nums2.size) return findMedianSortedArrays(nums2, nums1)

        val m = nums1.size
        val n = nums2.size
        val half = (m + n + 1) / 2  // size of combined left half

        var lo = 0
        var hi = m

        while (lo <= hi) {
            val partitionX = (lo + hi) / 2
            val partitionY = half - partitionX

            val L1 = if (partitionX == 0) Int.MIN_VALUE else nums1[partitionX - 1]
            val R1 = if (partitionX == m) Int.MAX_VALUE else nums1[partitionX]
            val L2 = if (partitionY == 0) Int.MIN_VALUE else nums2[partitionY - 1]
            val R2 = if (partitionY == n) Int.MAX_VALUE else nums2[partitionY]

            if (L1 <= R2 && L2 <= R1) {
                // Found the correct partition
                return if ((m + n) % 2 == 1) {
                    maxOf(L1, L2).toDouble()
                } else {
                    (maxOf(L1, L2) + minOf(R1, R2)) / 2.0
                }
            } else if (L1 > R2) {
                hi = partitionX - 1  // go left
            } else {
                lo = partitionX + 1  // go right
            }
        }

        throw IllegalArgumentException("Input arrays are not sorted")
    }
}