package leetcode

/**
 * https://leetcode.com/problems/valid-parentheses/
 *
 *
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']',
 * determine if the input string is valid.
 *
 * An input string is valid if:
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * */

fun main() {
    println("Is () a valid string ${isStringValid("()")}")
    println("Is ()[]{} a valid string ${isStringValid("()[]{}")}")
    println("Is (] a valid string ${isStringValid("(]")}")
    println("Is ([)] a valid string ${isStringValid("([)]")}")
    println("Is {[]} a valid string ${isStringValid("{[]}")}")
    println("Is [ a valid string ${isStringValid("[")}")
    println("Is [( a valid string ${isStringValid("[(")}")
    println("Is (( a valid string ${isStringValid("((")}")
    println("Is )) a valid string ${isStringValid("))")}")
}

// Runtime: 148 ms, faster than 69.72% of Kotlin online submissions for Valid Parentheses.
// Memory Usage: 35.4 MB, less than 20.48% of Kotlin online submissions for Valid Parentheses.

fun isStringValid(str: String): Boolean {
    var openBracket = arrayListOf<String>()

    // if there is an odd number of elements, then the string is invalid:
    if (str.length % 2 != 0) {
        println("the $str length is odd")
        return false
    }

    for (char in str) {
        val s = char.toString()
        when (s) {
            "(", "{", "[" -> {
                // open bracket is always valid
                // ex: [{()}] [](){}
                openBracket.add(s)
            }
            ")", "}", "]" -> {
                // if there is a current open bracket,
                // need to check that this is the proper closing one
                if(openBracket.size > 0) {
                    if(checkIfClosedBracketIsValid(s, openBracket.last())) {
                        openBracket.removeLast()
                    } else {
                        println("$s is the invalid string because it does not match ${openBracket.last()}")
                        return false
                    }
                } else {
                    // we have a closing bracket when there is no openning one
                    return false
                }
            }
        }
    }
    // after going through the string, there should be a closing bracket for each open one
    // so open bracket array should not have any size anymore
    return openBracket.size == 0
}

fun checkIfClosedBracketIsValid(
    currentBracket: String,
    lastOpenBracket: String
): Boolean {
    println("in here")
    return when (currentBracket) {
        ")" -> lastOpenBracket == "("
        "}" -> lastOpenBracket == "{"
        "]" -> lastOpenBracket == "["
        else -> false
    }
}

// coming back to this after a few days, I think there's a better way to do it faster:
//fun isValid(str: String): Boolean {
//    var isValid = false
//
//    if (str.length % 2 != 0) return isValid
//
//    val openBrackets = listOf("(", "[", "{")
//    val closedBrackets = listOf(")", "]", "}")
//
//    for (c in str) {
//        val s = c.toString()
//
//    }
//
//}