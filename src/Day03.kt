fun main() {
    fun executeMul(instructions: String): Int {
        return """mul\((\d{1,3}),(\d{1,3})\)"""
            .toRegex()
            .findAll(instructions)
            .sumOf { match ->
                match.groupValues
                    .drop(1)
                    .map { it.toInt() }
                    .reduce(Int::times)
            }
    }

    fun executeDisabled(instructions: String): Int {
        return """(^|do\(\)).*?($|don't\(\))"""
            .toRegex()
            .findAll(instructions)
            .sumOf { executeMul(it.value) }
    }

    fun part1(input: List<String>): Int {
        return executeMul(input.joinToString(""))
    }

    fun part2(input: List<String>): Int {
        return executeDisabled(input.joinToString(""))
    }

    // Or read a large test input from the `src/Day01_test.txt` file:
    val testInput = readInput("Day03_test")
    check(part1(testInput) == 161)
    check(part2(testInput) == 48)

    // Read the input from the `src/Day01.txt` file.
    val input = readInput("Day03")
    part1(input).println()
    part2(input).println()
}
