package day03

import readInput

fun main() {

    fun calculatePriority(intersect: Set<Char>): Int {
        val number = if (intersect.first().isUpperCase()) {
            intersect.first().code - 38
        } else {
            intersect.first().code - 96
        }
        return number
    }

    fun part1(input: List<String>): Int {
        var priority = 0
        for (content in input) {
            val chunkedContent: List<String> = content.chunked(content.length / 2)
            val list1 = chunkedContent[0].toSet()
            val list2 = chunkedContent[1].toSet()
            val intersect = list1.intersect(list2)
            val number = calculatePriority(intersect)
            priority += number
        }

        return priority
    }

    fun part2(input: List<String>): Int {
        var priority = 0
        for (i in 3..input.size step 3) {
            val elf1 = input[i-3].toSet()
            val elf2 = input[i-2].toSet()
            val elf3 = input[i-1].toSet()
            val intersect = elf1.intersect(elf2).intersect(elf3)
            val number = calculatePriority(intersect)
            priority += number
        }

        return priority
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("/day03/Day03_test")
    check(part1(testInput) == 157)
    check(part2(testInput) == 70)

    val input = readInput("/day03/Day03")
    println(part1(input))
    println(part2(input))
}