package com.vchernogorov.graphs.algorithm

import com.vchernogorov.graphs.storage.Edge
import com.vchernogorov.graphs.storage.Graph
import com.vchernogorov.graphs.storage.Vertex
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class IsTreeTest {

    @Test
    fun zeroVertexGraph() {
        val graph = Graph<Int>()
        Assertions.assertFalse(isTree(graph))
    }

    @Test
    fun oneVertexGraph() {
        val graph = Graph<Int>()
        graph.verticies.add(Vertex<Int>(0))
        Assertions.assertTrue(isTree(graph))
    }

    @Test
    fun twoVerticesGraph() {
        val graph = Graph<Int>()
        val vertex1 = Vertex<Int>(0)
        val vertex2 = Vertex<Int>(1)
        graph.verticies.add(vertex1)
        graph.verticies.add(vertex2)
        val edge = Edge<Int>(vertex1, vertex2)
        graph.edges.add(edge)
        Assertions.assertTrue(isTree(graph))
    }

    @Test
    fun cyclicGraph() {
        val graph = Graph<Int>()
        val vertex1 = Vertex<Int>(0)
        val vertex2 = Vertex<Int>(1)
        val vertex3 = Vertex<Int>(2)
        graph.verticies.add(vertex1)
        graph.verticies.add(vertex2)
        graph.verticies.add(vertex3)
        val edge1 = Edge<Int>(vertex1, vertex2)
        val edge2 = Edge<Int>(vertex1, vertex3)
        val edge3 = Edge<Int>(vertex2, vertex3)
        graph.edges.add(edge1)
        graph.edges.add(edge2)
        graph.edges.add(edge3)
        Assertions.assertFalse(isTree(graph))
    }

    @Test
    fun multipleVerticesGraph() {
        val graph = Graph<Int>()
        val mainVertex = Vertex<Int>(0)
        graph.verticies.add(mainVertex)
        for (i in 1..10) {
            val vertex = Vertex<Int>(i)
            val edge = Edge<Int>(mainVertex, vertex)
            graph.verticies.add(vertex)
            graph.edges.add(edge)
        }
        Assertions.assertTrue(isTree(graph))
    }

    @Test
    fun unconnectedGraph() {
        val graph = Graph<Int>()
        val vertex1 = Vertex<Int>(0)
        val vertex2 = Vertex<Int>(1)
        graph.verticies.add(vertex1)
        graph.verticies.add(vertex2)
        Assertions.assertFalse(isTree(graph))
    }
}