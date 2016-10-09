package com.vchernogorov.graphs.algorithm

import com.vchernogorov.graphs.storage.Graph

internal class IsForest<T>(val graph: Graph<T>): Algorithm<Boolean>(false) {

    override fun run() {
        if (graph.vertices.isEmpty()) {
            return
        }
        var visitedCount = 0
        for (vertex in graph.vertices) {
            if (!vertex.visited) {
                var hasCycle = false
                val dfs = DepthFirstSearch(graph, { visitedCount++ }, { hasCycle = true }, vertex)
                dfs.run()
                if (hasCycle) {
                    result = false
                    return
                }
            }
        }
        if (visitedCount === graph.vertices.size) {
            result = true
        }
    }
}