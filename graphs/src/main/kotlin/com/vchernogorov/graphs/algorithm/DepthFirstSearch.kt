package com.vchernogorov.graphs.algorithm

import com.vchernogorov.graphs.storage.Graph
import com.vchernogorov.graphs.storage.Vertex

internal class DepthFirstSearch<T>(val graph: Graph<T>, val action: (Vertex<T>) -> Unit,
                                   var startVertex: Vertex<T> = graph.verticies.first()): Algorithm<Unit>(Unit) {
    override fun run() {
        if (graph.verticies.isNotEmpty()) {
            fun recursiveDfs(currentVertex: Vertex<T>) {
                currentVertex.visited = true
                action(currentVertex)
                for (edge in graph.getOutgoingEdges(currentVertex)) {
                    if (!edge.to.visited) {
                        recursiveDfs(edge.to)
                    }
                }
            }
            recursiveDfs(startVertex)
        }
    }
}