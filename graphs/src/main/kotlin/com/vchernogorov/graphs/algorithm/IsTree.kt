package com.vchernogorov.graphs.algorithm

import com.vchernogorov.graphs.storage.Graph

internal class IsTree<T>(val graph: Graph<T>): Algorithm<Boolean>(false) {

    override fun run() {
        if (graph.vertices.size - 1 === graph.edges.size) {
            var visitedCount = 0
            var hasCycle = false
            val dfs = DepthFirstSearch(graph)
            dfs.onEnterUnvisitedVertex = { vertex, edge -> visitedCount++ }
            dfs.onFindVisitedVertex = { v, e -> hasCycle = true }
            dfs.run()
            if (hasCycle) {
                result = false
                return
            }
            if (visitedCount === graph.vertices.size) {
                result = true
            }
        }
    }
}