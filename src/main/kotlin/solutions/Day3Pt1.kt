package solutions

import models.Input
import solutions.`interface`.Puzzle

class Day3Pt1(
    private val fileName: String = "d3_input.txt"
) : Puzzle(fileName) {

    private fun countTreesOnR3D1Slope(input: Input): Int {
        //TODO: Implement count for slope, moving right 3, and down 1
        return 0
    }

    override fun run() {
        val input = loadInput()
        println("Day 3 (pt.1): ${countTreesOnR3D1Slope(input)}")
    }

    companion object {
        private const val OPEN_SQUARE = "."
        private const val TREE = "#"
    }
}