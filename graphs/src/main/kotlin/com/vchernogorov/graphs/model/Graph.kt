package com.vchernogorov.graphs.model

open class Graph<T>() {
    constructor(vertices: MutableSet<Vertex<T>>, edges: MutableSet<Edge<T>>) : this() {
        this.vertices.addAll(vertices)
        this.edges.addAll(edges)
    }
    constructor(graph: Graph<T>): this(graph.vertices, graph.edges)

    val vertices = mutableSetOf<Vertex<T>>()
    val edges = mutableSetOf<Edge<T>>()

    open fun addComponent(graph: Graph<T>) {
        vertices.addAll(graph.vertices)
        edges.addAll(graph.edges)
    }

    operator fun get(vertex1: Vertex<T>, vertex2: Vertex<T>) = edges.find { it.from == vertex1 && it.to == vertex2 }
    operator fun get(vertex: Vertex<T>) = edges.filter { edge -> edge.from === vertex }.toHashSet()
}