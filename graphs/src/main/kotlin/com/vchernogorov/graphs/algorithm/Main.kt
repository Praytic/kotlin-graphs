package com.vchernogorov.graphs.algorithm

fun main(args: Array<String>) {
    val permutation = Permutation(6);
    while (permutation.permutation != permutation.lastPermutation) {
        permutation.nextPermutation()
        println(permutation.permutation)
    }
}