package solutions

import models.Input
import solutions.`interface`.Puzzle

class Day3Pt2(
    private val fileName: String = "d3_input.txt"
) : Puzzle(fileName) {

    private fun countTreesOnSlope(input: Input, stepsRight: Int, stepsDown: Int): Long {
        var treesFound = 0
        var searchPositionAcross = 0
        var searchPositionDown = 0
        input.inputData
            .map {
                it.toCharArray()
            }
            .forEach { pattern ->
                if (shouldCheckForTrees(searchPositionDown, stepsDown)) {
                    val patternLength = pattern.size
                    searchPositionAcross += stepsRight
                    val indexAcross = searchPositionAcross % patternLength
                    if (pattern[indexAcross] == TREE) {
                        treesFound += 1
                    }
                }
                searchPositionDown++
            }
        return treesFound.toLong()
    }

    private fun shouldCheckForTrees(searchPositionDown: Int, stepsDown: Int): Boolean {
        return when (stepsDown) {
            2 -> searchPositionDown != 0 && searchPositionDown % 2 == 0
            else -> searchPositionDown != 0 //Assume 1 for all other cases
        }
    }

    override fun run() {
        val input = loadInput()
        val slope1 = countTreesOnSlope(input, 1, 1)
        val slope2 = countTreesOnSlope(input, 3, 1)
        val slope3 = countTreesOnSlope(input, 5, 1)
        val slope4 = countTreesOnSlope(input, 7, 1)
        val slope5 = countTreesOnSlope(input, 1, 2)
        println("Day 3 (pt.2): ${slope1 * slope2 * slope3 * slope4 * slope5}")
    }

    companion object {
        private const val TREE = '#'
    }
}