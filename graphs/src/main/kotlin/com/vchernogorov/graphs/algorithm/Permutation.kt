package com.vchernogorov.graphs.algorithm

import java.util.*

class Permutation(val size: Int,
        val permutation: MutableList<Int> = {
            val array = Array<Int>(size, { i -> i + 1 })
            mutableListOf(*array, 0) }.invoke(),
        val lastPermutation: List<Int> = {
            val array = Array<Int>(size, { i -> i + 1 }).reversedArray()
            mutableListOf(*array, 0) }.invoke()) {

    fun nextPermutation() {
        val permutationSize = permutation.size - 2

        var i = permutationSize
        while (i >= 0 && permutation[i] > permutation[i + 1]) i--
        if (i < 0) return

        var j = permutationSize
        while (permutation[i] > permutation[j]) j--
        Collections.swap(permutation, i, j)

        var k = i + 1
        var r = permutationSize
        while (r > k) Collections.swap(permutation, r--, k++)
    }
}