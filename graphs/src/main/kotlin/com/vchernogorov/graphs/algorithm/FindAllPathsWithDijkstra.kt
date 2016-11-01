package com.vchernogorov.graphs.algorithm

import com.vchernogorov.graphs.storage.Edge
import com.vchernogorov.graphs.storage.Graph
import com.vchernogorov.graphs.storage.Vertex

internal class FindAllPathsWithDijkstra<T>(graph: Graph<T>, from: Vertex<T>, to: Vertex<T>)
    : FindAllPaths<T>(graph, from, to) {

    override var result = mutableSetOf<Set<Edge<T>>>()

    override fun run() {
        throw UnsupportedOperationException()
    }

    override fun findAllPaths() {
        throw UnsupportedOperationException()
    }
}
