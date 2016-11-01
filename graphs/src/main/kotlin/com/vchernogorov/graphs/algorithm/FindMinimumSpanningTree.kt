package com.vchernogorov.graphs.algorithm

import com.vchernogorov.graphs.storage.Graph

internal class FindMinimumSpanningTree<T>(graph: Graph<T>) : GraphAlgorithm<T, Graph<T>>(graph) {

    override var result = Graph<T>()

    override fun run() {
        boruvka()
    }

    fun boruvka() {
        // TODO
    }
}