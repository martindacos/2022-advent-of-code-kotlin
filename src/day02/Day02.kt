package day02

import readInput

fun main() {

    fun part1(input: List<String>): Int {
        var points = 0
        val plays = input.map { play -> play.split(" ") }
        for (play in plays) {
            val myPoints = when (play.get(1)) {
                "X" -> 1
                "Y" -> 2
                "Z" -> 3
                else -> throw Exception("Error")
            }
            points += myPoints

            val playPoints = when (play) {
                listOf("A", "X") -> 3
                listOf("A", "Y") -> 6
                listOf("A", "Z") -> 0

                listOf("B", "X") -> 0
                listOf("B", "Y") -> 3
                listOf("B", "Z") -> 6

                listOf("C", "X") -> 6
                listOf("C", "Y") -> 0
                listOf("C", "Z") -> 3

                else -> throw Exception("Error")
            }

            points += playPoints
        }

        return points
    }

    fun part2(input: List<String>): Int {
        var points = 0
        val plays = input.map { play -> play.split(" ") }
        for (play in plays) {
            //println(play)
            val myPoints = when (play.get(1)) {
                "X" -> 0
                "Y" -> 3
                "Z" -> 6
                else -> throw Exception("Error")
            }
            points += myPoints

            val playPoints = when (play) {
                listOf("A", "X") -> 3
                listOf("A", "Y") -> 1
                listOf("A", "Z") -> 2

                listOf("B", "X") -> 1
                listOf("B", "Y") -> 2
                listOf("B", "Z") -> 3

                listOf("C", "X") -> 2
                listOf("C", "Y") -> 3
                listOf("C", "Z") -> 1

                else -> throw Exception("Error")
            }

            points += playPoints
        }

        return points
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("/day02/Day02_test")
    check(part1(testInput) == 15)
    check(part2(testInput) == 12)

    val input = readInput("/day02/Day02")
    println(part1(input))
    println(part2(input))
}
