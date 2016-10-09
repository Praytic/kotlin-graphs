package com.vchernogorov.graphs.algorithm

import com.vchernogorov.graphs.storage.Graph
import com.vchernogorov.graphs.storage.Vertex

internal class FindAllPaths<T>(val graph: Graph<T>, val from: Vertex<T>, val to: Vertex<T>):
        Algorithm<Set<Vertex<T>>>(emptySet<Vertex<T>>()) {

    override fun run() {
        if (havePath()) {
            findAllPaths()
        }
    }

    fun havePath(): Boolean {
        return !from.equals(to) &&
                graph.getOutgoingEdges(from).isNotEmpty() &&
                graph.getIncomingEdges(to).isNotEmpty();
    }

    fun findAllPaths() {
        // TODO: Implement
    }
}