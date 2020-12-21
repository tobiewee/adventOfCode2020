package solutions

import models.Input
import solutions.`interface`.Puzzle

class Day3Pt1(
    private val fileName: String = "d3_input.txt"
) : Puzzle(fileName) {

    private fun countTreesOnR3D1Slope(input: Input): Int {
        var treesFound = 0
        var searchPositionAcross = 0
        var searchPositionDown = 0
        input.inputData
            .map {
                it.toCharArray()
            }
            .forEach { pattern ->
                if (searchPositionDown != 0) {
                    var patternLength = pattern.size
                    searchPositionAcross += STEPS_RIGHT
                    val indexAcross = searchPositionAcross % patternLength
                    if (pattern[indexAcross] == TREE) {
                        treesFound += 1
                    }
                }
                searchPositionDown++
            }
        return treesFound
    }

    override fun run() {
        val input = loadInput()
        println("Day 3 (pt.1): ${countTreesOnR3D1Slope(input)}")
    }

    companion object {
        private const val TREE = '#'
        private const val STEPS_RIGHT = 3
    }
}