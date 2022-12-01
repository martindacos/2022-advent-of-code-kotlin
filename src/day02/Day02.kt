package day02

import readInputText

fun main() {

    fun part1(input: String): Int {
        return 0
    }

    fun part2(input: String): Int {
        return 0
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInputText("/day02/Day02_test")
    check(part1(testInput) == 0)
    check(part2(testInput) == 0)

    val input = readInputText("/day02/Day02")
    println(part1(input))
    println(part2(input))
}
