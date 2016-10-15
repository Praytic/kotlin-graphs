package com.vchernogorov.graphs.algorithm

import com.vchernogorov.graphs.storage.Graph
import com.vchernogorov.graphs.storage.Vertex

internal class DepthFirstSearch<T>(val graph: Graph<T>, val onFindUnvisitedVertex: (Vertex<T>) -> Unit = {},
                                   val onFindVisitedVertex: (Vertex<T>) -> Unit = {},
                                   var startVertex: Vertex<T> = graph.vertices.first()): Algorithm<Unit>(Unit) {
    override fun run() {
        if (graph.vertices.isNotEmpty()) {
            val visitedVertices = graph.getVisitedMap()
            fun recursiveDfs(currentVertex: Vertex<T>) {
                visitedVertices[currentVertex] = true
                onFindUnvisitedVertex(currentVertex)
                for (edge in graph.getOutgoingEdges(currentVertex)) {
                    if (!visitedVertices[edge.to]!!) {
                        recursiveDfs(edge.to)
                    }
                    onFindVisitedVertex(currentVertex)
                }
            }
            recursiveDfs(startVertex)
        }
    }
}