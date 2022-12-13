package day08

import readInput

fun main() {

    fun readMatrix(input: List<String>): List<List<Int>> {
        val matrix: MutableList<List<Int>> = mutableListOf()
        for (line in input) {
            matrix.add(line.toCharArray().map { c -> c.digitToInt() })
        }
        return matrix
    }

    fun biggerInLine(treeLine: List<Int>, treeSize: Int): Boolean {
        val maxOrNull = treeLine.maxOrNull() ?: 0
        return (treeSize > maxOrNull)
    }

    fun treesThanCanSee(treeLine: List<Int>, treeSize: Int): Int {
        var treesThanCanSee = 0
        for (tree in treeLine) {
            if (tree < treeSize) treesThanCanSee++
            else {
                treesThanCanSee++
                break
            }
        }

        return treesThanCanSee
    }

    fun topToEdge(matrix: List<List<Int>>, i: Int, j: Int): List<Int> {
        val line: MutableList<Int> = mutableListOf()
        for (x in i - 1 downTo 0) {
            line.add(matrix[x][j])
        }

        return line
    }

    fun leftToEdge(matrix: List<List<Int>>, i: Int, j: Int): List<Int> {
        val line: MutableList<Int> = mutableListOf()
        for (x in j - 1 downTo 0) {
            line.add(matrix[i][x])
        }

        return line
    }

    fun downToEdge(matrix: List<List<Int>>, i: Int, j: Int): List<Int> {
        val line: MutableList<Int> = mutableListOf()
        for (x in i + 1 until matrix.size) {
            line.add(matrix[x][j])
        }

        return line
    }

    fun rightToEdge(matrix: List<List<Int>>, i: Int, j: Int): List<Int> {
        val line: MutableList<Int> = mutableListOf()
        for (x in j + 1 until matrix[i].size) {
            line.add(matrix[i][x])
        }

        return line
    }

    fun calculateVisibleTrees(input: List<String>): Int {
        /**
        30373
        25512
        65332
        33549
        35390
         */
        val matrix = readMatrix(input)
        var visibleTrees = 0

        for (i in matrix.indices) {
            for (j in 0 until matrix[i].size) {
                //print(matrix[i][j])
                if (i == 0 || j == 0) visibleTrees++
                else if (i == matrix.size - 1 || j == matrix[i].size - 1) visibleTrees++
                else {
                    val treeSize = matrix[i][j]
                    if (biggerInLine(topToEdge(matrix, i, j), treeSize) ||
                        biggerInLine(leftToEdge(matrix, i, j), treeSize) ||
                        biggerInLine(downToEdge(matrix, i, j), treeSize) ||
                        biggerInLine(rightToEdge(matrix, i, j), treeSize)
                    ) visibleTrees++
                }
            }
            //println()
        }

        return visibleTrees
    }

    fun calculateHighestScenic(input: List<String>): Int {
        /**
        30373
        25512
        65332
        33549
        35390
         */
        val matrix = readMatrix(input)
        var highestScenic = 0

        for (i in matrix.indices) {
            for (j in 0 until matrix[i].size) {
                //print(matrix[i][j])
                val treeSize = matrix[i][j]
                val topView = treesThanCanSee(topToEdge(matrix, i, j), treeSize)
                val leftView = treesThanCanSee(leftToEdge(matrix, i, j), treeSize)
                val downView = treesThanCanSee(downToEdge(matrix, i, j), treeSize)
                val rightView = treesThanCanSee(rightToEdge(matrix, i, j), treeSize)
                val scenic = topView * leftView * downView * rightView
                if (scenic > highestScenic) highestScenic = scenic
            }
            //println()
        }

        return highestScenic
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("/day08/Day08_test")
    check(calculateVisibleTrees(testInput) == 21)
    check(calculateHighestScenic(testInput) == 8)

    val input = readInput("/day08/Day08")
    println(calculateVisibleTrees(input))
    println(calculateHighestScenic(input))
}