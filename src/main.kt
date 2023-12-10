import java.io.File
import java.io.FileNotFoundException
// not using regex
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

                var current_line =
                        line.lowercase()
                                .replace("nineight", "98")
                                .replace("sevenine", "79")
                                .replace("fiveight", "58")
                                .replace("eighthree", "83")
                                .replace("eightwo", "82")
                                .replace("zerone", "01")
                                .replace("oneight", "18")
                                .replace("threeight", "38")
                                .replace("twone", "21")
                for (item in digits_map.entries) {
                    if (item.key in current_line) {
                        current_line = current_line.replace(item.key, item.value.toString())
                    }
                }
                print("${line}: ")

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
