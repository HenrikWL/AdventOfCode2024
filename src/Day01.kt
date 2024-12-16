import kotlin.math.abs

fun main() {
    fun parse(input: List<String>): Pair<List<String>, List<String>> {
        val left = input.map { e -> e.split("   ")[0] }.sorted()
        val right = input.map { e -> e.split("   ")[1] }.sorted()

        return left to right
    }

    fun part1(input: List<String>): Int {
        val (left, right) = parse(input)

        return left.zip(right)
            .sumOf { it -> abs(it.first.toInt() - it.second.toInt()) }
    }

    fun part2(input: List<String>): Int {
        val (left, right) = parse(input)

        val frequencies = right.groupingBy { it }.eachCount()
        return left.sumOf { it.toInt() * frequencies.getOrDefault(it, 0) }
    }

    // Or read a large test input from the `src/Day01_test.txt` file:
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 11)
    check(part2(testInput) == 31)

    // Read the input from the `src/Day01.txt` file.
    val input = readInput("Day01")
    part1(input).println()
    part2(input).println()
}
