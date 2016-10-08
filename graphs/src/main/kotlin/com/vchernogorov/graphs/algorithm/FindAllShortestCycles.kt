package com.vchernogorov.graphs.algorithm

import com.vchernogorov.graphs.storage.Graph
import com.vchernogorov.graphs.storage.Vertex

internal class FindAllShortestCycles<T>(val graph: Graph<T>): Algorithm<Set<Set<Vertex<T>>>>(mutableSetOf()) {

    override fun run() {
        throw UnsupportedOperationException()
    }
}