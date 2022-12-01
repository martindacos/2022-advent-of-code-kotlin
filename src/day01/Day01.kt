package day01

import readInputText

fun main() {

    fun parseInput(input: String): List<List<Int>> {
        return input.split("\n\n").map { elf -> elf.split("\n").map { it.toInt() } }
    }

    fun part1(input: String): Int {
        return parseInput(input).maxOf { it.sum() }
    }

    fun part2(input: String): Int {
        return parseInput(input).map { it.sum() }
            .sortedDescending()
            .take(3)
            .sum()
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInputText("/day01/Day01_test")
    check(part1(testInput) == 24000)
    check(part2(testInput) == 45000)

    val input = readInputText("/day01/Day01")
    println(part1(input))
    println(part2(input))
}
