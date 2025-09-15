
function partitionString(input: string): string[] {
    const ALPHABET_SIZE = 26;
    const ASCII_SMALL_CASE_A = 97;
    const MODULO_VALUE = Math.pow(10, 9) + 7;

    const uniqueSegments = new Array<string>();
    const dictionary = new Set<number>();

    let hashWord = 0;
    let startIndexWord = 0;

    for (let i = 0; i < input.length; ++i) {

        hashWord *= ALPHABET_SIZE;
        hashWord += 1 + input.codePointAt(i) - ASCII_SMALL_CASE_A;
        hashWord %=  MODULO_VALUE;

        if (dictionary.has(hashWord)) {
            continue;
        }

        dictionary.add(hashWord);
        uniqueSegments.push(input.substring(startIndexWord, i + 1));
        hashWord = 0;
        startIndexWord = i + 1;
    }

    return uniqueSegments;
};
