package com.vchernogorov.graphs.algorithm

fun main(args: Array<String>) {
    val permutation = Permutation(6);
    while (permutation.current != permutation.last) {
        permutation.next()
        println(permutation.current)
    }
}