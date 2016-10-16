package com.vchernogorov.graphs.algorithm

import com.vchernogorov.graphs.storage.Graph

internal class FindMinimumSpanningTree<T>(val graph: Graph<T>): Algorithm<Graph<T>>(Graph<T>()) {

    override fun run() {
        algorithmBoruvka()
    }

    fun algorithmBoruvka() {
        // TODO
    }
}