import solutions.Day1Pt1
import solutions.Day1Pt2
import solutions.`interface`.Puzzle

fun main() {
    println("Hello Kotlin!")
    val puzzles = listOf(
        Day1Pt1(),
        Day1Pt2()
    )
    puzzles.forEach(Puzzle::run)
}