package solutions

import models.Input
import solutions.`interface`.Puzzle

class Day4Pt1(
    private val fileName: String = "d4_input.txt"
) : Puzzle(fileName) {

    private fun countValidPassports(input: Input): Int {
        TODO("To be implemented")
    }

    override fun run() {
        val input = loadInput()
        println("Day 4 (pt.1): ${countValidPassports(input)}")
    }
}