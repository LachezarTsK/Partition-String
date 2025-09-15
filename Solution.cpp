
#include <cmath>
#include <vector>
#include <string>
#include <unordered_set>
using namespace std;

class Solution {

    static const int ALPHABET_SIZE = 26;
    inline static int MODULO_VALUE = pow(10, 9) + 7;

public:
    vector<string> partitionString(const string& input) const {
        vector<string> uniqueSegments;
        unordered_set<int> dictionary;

        long long hashWord = 0;
        int startIndexWord = 0;

        for (int i = 0; i < input.length(); ++i) {

            hashWord *= ALPHABET_SIZE;
            hashWord += 1 + input[i] - 'a';
            hashWord %= MODULO_VALUE;

            if (dictionary.contains(hashWord)) {
                continue;
            }

            dictionary.insert(hashWord);
            uniqueSegments.push_back(input.substr(startIndexWord, i - startIndexWord + 1));
            hashWord = 0;
            startIndexWord = i + 1;
        }

        return uniqueSegments;
    }
};
