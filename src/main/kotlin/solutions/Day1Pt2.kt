package solutions

import models.Input
import solutions.`interface`.Puzzle
import java.util.*

class Day1Pt2(
    private val fileName: String = "d1_input.txt"
) : Puzzle(fileName) {

    private fun find3EntriesSummingTo2020(input: Input): Triple<Int, Int, Int> {
        val sortedListOfNumbers = input.inputData
            .map { Integer.parseInt(it) }
            .sorted()

        var indexForNum1 = 0
        var indexForNum2 = 1
        while (indexForNum1 < sortedListOfNumbers.size) {
            while (indexForNum2 < sortedListOfNumbers.size) {
                val listToCheck = sortedListOfNumbers
                    .filterNot { it == sortedListOfNumbers[indexForNum1] }
                    .filterNot { it == sortedListOfNumbers[indexForNum2] }
                val result =
                    listToCheck.filter { (2020 - sortedListOfNumbers[indexForNum1] - sortedListOfNumbers[indexForNum2]) == it }
                if (result.isEmpty()){
                    indexForNum2++
                    continue
                }
                return Triple(result.first(), sortedListOfNumbers[indexForNum1], sortedListOfNumbers[indexForNum2])
            }
            indexForNum1++
            indexForNum2 = indexForNum1+1
        }

        throw RuntimeException("NO RESULT! You Sure?")
    }

    override fun run() {
        val input = loadInput()
        val intList = find3EntriesSummingTo2020(input)
        //println(intList)
        println("Day 1 (pt.2): ${intList.first * intList.second * intList.third}")
    }
}