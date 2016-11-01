package com.vchernogorov.graphs.algorithm

import com.vchernogorov.graphs.storage.Edge
import com.vchernogorov.graphs.storage.Graph
import com.vchernogorov.graphs.storage.Vertex
import java.util.*

internal class FindAllPathsWithDfs<T>(graph: Graph<T>, from: Vertex<T>, to: Vertex<T>)
    : FindAllPaths<T>(graph, from, to) {

    override fun findAllPaths() {
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