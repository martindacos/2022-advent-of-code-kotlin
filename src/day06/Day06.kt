package day06

import readInput

fun main() {

    fun calculatePosition(input: List<String>, k: Int): Int {
        var position = 0
        val line = input[0]
        for (i in 0 .. line.length - 4) {
            //println(line[i])
            // mjqj -> [m,j,q]
            // substring(0, 0+4)
            if (line.substring(i, i + k).toSet().size == k) {
                position = i + k
                break
            }
        }
        return position
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("/day06/Day06_test")
    check(calculatePosition(testInput, 4) == 7)
    check(calculatePosition(testInput, k = 14) == 19)

    val input = readInput("/day06/Day06")
    println(calculatePosition(input, 4))
    println(calculatePosition(input, k = 14))
}