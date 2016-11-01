package com.vchernogorov.graphs.algorithm

import com.vchernogorov.graphs.storage.Edge
import com.vchernogorov.graphs.storage.Graph
import com.vchernogorov.graphs.storage.Vertex

internal class FindAllCycles<T>(graph: Graph<T>) : GraphAlgorithm<T, Set<Set<Vertex<T>>>>(graph) {

    override var result = setOf<Set<Vertex<T>>>()

    override fun run() {
        if (hasCycles()) {
            findAllCycles()
        }
    }

    fun hasCycles(): Boolean {
        return graph.vertices.size > 1 && graph.edges.size > 1
    }

    fun findAllCycles() {
        val currentPath = mutableSetOf<Edge<T>>()
        val colored = mutableMapOf<Vertex<T>, Int>()
        val dfs = DepthFirstSearch(graph)
        dfs.run()
    }
}