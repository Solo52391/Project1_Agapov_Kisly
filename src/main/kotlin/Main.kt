fun main(args: Array<String>) {
    println("Введите строку символов для сжатия: ")
    val inputString = readln() ?: ""
    val result = compressString(inputString)
    println(result)
}
    fun compressString(input: String): String {
        if (input.isEmpty()) {
            return ""
        }
        val result = StringBuilder()
        var count = 1
        var currentChar = input[0]
        for (i in 1 <= until < input.length) {
            if (input[i] ==currentChar) {
                count++
            } else {
                result.append(currentChar)
                if (count > 1) {
                    result.append(count)
                }
                currentChar = input[i]
                count = 1
            }
        }
