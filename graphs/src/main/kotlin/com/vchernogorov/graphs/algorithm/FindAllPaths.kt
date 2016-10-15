package com.vchernogorov.graphs.algorithm

import com.vchernogorov.graphs.storage.Graph
import com.vchernogorov.graphs.storage.Vertex

internal class FindAllPaths<T>(val graph: Graph<T>, val from: Vertex<T>, val to: Vertex<T>):
        Algorithm<MutableSet<Set<Vertex<T>>>>(mutableSetOf()) {

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
        val currentPath = mutableSetOf<Vertex<T>>()
        val dfs = DepthFirstSearch<T>(graph, { vertex -> {
            currentPath.add(vertex)
            if (vertex == to) result.add(currentPath)
        }}, { vertex -> currentPath.remove(vertex)}, from)
        dfs.run()
    }
}