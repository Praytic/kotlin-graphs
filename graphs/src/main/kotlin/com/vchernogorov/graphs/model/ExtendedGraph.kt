package com.vchernogorov.graphs.model

import com.vchernogorov.graphs.algorithm.INF

class ExtendedGraph<T>(graph: Graph<T>) : Graph<T>(graph) {

    val visited by lazy {
        val visitedVertices = hashMapOf<Vertex<T>, Boolean>()
        visitedVertices.putAll(vertices.associateBy({ it }, { false }))
        visitedVertices
    }
    val predecessor by lazy {
        val predecessorVertices = hashMapOf<Vertex<T>, Vertex<T>?>()
        predecessorVertices.putAll(vertices.associateBy( { it }, { null } ))
        predecessorVertices
    }
    val distance by lazy {
        val distanceVertices = hashMapOf<Vertex<T>, Int>()
        distanceVertices.putAll(vertices
                .associateBy( { it }, { if (startVertex == it) 0 else INF } ))
        distanceVertices
    }

    lateinit var startVertex: Vertex<T>
}