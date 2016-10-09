package com.vchernogorov.graphs.algorithm

import com.vchernogorov.graphs.storage.Graph
import com.vchernogorov.graphs.storage.Vertex

internal class DepthFirstSearch<T>(val graph: Graph<T>, val onFindUnvisitedVertex: (Vertex<T>) -> Unit = {},
                                   val onFindVisitedVertex: (Vertex<T>) -> Unit = {},
                                   var startVertex: Vertex<T> = graph.vertices.first()): Algorithm<Unit>(Unit) {
    override fun run() {
        if (graph.vertices.isNotEmpty()) {
            fun recursiveDfs(currentVertex: Vertex<T>) {
                currentVertex.visited = true
                onFindUnvisitedVertex(currentVertex)
                for (edge in graph.getOutgoingEdges(currentVertex)) {
                    if (!edge.to.visited) {
                        recursiveDfs(edge.to)
                    }
                    else {
                        onFindVisitedVertex(currentVertex)
                    }
                }
            }
            recursiveDfs(startVertex)
        }
    }
}