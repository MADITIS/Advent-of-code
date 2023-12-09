import java.io.File
import java.io.FileNotFoundException


val digits_map: Map<String, Char> = mapOf(
    "zero" to '0',
    "one" to '1',
    "two" to '2',
    "three" to '3',
    "four" to '4',
    "five" to '5',
    "six" to '6',
    "seven" to '7',
    "eight" to '8',
    "nine" to '9',
    )
fun main() {
    var file: File = File("input.txt")

    // immutable map, immutable variable

    try {
        var sum_values = process_lines(file=file)
        println(sum_values)

    } catch (e: FileNotFoundException) {
        println("Could not read the file: Provide correct Path")
    } catch(e: Exception) {
        println("Programming Error ${e}")
    }

}


fun process_lines(file: File): Int {
    var sum_values: Int = 0
    file.forEachLine(
                action = { line: String ->
                    // loop through each line
                    // check if its number

                    // intialize start and end pointer
                    var start: Char? = null
                    var end: Char? = null
                    // check if substring is a digit
                    for (item in digits_map.entries) {

                        if (item.key in line.lowercase()) {
                            if (start == null) {
                                start = item.value.toChar()
                            } else {
                                end = item.value.toChar()
                            }
                        }
                        val index = line.lowercase().indexOf(item.key) + item.key.length - 1
                        for (char in line) {
                            if (char.isDigit()) {
                                val index2 = line.indexOf(char)

                                if (start == null) {
                                    start = char
                                } else if (index2 > index) {
                                    end = char
                                }
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
                })
    return sum_values
}