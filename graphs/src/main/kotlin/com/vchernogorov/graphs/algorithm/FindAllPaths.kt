package com.vchernogorov.graphs.algorithm

import com.vchernogorov.graphs.storage.Edge
import com.vchernogorov.graphs.storage.Graph
import com.vchernogorov.graphs.storage.Vertex

internal abstract class FindAllPaths<T>(graph: Graph<T>, val from: Vertex<T>, val to: Vertex<T>)
        : GraphAlgorithm<T, MutableSet<Set<Edge<T>>>>(graph) {

    override var result = mutableSetOf<Set<Edge<T>>>()

    override fun run() {
        if (hasPath()) {
            findAllPaths()
        }
    }

    fun hasPath(): Boolean {
        return !from.equals(to) &&
                graph.getOutgoingEdges(from).isNotEmpty() &&
                graph.getIncomingEdges(to).isNotEmpty();
    }

    abstract fun findAllPaths()
}