package solutions

import models.Input
import solutions.`interface`.Puzzle

class Day1Pt1(
    private val fileName: String = "d1_input.txt"
) : Puzzle(fileName) {

    private fun findEntriesSummingTo2020(input: Input): List<Int> {
        val inputAsInt = input.inputData
            .map { Integer.parseInt(it) }
        return inputAsInt.filter { inputAsInt.contains(2020 - it) }
    }

    override fun run() {
        val input = loadInput()
        val intList = findEntriesSummingTo2020(input)
        println("Day 1 Answer (pt.1): ${intList.first() * intList.last()}")
    }
}