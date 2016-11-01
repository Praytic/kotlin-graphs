package com.vchernogorov.graphs.algorithm

import com.vchernogorov.graphs.storage.Edge
import com.vchernogorov.graphs.storage.Graph
import com.vchernogorov.graphs.storage.Vertex
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class FindAllPathsWithDfsTest {

    @Test
    fun emptyGraph() {
        val graph = Graph<Int>()
        Assertions.assertTrue(findAllPathsWithDfs(graph, Vertex(0), Vertex(1)).isEmpty())
    }

    @Test
    fun sameVertex() {
        val graph = Graph<Int>()
        val vertex = Vertex<Int>(0)
        graph.vertices.add(vertex)
        Assertions.assertTrue(findAllPathsWithDfs(graph, vertex, vertex).isEmpty())
    }

    @Test
    fun unconnectedVertices() {
        val graph = Graph<Int>()
        val vertex1 = Vertex<Int>(0)
        val vertex2 = Vertex<Int>(1)
        graph.vertices.add(vertex1)
        graph.vertices.add(vertex2)
        Assertions.assertTrue(findAllPathsWithDfs(graph, vertex1, vertex2).isEmpty())
        val edge = Edge<Int>(vertex2, vertex1)
        Assertions.assertTrue(findAllPathsWithDfs(graph, vertex1, vertex2).isEmpty())
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
        Assertions.assertEquals(1, findAllPathsWithDfs(graph, vertex1, vertex2).size)
        Assertions.assertTrue(findAllPathsWithDfs(graph, vertex2, vertex1).isEmpty())
        val edge1 = Edge<Int>(vertex2, vertex1)
        graph.edges.add(edge1)
        Assertions.assertEquals(1, findAllPathsWithDfs(graph, vertex2, vertex1).size)
    }

    @Test
    fun multiplePaths() {
        val graph = Graph<Int>()
        val vertex1 = Vertex<Int>(0)
        val vertex2 = Vertex<Int>(1)
        graph.vertices.add(vertex1)
        graph.vertices.add(vertex2)
        val edge1 = Edge<Int>(vertex1, vertex2, 0)
        val edge2 = Edge<Int>(vertex1, vertex2, 1)
        graph.edges.add(edge1)
        graph.edges.add(edge2)
        Assertions.assertEquals(2, findAllPathsWithDfs(graph, vertex1, vertex2).size)
        val vertex3 = Vertex<Int>(3)
        graph.vertices.add(vertex3)
        val edge3 = Edge<Int>(vertex1, vertex3)
        graph.edges.add(edge3)
        Assertions.assertEquals(1, findAllPathsWithDfs(graph, vertex1, vertex3).size)
        Assertions.assertEquals(2, findAllPathsWithDfs(graph, vertex1, vertex2).size)
        val edge4 = Edge<Int>(vertex3, vertex2)
        graph.edges.add(edge4)
        Assertions.assertEquals(3, findAllPathsWithDfs(graph, vertex1, vertex2).size)
    }
}