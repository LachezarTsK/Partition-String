
package main
import "math"

const ALPHABET_SIZE = 26
var MODULO_VALUE int = int(math.Pow(10.0, 9.0)) + 7

func partitionString(input string) []string {
    uniqueSegments := []string{}
    dictionary := NewHashSet()

    var hashWord int64 = 0
    startIndexWord := 0

    for i := range input {

        hashWord *= ALPHABET_SIZE
        hashWord += 1 + int64(input[i] - 'a')
        hashWord %= int64(MODULO_VALUE)

        if dictionary.Contains(int(hashWord)) {
            continue
        }

        dictionary.Add(int(hashWord))
        uniqueSegments = append(uniqueSegments, input[startIndexWord:i + 1])
        hashWord = 0
        startIndexWord = i + 1
    }

    return uniqueSegments
}

type HashSet struct {
    conainer map[int]bool
}

func NewHashSet() HashSet {
    return HashSet{conainer: map[int]bool{}}
}

func (this *HashSet) Contains(value int) bool {
    return this.conainer[value]
}

func (this *HashSet) Add(value int) {
    this.conainer[value] = true
}

func (this *HashSet) Remove(value int) {
    delete(this.conainer, value)
}
