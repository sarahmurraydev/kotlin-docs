# Leet Code Dec 2021

## 14 Day Algorithm Study Plan
https://leetcode.com/study-plan/algorithm/?progress=pdp0iqt

### Day 1: Binary Search

Keys: 
* use when you are searching in a pre-sorted array
* note in coding: 0 + (n - 0) / 2 is not the same as n/2 always
    * see: https://ai.googleblog.com/2006/06/extra-extra-read-all-about-it-nearly.html 

Problem 1:
https://leetcode.com/problems/binary-search/submissions/
```kotlin 
class Solution {
    fun search(nums: IntArray, target: Int): Int {
        for(n in 0..nums.size - 1) {
            if (nums[n] == target) {
                return n
            }
        }
        
        return -1
    
    }
}
```

Result:
> Runtime: 240 ms, faster than 70.24% of Kotlin online submissions for Binary Search.
Memory Usage: 37.9 MB, less than 76.34% of Kotlin online submissions for Binary Search.

Notes: 
You wrote an answer but not the fastest/efficient one. 
Binary search so you should start at the middle and then check the left or right side 
(The key in the problem was the word "ascending order")

Binary Search solution: 
```kotlin
class Solution {
    fun search(nums: IntArray, target: Int): Int {
        var startIndex = 0
        var endIndex = nums.size - 1

        while (startIndex <= endIndex ) {
            val midIndex = startIndex + (endIndex - startIndex) / 2

            if (target == nums[midIndex]) return midIndex
            if (target < nums[midIndex]) {
                endIndex = midIndex - 1
            } else if (target > nums[midIndex]) {
                startIndex = midIndex + 1
            }
        }
        return -1
    }
}
```
> Runtime: 236 ms, faster than 79.20% of Kotlin online submissions for Binary Search.
Memory Usage: 37.7 MB, less than 85.31% of Kotlin online submissions for Binary Search.


Problem 2: https://leetcode.com/problems/first-bad-version

This time, I did the opposite of what I did in number 1 ... I went way too complex 
```kotlin
/* The isBadVersion API is defined in the parent class VersionControl.
      def isBadVersion(version: Int): Boolean = {} */

class Solution: VersionControl() {
    override fun firstBadVersion(n: Int) : Int {
        // binary search but need some memory of the trues 
        
        var first = 0
        var last = n - 1
        
        while (first <= last) {
            var mid = first + (last - first)/2 
            
            if (isBadVersion(mid)) {
                if(isBadVersion(mid-1)) {
                    //both mid and mid-1 are bad
                    last = mid - 1 
                } else {
                    // mid is bad
                    // mid - 1 is not bad 
                    return mid 
                }
            } else {
                if(isBadVersion(mid+1)) {
                    // mid is not bad 
                    // mid + 1 is bad meaning ==> first bad version is mid + 1
                    return mid + 1
                } else {
                    first = mid + 1
                }
            }
        }
        return -1
	}
}
```

Second solution, looking at answer was just another binary search: 
```kotlin
/* The isBadVersion API is defined in the parent class VersionControl.
      def isBadVersion(version: Int): Boolean = {} */

class Solution: VersionControl() {
    override fun firstBadVersion(n: Int) : Int {
        // binary search but need some memory of the trues 
        
        var first = 0
        var last = n - 1
        
        while (first <= last) {
            var mid = first + (last - first)/2 
            
            if (isBadVersion(mid)) {
                last = mid - 1 
            } else {
                first = mid + 1
            }
        }
        return first
	}
}
```
> Runtime: 216 ms, faster than 83.73% of Kotlin online submissions for First Bad Version.
Memory Usage: 32.8 MB, less than 53.35% of Kotlin online submissions for First Bad Version.


Problem 3: https://leetcode.com/problems/search-insert-position
Didn't over think this one, pretty sure it's just regular binary search again. Maybe there's a cleaner or simpler way but the solution required premium so :shrug 

```kotlin
class Solution {
    fun searchInsert(nums: IntArray, target: Int): Int {
        
        var start = 0 
        var end = nums.size - 1
        
        while (start <= end) {
            val mid = start + (end - start)/2
            
            if(target == nums[mid]) return mid
            
            if (target < nums[mid]) {
                end = mid -1 
            } else if (target > nums[mid]) {
                start = mid + 1
            }
        }
        
        return start
    }
}
```
> Runtime: 180 ms, faster than 55.38% of Kotlin online submissions for Search Insert Position.
Memory Usage: 36.3 MB, less than 84.28% of Kotlin online submissions for Search Insert Position.


## Day 2 - Two Pointers 

Problem 1: https://leetcode.com/problems/squares-of-a-sorted-array/ 

First attempt: 
```kotlin
class Solution {
    fun sortedSquares(nums: IntArray): IntArray {
        for(n in nums.indices) {
            nums[n] = nums[n] * nums[n]
        }
        println("nums is now doubled: ${nums}")
        
        nums.sort()
        
        return nums
    }
}
```
Before I even submitted this I read this 😭: 
> Follow up: Squaring each element and sorting the new array is very trivial, could you find an O(n) solution using a different approach?