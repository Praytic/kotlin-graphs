package com.vchernogorov.graphs.storage

class Graph<T>(val vertices: MutableSet<Vertex<T>>,
               val edges: MutableSet<Edge<T>>) {
    constructor(): this(mutableSetOf(), mutableSetOf())
    constructor(graph: Graph<T>): this(graph.vertices, graph.edges)

    fun getIncomingEdges(vertex: Vertex<T>): Set<Edge<T>> {
        return edges.filter { edge -> edge.to === vertex }.toHashSet()
    }

    fun getOutgoingEdges(vertex: Vertex<T>): Set<Edge<T>> {
        return edges.filter { edge -> edge.from === vertex }.toHashSet()
    }

    fun addComponent(graph: Graph<T>) {
        vertices.addAll(graph.vertices)
        edges.addAll(graph.edges)
    }

    fun getVisitedMap(): MutableMap<Vertex<T>, Boolean> {
        val visitedVertices = mutableMapOf<Vertex<T>, Boolean>()
        visitedVertices.putAll(vertices.associateBy({ it }, { false }))
        return visitedVertices
    }

    fun findEdge(vertex1: Vertex<T>, vertex2: Vertex<T>): Edge<T>? {
        return edges.find { it.from == vertex1 && it.to == vertex2 }
    }
}