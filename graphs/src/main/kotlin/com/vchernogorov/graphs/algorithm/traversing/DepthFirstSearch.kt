package com.vchernogorov.graphs.algorithm.traversing

import com.vchernogorov.graphs.model.Edge
import com.vchernogorov.graphs.model.ExtendedGraph
import com.vchernogorov.graphs.model.Vertex

class DepthFirstSearch<T>(var onEnterUnvisitedVertex: (Vertex<T>, Edge<T>?) -> Unit = { vertex, edge -> },
                          var onFindVisitedVertex: (Vertex<T>, Edge<T>) -> Unit = { vertex, edge -> },
                          var onExitVisitedVertex: (Vertex<T>, Edge<T>?) -> Unit = { vertex, edge -> })
    : TraversingAlgorithm<T>() {

    override fun start(graph: ExtendedGraph<T>) {
        if (graph.vertices.isEmpty()) return
        if (graph[graph.startVertex].isEmpty()) {
            onEnterUnvisitedVertex(graph.startVertex, null)
            return
        }

        fun recursiveDfs(currentVertex: Vertex<T>, currentEdge: Edge<T>?) {
            graph.visited[currentVertex] = true
            onEnterUnvisitedVertex(currentVertex, currentEdge)
            for (edge in graph[currentVertex]) {
                val nextVertex = edge.to
                if (!graph.visited[nextVertex]!!) recursiveDfs(nextVertex, edge)
                else onFindVisitedVertex(nextVertex, edge)
                graph.visited[nextVertex] = false
            }
            onExitVisitedVertex(currentVertex, currentEdge)
        }
        recursiveDfs(graph.startVertex, null)
    }
}