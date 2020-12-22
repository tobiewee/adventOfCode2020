package solutions

import models.Input
import solutions.`interface`.Puzzle

class Day4Pt1(
    private val fileName: String = "d4_input.txt"
) : Puzzle(fileName) {

    private fun countValidPassports(input: Input): Int {
        var numValidPassports = 0
        var passportValidator = PassportValidation()
        input.inputData.indices.forEach {
            val line = input.inputData[it]
            when {
                line.trim().isEmpty() -> {
                    if (passportValidator.isValid()) {
                        numValidPassports++
                    }
                    passportValidator = PassportValidation()
                }
                else -> {
                    validateLine(line, passportValidator)
                    if (it == input.inputData.lastIndex && passportValidator.isValid()) {
                        numValidPassports++
                    }
                }
            }
        }
        return numValidPassports
    }

    private fun validateLine(line: String, passportValidator: PassportValidation) {
        line.split(" ")
            .map {
                val splitComponent = it.split(":")
                Pair(splitComponent[0], splitComponent[1])
            }
            .map {
                validate(it, passportValidator)
            }
    }

    private fun validate(fieldValueMapping: Pair<String, String>, passportValidation: PassportValidation) {
        when (fieldValueMapping.first) {
            "byr" -> passportValidation.byr = true
            "iyr" -> passportValidation.iyr = true
            "eyr" -> passportValidation.eyr = true
            "hgt" -> passportValidation.hgt = true
            "hcl" -> passportValidation.hcl = true
            "ecl" -> passportValidation.ecl = true
            "pid" -> passportValidation.pid = true
            "cid" -> passportValidation.cid = true
            else -> return
        }
    }

    override fun run() {
        val input = loadInput()
        println("Day 4 (pt.1): ${countValidPassports(input)}")
    }
}

data class PassportValidation(
    var byr: Boolean = false,
    var iyr: Boolean = false,
    var eyr: Boolean = false,
    var hgt: Boolean = false,
    var hcl: Boolean = false,
    var ecl: Boolean = false,
    var pid: Boolean = false,
    var cid: Boolean = true //Optional for now
) {
    fun isValid(): Boolean {
        return cid && pid && ecl && hcl && hgt && eyr && iyr && byr
    }
}

