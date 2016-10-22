package com.vchernogorov.graphs.storage

import java.util.*

class Permutation(val size: Int,
        var current: MutableList<Int> = {
            val array = Array<Int>(size, { it })
            mutableListOf(*array) }.invoke(),
        val last: List<Int> = {
            val array = Array<Int>(size, { it }).reversedArray()
            mutableListOf(*array) }.invoke()) {

    fun next(): List<Int> {
        val perm = ArrayList(current)
        perm.add(Int.MIN_VALUE)
        val permutationSize = perm.size - 2

        var i = permutationSize
        while (i >= 0 && perm[i] > perm[i + 1]) i--
        if (i < 0) return current

        var j = permutationSize
        while (perm[i] > perm[j]) j--
        Collections.swap(perm, i, j)

        var k = i + 1
        var r = permutationSize
        while (r > k) Collections.swap(perm, r--, k++)
        current = perm.subList(0, size)
        return current
    }
}