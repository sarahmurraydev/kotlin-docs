package leetcode

class Solution {
    // first accepted solution:
    fun strStr(haystack: String, needle: String): Int {
        val hLength = haystack.length
        val nLength = needle.length

        if (nLength == 0) return 0
        if (hLength != 0 && hLength >= nLength) {
            for (h in (0 until hLength - 1)) {
                var indexOfHaystack = h
                var indexOfNeedle = 0
                while (indexOfNeedle < nLength && indexOfHaystack < hLength) {
                    if (haystack[indexOfHaystack] == needle[indexOfNeedle]) {
                        if (indexOfNeedle == (nLength - 1)) {
                            return h
                        }
                        indexOfHaystack++
                        indexOfNeedle++
                    } else {
                        break
                    }
                }
            }
        }
        return -1
    }
    // Details of this:
    // Runtime: 1192 ms, faster than 5.31% of Kotlin online submissions for Implement strStr().
    // Memory Usage: 35.3 MB, less than 86.96% of Kotlin online submissions for Implement strStr().
}