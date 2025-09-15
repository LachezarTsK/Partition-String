
import kotlin.math.pow

class Solution {

    private companion object {
        const val ALPHABET_SIZE = 26
        val MODULO_VALUE = (10.0).pow(9) + 7
    }

    fun partitionString(input: String): List<String> {
        val uniqueSegments = mutableListOf<String>()
        val dictionary = mutableSetOf<Int>()

        var hashWord: Long = 0
        var startIndexWord = 0

        for (i in input.indices) {

            hashWord *= ALPHABET_SIZE
            hashWord += 1 + (input[i] - 'a')
            hashWord %= MODULO_VALUE.toLong()

            if (!dictionary.add(hashWord.toInt())) {
                continue
            }

            uniqueSegments.add(input.substring(startIndexWord, i + 1))
            hashWord = 0
            startIndexWord = i + 1
        }

        return uniqueSegments
    }
}
