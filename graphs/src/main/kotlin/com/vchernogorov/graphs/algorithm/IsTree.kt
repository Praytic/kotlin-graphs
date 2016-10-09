package com.vchernogorov.graphs.algorithm

import com.vchernogorov.graphs.storage.Graph

internal class IsTree<T>(val graph: Graph<T>): Algorithm<Boolean>(false) {

    override fun run() {
        if (graph.verticies.size - 1 === graph.edges.size) {
            var visitedCount = 0
            val dfs = DepthFirstSearch(graph, { visitedCount++ })
            dfs.run()
            if (visitedCount === graph.verticies.size) {
                result = true
            }
        }
    }
}