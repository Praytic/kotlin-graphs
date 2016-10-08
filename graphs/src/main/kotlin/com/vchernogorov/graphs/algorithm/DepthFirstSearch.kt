package com.vchernogorov.graphs.algorithm

import com.vchernogorov.graphs.storage.Graph
import com.vchernogorov.graphs.storage.Vertex

internal class DepthFirstSearch<T>(val graph: Graph<T>, val action: (Vertex<T>) -> Unit): Algorithm<Unit>(Unit) {

    override fun run() {
        if (graph.verticies.isNotEmpty()) {
            fun recursiveDfs(currentVertex: Vertex<T>) {
                currentVertex.visited = true
                for (edge in currentVertex.outgoingEdges) {
                    if (!edge.to.visited) {
                        action(edge.to)
                        recursiveDfs(edge.to)
                    }
                }
            }
            recursiveDfs(graph.verticies.first())
        }
    }
}