package solutions

import models.Input
import solutions.`interface`.Puzzle
import java.util.*

class Day2Pt1(
    private val fileName: String = "d2_input.txt"
) : Puzzle(fileName) {

    private fun countValidPasswords(input: Input): Int {
        val policyPasswordPairs = processRawInput(input.inputData)
        return policyPasswordPairs
            .map {
                val splitPolMinMaxToChar = it.first.split(" ")
                val charToTestFor = splitPolMinMaxToChar.last().toCharArray()[0]
                val minMaxSplit = splitPolMinMaxToChar.first().split("-")
                val minTimes = Integer.parseInt(minMaxSplit[0])
                val maxTimes = Integer.parseInt(minMaxSplit[1])
                val numOfExpectedCharInString = it.second
                    .toCharArray()
                    .filter { char ->
                        char == charToTestFor
                    }.count()
                numOfExpectedCharInString in minTimes..maxTimes
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
        println("Day 2 (pt.1): ${countValidPasswords(input)}")
    }
}