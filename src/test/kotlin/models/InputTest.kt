package models

import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.collections.shouldContainExactly
import io.kotest.matchers.shouldBe
import io.kotest.matchers.string.shouldContain
import java.io.File

class InputTest:AnnotationSpec() {

    @Test
    fun `should return contents of testSingleLine txt`(){
        val input = getTestInputFromFile("/fileIO/testSingleLine.txt")
        input.inputData.size shouldBe 1
        input.inputData shouldContainExactly listOf("Hello Worlds!")
    }

    @Test
    fun `should return contents of testThreeLines txt`(){
        val input = getTestInputFromFile("/fileIO/testThreeLines.txt")
        input.inputData.size shouldBe 3
        input.inputData shouldContainExactly listOf("Hello", "You Are", "Johnny")
    }

    private fun getTestInputFromFile(resourceFolderAndFile: String): Input {
        val filePath = this.javaClass.getResource(resourceFolderAndFile).toURI()
        val file = File(filePath)
        return Input(file.readLines())
    }
}