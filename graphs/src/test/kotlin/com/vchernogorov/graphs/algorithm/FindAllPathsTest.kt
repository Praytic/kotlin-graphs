package com.vchernogorov.graphs.algorithm

import com.vchernogorov.graphs.storage.Edge
import com.vchernogorov.graphs.storage.Graph
import com.vchernogorov.graphs.storage.Vertex
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class FindAllPathsTest {

    @Test
    fun emptyGraph() {
        val graph = Graph<Int>()
        Assertions.assertTrue(findAllPaths(graph, Vertex(0), Vertex(1)).isEmpty())
    }

    @Test
    fun sameVertex() {
        val graph = Graph<Int>()
        val vertex = Vertex<Int>(0)
        graph.vertices.add(vertex)
        Assertions.assertTrue(findAllPaths(graph, vertex, vertex).isEmpty())
    }

    @Test
    fun unconnectedVertices() {
        val graph = Graph<Int>()
        val vertex1 = Vertex<Int>(0)
        val vertex2 = Vertex<Int>(1)
        graph.vertices.add(vertex1)
        graph.vertices.add(vertex2)
        Assertions.assertTrue(findAllPaths(graph, vertex1, vertex2).isEmpty())
        val edge = Edge<Int>(vertex2, vertex1)
        Assertions.assertTrue(findAllPaths(graph, vertex1, vertex2).isEmpty())
    }

    @Test
    fun singlePath() {
        val graph = Graph<Int>()
        val vertex1 = Vertex<Int>(0)
        val vertex2 = Vertex<Int>(1)
        graph.vertices.add(vertex1)
        graph.vertices.add(vertex2)
        val edge = Edge<Int>(vertex1, vertex2)
        graph.edges.add(edge)
        Assertions.assertEquals(1, findAllPaths(graph, vertex1, vertex2).size)
        Assertions.assertTrue(findAllPaths(graph, vertex2, vertex1).isEmpty())
        val edge1 = Edge<Int>(vertex2, vertex1)
        graph.edges.add(edge1)
        Assertions.assertEquals(1, findAllPaths(graph, vertex2, vertex1).size)
    }

    @Test
    fun multiplePaths() {
        val graph = Graph<Int>()
        val vertex1 = Vertex<Int>(0)
        val vertex2 = Vertex<Int>(1)
        graph.vertices.add(vertex1)
        graph.vertices.add(vertex2)
        val edge = Edge<Int>(vertex1, vertex2)
        graph.edges.add(edge)
        Assertions.assertEquals(1, findAllPaths(graph, vertex1, vertex2).size)
    }
}