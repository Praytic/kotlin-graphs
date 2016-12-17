package com.vchernogorov.graphs.algorithm.traversing

import com.vchernogorov.graphs.algorithm.hasNegativeWeightCycles
import com.vchernogorov.graphs.model.Edge
import com.vchernogorov.graphs.model.ExtendedGraph

class BellmanFordSearch<T>(var onRelaxEdge: (Edge<T>) -> Unit = { })
    : TraversingAlgorithm<T>() {

    override fun start(graph: ExtendedGraph<T>) {
        relaxEdgesRepeatedly(graph)
        if (hasNegativeWeightCycles(graph)) throw IllegalStateException("Graph contains a negative-weight cycle")
    }

    fun relaxEdgesRepeatedly(graph: ExtendedGraph<T>) {
        val size = graph.vertices.size
        for (i in 1 .. size - 1) {
            for (edge in graph.edges.sortedBy { it.from == graph.startVertex }) {
                if (graph.distance[edge.from]!! + edge.cost < graph.distance[edge.to]!!) {
                    graph.distance[edge.to] = graph.distance[edge.from]!! + edge.cost
                    graph.predecessor[edge.to] = graph.predecessor[edge.from]
                    onRelaxEdge.invoke(edge)
                }
            }
        }
    }
}