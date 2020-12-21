import solutions.*
import solutions.`interface`.Puzzle

fun main() {
    println("Hello Kotlin!")
    val puzzles = listOf(
        Day1Pt1(),
        Day1Pt2(),
        Day2Pt1(),
        Day2Pt2(),
        Day3Pt1(),
        Day3Pt2(),
        Day4Pt1()
    )
    puzzles.forEach(Puzzle::run)
}