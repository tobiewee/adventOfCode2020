package solutions

import models.Input
import solutions.`interface`.Puzzle

class Day1Pt2(
    private val fileName: String = "d1_input.txt"
) : Puzzle(fileName) {

    private fun find3EntriesSummingTo2020(input: Input): List<Int> {
        val queueOfNumbers = input.inputData
            .map { Integer.parseInt(it) }
            .sorted()

        //TODO: Implement algorithm to find 3 unique numbers and return
        return emptyList()
    }

    override fun run() {
        val input = loadInput()
        val intList = find3EntriesSummingTo2020(input)
        println("Day 1 Answer (pt.2): TODO")
    }
}