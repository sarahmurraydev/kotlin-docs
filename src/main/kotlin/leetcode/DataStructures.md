## 14 Day Study Plan 

## Day 1: Duplicates 
Problem 1: 

first attempt: 
```kotlin
class Solution {
    fun containsDuplicate(nums: IntArray): Boolean {
        // take element i 
        // add it to another array 
        // take element i+1 
        // for each element in array2
        // if element = i+1 
        // duplicate 
        
        // start dup arr with first element of nums
        val dupArr = mutableListOf<Int>(nums[0])
        
        for (i in 1..nums.size-1) {
            // for elements 1 to last element of nums 
            // check if nums[i] is in the dupArr already
            for(j in 0..dupArr.size-1) {
                if(nums[i] == dupArr[j]) {
                    // element is duplicated 
                    return true
                } else {
                    // element is unique, add to dups
                    dupArr.add(nums[i])
                }
            }
        }
        
        return false
    }
}
```
this past the test cases but failed when submitted because of memory exceeded
I think this is because you are making dupArr extremely long 
it's adding the j-1 element everytime you are comparing j 
let's try regular double loop

this passed but is slow as hell, uses almost no memory though
```kotlin
class Solution {
    fun containsDuplicate(nums: IntArray): Boolean {
        
        for (i in 0..nums.size-1) {
            for(j in 0..nums.size-1) {
                // don't compare same index -- would always return true
                if (i != j) {
                    if(nums[i] == nums[j]) {
                        return true
                    }
                }
            }
        }
        
        return false
    }
}
```
>Runtime: 1808 ms, faster than 5.03% of Kotlin online submissions for Contains Duplicate.
Memory Usage: 40.6 MB, less than 95.52% of Kotlin online submissions for Contains Duplicate.

Notes: lots of the solutions use hashes, maps, or sets ... time to learn about those! 
* https://leetcode.com/problems/contains-duplicate/discuss/904845/Kotlin-Solution 
* https://leetcode.com/problems/contains-duplicate/discuss/1025835/Kotlin-1-line 
