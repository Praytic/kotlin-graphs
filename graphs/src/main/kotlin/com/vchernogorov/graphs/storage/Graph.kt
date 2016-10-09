package com.vchernogorov.graphs.storage

/**
 * Created by vchernogorov on 06/09/16.
 */
class Graph<T>(val verticies: MutableSet<Vertex<T>>,
               val edges: MutableSet<Edge<T>>) {
    constructor(): this(mutableSetOf(), mutableSetOf())
    constructor(graph: Graph<T>): this(graph.verticies, graph.edges)

    fun getIncomingEdges(vertex: Vertex<T>): Set<Edge<T>> {
        return edges.filter { edge -> edge.to === vertex }.toHashSet()
    }

    fun getOutgoingEdges(vertex: Vertex<T>): Set<Edge<T>> {
        return edges.filter { edge -> edge.from === vertex }.toHashSet()
    }

    fun addComponent(graph: Graph<T>) {
        verticies.addAll(graph.verticies)
        edges.addAll(graph.edges)
    }
}