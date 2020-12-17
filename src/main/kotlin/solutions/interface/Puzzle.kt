package solutions.`interface`

import models.Input
import java.io.File

abstract class Puzzle(private val fileName: String) {
    fun loadInput(): Input {
        return Input(File(this.javaClass.getResource("/$fileName").toURI()).readLines())
    }

    abstract fun run()
}