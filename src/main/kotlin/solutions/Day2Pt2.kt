package solutions

import models.Input
import solutions.`interface`.Puzzle

class Day2Pt2(
    private val fileName: String = "d2_input.txt"
) : Puzzle(fileName) {

    private fun countValidPasswords(input: Input): Int {
        val policyPasswordPairs = processRawInput(input.inputData)
        return policyPasswordPairs
            .map {
                val splitPolMinMaxToChar = it.first.split(" ")
                val charToTestFor = splitPolMinMaxToChar.last().toCharArray()[0]
                val positionSplit = splitPolMinMaxToChar.first().split("-")
                val pos1Index = Integer.parseInt(positionSplit[0]) - 1
                val pos2Index = Integer.parseInt(positionSplit[1]) - 1
                val pos1ContainsChar = it.second[pos1Index] == charToTestFor
                val pos2ContainsChar = it.second[pos2Index] == charToTestFor
                !(pos1ContainsChar && pos2ContainsChar) &&
                        ((pos1ContainsChar && !pos2ContainsChar) ||
                                (!pos1ContainsChar && pos2ContainsChar))
            }
            .filter { it }
            .count()
    }

    private fun processRawInput(inputData: List<String>): List<Pair<String, String>> {
        return inputData.map {
            val splitInput = it.split(": ")
            Pair(splitInput.first(), splitInput.last())
        }
    }

    override fun run() {
        val input = loadInput()
        println("Day 2 (pt.2): ${countValidPasswords(input)}")
    }
}