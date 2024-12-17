fun main() {
    fun parse(input: List<String>): List<List<Int>> {
       return input
           .map { e -> e.split(" ").map {it -> it.toInt()} }
    }

    fun isSafe(report: List<Int>): Boolean {
        val diffs = report.zipWithNext().map { (left, right) -> left - right }
        return diffs.all { it in 1..3 } || diffs.all { it in -3..-1 }
    }

    fun isSafeDampened(report: List<Int>): Boolean {
        return report.indices.any { removeThis ->
            isSafe(report.filterIndexed { index, _ -> removeThis != index })
        }
    }

    fun part1(input: List<String>): Int {
        return parse(input).count { isSafe(it) }
    }

    fun part2(input: List<String>): Int {
        return parse(input).count { isSafeDampened(it) }
    }

    // Or read a large test input from the `src/Day01_test.txt` file:
    val testInput = readInput("Day02_test")
    check(part1(testInput) == 2)
    check(part2(testInput) == 4)

    // Read the input from the `src/Day01.txt` file.
    val input = readInput("Day02")
    part1(input).println()
    part2(input).println()
}
