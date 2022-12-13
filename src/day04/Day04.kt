package day04

import readInput

fun main() {

    fun part1(input: List<String>): Int {
        var fullyContained = 0
        for (line in input) {
            val numbers = line.split(",")
            // [2, 4]
            val initialAndFinalNumber = numbers[0].split("-").map { number -> number.toInt() }
            // [2,3,4]
            val listA: MutableList<Int> = mutableListOf()
            for (i in initialAndFinalNumber[0]..initialAndFinalNumber[initialAndFinalNumber.size - 1]) {
                listA.add(i)
            }

            // [6, 8]
            val initialAndFinalNumber2 = numbers[1].split("-").map { number -> number.toInt() }
            // [6,7,8]
            val listB: MutableList<Int> = mutableListOf()
            for (i in initialAndFinalNumber2[0]..initialAndFinalNumber2[initialAndFinalNumber2.size - 1]) {
                listB.add(i)
            }

            val intersect = listA.intersect(listB)
            if (intersect.size == listA.size || intersect.size == listB.size) fullyContained++
        }

        return fullyContained
    }

    fun part2(input: List<String>): Int {
        var fullyContained = 0
        for (line in input) {
            val numbers = line.split(",")
            // [2, 4]
            val initialAndFinalNumber = numbers[0].split("-").map { number -> number.toInt() }
            // [2,3,4]
            val listA: MutableList<Int> = mutableListOf()
            for (i in initialAndFinalNumber[0]..initialAndFinalNumber[initialAndFinalNumber.size - 1]) {
                listA.add(i)
            }

            // [6, 8]
            val initialAndFinalNumber2 = numbers[1].split("-").map { number -> number.toInt() }
            // [6,7,8]
            val listB: MutableList<Int> = mutableListOf()
            for (i in initialAndFinalNumber2[0]..initialAndFinalNumber2[initialAndFinalNumber2.size - 1]) {
                listB.add(i)
            }

            val intersect = listA.intersect(listB)
            if (intersect.size > 0) fullyContained++
        }

        return fullyContained
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("/day04/Day04_test")
    check(part1(testInput) == 2)
    check(part2(testInput) == 4)

    val input = readInput("/day04/Day04")
    //println(part1(input))
    println(part2(input))
}