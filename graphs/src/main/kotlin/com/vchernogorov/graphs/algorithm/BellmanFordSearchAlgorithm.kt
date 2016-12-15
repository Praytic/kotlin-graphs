package com.vchernogorov.graphs.algorithm

import com.vchernogorov.graphs.storage.Edge
import com.vchernogorov.graphs.storage.Graph
import com.vchernogorov.graphs.storage.Vertex
import java.util.*

class BellmanFordSearchAlgorithm<T>(graph: Graph<T>,
                                    val startVertex: Vertex<T>,
                                    val endVertices: Set<Vertex<T>>,
                                    var onRelaxEdge: (Edge<T>) -> Unit = { })
    : FindShortestPathsAlgorithm<T>(graph, startVertex, endVertices) {

    constructor(graph: Graph<T>): this(graph, graph.vertices.first(),
            graph.vertices.filter { it != graph.vertices.first() }.toSet())

    val distance = HashMap<Vertex<T>, Int>(graph
            .vertices
            .associateBy( { it }, { if (startVertex == it) 0 else INF } ))
    val predecessor = HashMap<Vertex<T>, Vertex<T>?>(graph
            .vertices
            .associateBy( { it }, { null } ))

    override fun findShortestPaths() {
        relaxEdgesRepeatedly()
        checkForNegativeWeightCycles()
    }

    fun relaxEdgesRepeatedly() {
        for (i in 1 .. n - 1) {
            for (edge in graph.edges.sortedBy { it.from == startVertex }) {
                if (distance[edge.from]!! + edge.cost < distance[edge.to]!!) {
                    distance[edge.to] = distance[edge.from]!! + edge.cost
                    predecessor[edge.to] = predecessor[edge.from]
                    onRelaxEdge.invoke(edge)
                }
            }
        }
    }

    fun checkForNegativeWeightCycles() {
        for (edge in graph.edges) {
            if (distance[edge.from]!! + edge.cost < distance[edge.to]!!) {
                throw IllegalStateException("Graph contains a negative-weight cycle")
            }
        }
    }
}