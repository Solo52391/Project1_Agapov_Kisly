fun main() {
    println("Введите строку для обработки:")
    val input = readLine() ?: ""

    if (input.isEmpty()) {
        println("Введена пустая строка")
        return
    }

    val result = compressString(input)
    println("Результат: $result")
}

fun compressString(input: String): String {
    if (input.isEmpty()) return ""

    val result = StringBuilder()
    var currentChar = input[0]
    var count = 1

    for (i in 1 until input.length) {
        if (input[i] == currentChar) {
            count++
        } else {
            // Добавляем символ и количество (если больше 1)
            result.append(currentChar)
            if (count > 1) {
                result.append(count)
            }

            // Сбрасываем счетчик для нового символа
            currentChar = input[i]
            count = 1
        }
    }

    // Добавляем последний символ
    result.append(currentChar)
    if (count > 1) {
        result.append(count)
    }

    return result.toString()
}

// Альтернативная версия с использованием функционального подхода
fun compressStringFunctional(input: String): String {
    return if (input.isEmpty()) {
        ""
    } else {
        input.foldIndexed(StringBuilder() to StringBuilder()) { index, (result, currentGroup), char ->
            if (index == 0 || char == input[index - 1]) {
                currentGroup.append(char)
                result to currentGroup
            } else {
                result.append(compressGroup(currentGroup.toString()))
                result to StringBuilder().append(char)
            }
        }.let { (result, lastGroup) ->
            result.append(compressGroup(lastGroup.toString()))
            result.toString()
        }
    }
}

private fun compressGroup(group: String): String {
    return if (group.length > 1) {
        "${group.first()}${group.length}"
    } else {
        group
    }
}
