package com.vchernogorov.graphs.algorithm

import com.vchernogorov.graphs.storage.Edge
import com.vchernogorov.graphs.storage.Graph
import com.vchernogorov.graphs.storage.Vertex

abstract class FindShortestPathsAlgorithm<T>(graph: Graph<T>, val from: Vertex<T>, val to: Set<Vertex<T>>)
        : GraphAlgorithm<T, Set<Set<Edge<T>>>>(graph) {

    override var result = setOf<Set<Edge<T>>>()

    override fun run() {
        if (hasPaths()) {
            findShortestPaths()
        }
    }

    fun hasPaths(): Boolean {
        var hasPaths = graph.getOutgoingEdges(from).isNotEmpty()
        for (vertex in to) {
            hasPaths = !from.equals(vertex) && graph.getIncomingEdges(vertex).isNotEmpty()
        }
        return hasPaths
    }

    abstract fun findShortestPaths()
}