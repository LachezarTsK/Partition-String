
using System;
using System.Collections.Generic;

public class Solution
{
    private static readonly int ALPHABET_SIZE = 26;
    private static readonly int MODULO_VALUE = (int)Math.Pow(10, 9) + 7;

    public IList<string> PartitionString(string input)
    {
        IList<string> uniqueSegments = new List<string>();
        HashSet<int> dictionary = new HashSet<int>();

        long hashWord = 0;
        int startIndexWord = 0;

        for (int i = 0; i < input.Length; ++i)
        {

            hashWord *= ALPHABET_SIZE;
            hashWord += 1 + input[i] - 'a';
            hashWord %= MODULO_VALUE;

            if (!dictionary.Add((int)hashWord))
            {
                continue;
            }

            uniqueSegments.Add(input.Substring(startIndexWord, i - startIndexWord + 1));
            hashWord = 0;
            startIndexWord = i + 1;
        }

        return uniqueSegments;
    }
}
