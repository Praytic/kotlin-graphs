package com.vchernogorov.graphs.algorithm

import com.vchernogorov.graphs.storage.Edge
import com.vchernogorov.graphs.storage.Graph
import com.vchernogorov.graphs.storage.Vertex

internal class DepthFirstSearch<T>(val graph: Graph<T>,
                                   val startVertex: Vertex<T>,
                                   var onFindUnvisitedVertex: (Vertex<T>, Edge<T>?) -> Unit,
                                   var onFindVisitedVertex: (Vertex<T>, Edge<T>) -> Unit):
        Algorithm<Unit>(Unit) {
    constructor(graph: Graph<T>): this(graph, graph.vertices.first())
    constructor(graph: Graph<T>, startVertex: Vertex<T>): this(graph, startVertex,
            { vertex, edge -> }, { vertex, edge -> })

    override fun run() {
        if (!graph.vertices.isNotEmpty()) return
        if (graph.getOutgoingEdges(startVertex).isEmpty()) {
            onFindUnvisitedVertex(startVertex, null)
            return
        }
        val visitedVertices = graph.getVisitedMap()
        fun recursiveDfs(currentVertex: Vertex<T>, currentEdge: Edge<T>?) {
            visitedVertices[currentVertex] = true
            onFindUnvisitedVertex(currentVertex, currentEdge)
            for (edge in graph.getOutgoingEdges(currentVertex)) {
                val nextVertex = edge.to
                if (!visitedVertices[nextVertex]!!) {
                    recursiveDfs(nextVertex, edge)
                }
                visitedVertices[nextVertex] = false
                onFindVisitedVertex(nextVertex, edge)
            }
        }
        recursiveDfs(startVertex, null)
    }
}