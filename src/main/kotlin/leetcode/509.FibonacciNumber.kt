package leetcode

fun main() {
    print("The solution to leetcode problem 509")
    print("${fib(2)} is the 2nd fib number")
}

// https://leetcode.com/problems/fibonacci-number/


// first tried the

fun fib(n: Int): Int {
    if (n < 0) throw Exception("n is less than zero")

    return when (n) {
        0, 1 -> n
        else -> fib(n-1) + fib(n-2)
    }
}

/**
 * This solution is very slow
 *
 * Runtime: 242 ms, faster than 5.63% of Kotlin online submissions for Fibonacci Number.
 * Memory Usage: 33.6 MB, less than 13.52% of Kotlin online submissions for Fibonacci Number.
 *
 * */