package com.vchernogorov.graphs.algorithm

import com.vchernogorov.graphs.storage.Graph

internal class IsTree<T>(val graph: Graph<T>): Algorithm<Boolean>(true) {

    override fun run() {
        if (graph.verticies.size !== graph.edges.size - 1) {
            result = false
        }
        else {
            var visitedCount = 0
            val dfs = DepthFirstSearch(graph, { visitedCount++ })
            dfs.run()
            if (visitedCount === graph.verticies.size) {
                result = false
            }
        }
    }
}