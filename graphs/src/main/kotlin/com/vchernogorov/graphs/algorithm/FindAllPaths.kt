package com.vchernogorov.graphs.algorithm

import com.vchernogorov.graphs.storage.Edge
import com.vchernogorov.graphs.storage.Graph
import com.vchernogorov.graphs.storage.Vertex
import java.util.*

internal class FindAllPaths<T>(val graph: Graph<T>, val from: Vertex<T>, val to: Vertex<T>):
        Algorithm<MutableSet<Set<Edge<T>>>>(mutableSetOf()) {

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

    fun findAllPaths() {
        val currentPath = mutableSetOf<Edge<T>>()
        val dfs = DepthFirstSearch(graph, from)
        dfs.onEnterUnvisitedVertex = { vertex, edge -> if (edge != null) currentPath.add(edge) }
        dfs.onExitVisitedVertex = { vertex, edge ->
            if (vertex == to) result.add(HashSet(currentPath))
            currentPath.remove(edge)
        }
        dfs.run()
    }
}