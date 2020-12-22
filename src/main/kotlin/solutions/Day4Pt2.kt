package solutions

import models.Input
import solutions.`interface`.Puzzle

class Day4Pt2(
    private val fileName: String = "d4_input.txt"
) : Puzzle(fileName) {

    private fun countValidPassports(input: Input): Int {
        var numValidPassports = 0
        var passportValidator = PassportValidation()
        input.inputData.indices.forEach { lineIndex ->
            val line = input.inputData[lineIndex]
            when {
                line.trim().isEmpty() -> {
                    if (passportValidator.isValid()) {
                        numValidPassports++
                    }
                    passportValidator = PassportValidation()
                }
                else -> {
                    validateLine(line, passportValidator)
                    if (inputIsLastLine(input, lineIndex) && passportValidator.isValid()) {
                        numValidPassports++
                    }
                }
            }
        }
        return numValidPassports
    }

    private fun inputIsLastLine(input: Input, it: Int) = it == input.inputData.lastIndex

    private fun validateLine(line: String, passportValidator: PassportValidation) {
        line.split(" ")
            .map {
                val splitComponent = it.split(":")
                Pair(splitComponent[0], splitComponent[1])
            }
            .map {
                passportValidator.validatePairDetails(it)
            }
    }

    override fun run() {
        val input = loadInput()
        println("Day 4 (pt.2): ${countValidPassports(input)}")
    }
}
