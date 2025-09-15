
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

    private static final int ALPHABET_SIZE = 26;
    private static final int MODULO_VALUE = (int) Math.pow(10, 9) + 7;

    public List<String> partitionString(String input) {
        List<String> uniqueSegments = new ArrayList<>();
        Set<Integer> dictionary = new HashSet<>();

        long hashWord = 0;
        int startIndexWord = 0;

        for (int i = 0; i < input.length(); ++i) {

            hashWord *= ALPHABET_SIZE;
            hashWord += 1 + input.charAt(i) - 'a';
            hashWord %= MODULO_VALUE;

            if (!dictionary.add((int) hashWord)) {
                continue;
            }

            uniqueSegments.add(input.substring(startIndexWord, i + 1));
            hashWord = 0;
            startIndexWord = i + 1;
        }

        return uniqueSegments;
    }
}
