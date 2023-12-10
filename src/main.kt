import java.io.File
import java.io.FileNotFoundException

val digits_map: Map<String, Char> =
        mapOf(
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
        var sum_values = process_lines(file = file)
        println(sum_values)
    } catch (e: FileNotFoundException) {
        println("Could not read the file: Provide correct Path")
    } catch (e: Exception) {
        println("Programming Error ${e}")
    }
}

fun process_lines(file: File): Int {
    var sum_values: Int = 0
    // val listMap = mutableListOf<MutableMap<Int, Char>>()

    file.forEachLine(
            action = { line: String ->
                // loop through each line
                // check if its number

                // intialize start and end pointer

                var current_line = line.lowercase()
                for (item in digits_map.entries) {
                    val sub_string = item.key.substring(0, item.key.length - 1)
                    if (item.key in current_line) {
                        current_line = current_line.replace(item.key, item.value.toString())

                        //    print("sub ${sub_string}")

                    } else if (sub_string in current_line) {
                        current_line = current_line.replace(sub_string, item.value.toString())
                    }
                }
                print("${current_line}: ")

                var start: Char? = null
                var end: Char? = null
                for (char in current_line) {
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
                println(number)

                sum_values += number.toInt()
            }
    )
    return sum_values
}
