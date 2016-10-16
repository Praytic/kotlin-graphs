package com.vchernogorov.graphs.algorithm

import com.vchernogorov.graphs.storage.Graph

internal class IsForest<T>(val graph: Graph<T>): Algorithm<Boolean>(false) {

    override fun run() {
        if (graph.vertices.isEmpty()) {
            return
        }
        var visitedCount = 0
        val visitedVertices = graph.getVisitedMap()
        for (vertex in graph.vertices) {
            if (!visitedVertices[vertex]!!) {
                var hasCycle = false
                val dfs = DepthFirstSearch(graph, vertex)
                dfs.onEnterUnvisitedVertex = { v, e -> visitedCount++; visitedVertices[vertex] = true }
                dfs.onFindVisitedVertex = { v, e -> hasCycle = true }
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