package com.vchernogorov.graphs.algorithm

import com.vchernogorov.graphs.storage.Edge
import com.vchernogorov.graphs.storage.Graph
import com.vchernogorov.graphs.storage.Vertex

internal abstract class FindShortestPaths<T>(graph: Graph<T>, val from: Vertex<T>, val to: Vertex<T>)
        : GraphAlgorithm<T, MutableSet<Edge<T>>>(graph) {

    override var result = mutableSetOf<Edge<T>>()

    override fun run() {
        if (hasPath()) {
            findShortestPath()
        }
    }

    fun hasPath(): Boolean {
        return !from.equals(to) &&
                graph.getOutgoingEdges(from).isNotEmpty() &&
                graph.getIncomingEdges(to).isNotEmpty();
    }

    abstract fun findShortestPath()
}