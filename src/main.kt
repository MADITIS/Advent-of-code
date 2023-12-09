import java.io.File
import java.io.FileNotFoundException

fun main() {
    var file: File = File("input.txt")
    var sum_values: Int = 0

    try {
        file.forEachLine(
                action = { line: String ->
                    // loop through each line
                    // check if its number

                    // intialize start and end pointer
                    var start: Char? = null
                    var end: Char? = null
                    for (char in line) {
                        if (char.isDigit()) {
                            if (start == null) {
                                start = char
                            } else {
                                end = char
                            }
                        }
                    }
                    var number: String = ""
                    if (start != null) {
                        number += start
                    }

                    if (end == null) {
                        end = start
                    }
                    number += end
                    // println(number)

                    sum_values += number.toInt()
                }
        )
    } catch (e: FileNotFoundException) {
        println("Could not read the file: Provide correct Path")
    }

    println(sum_values)
}
