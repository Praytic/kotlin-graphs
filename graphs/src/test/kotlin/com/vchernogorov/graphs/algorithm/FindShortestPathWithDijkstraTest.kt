package com.vchernogorov.graphs.algorithm

import com.vchernogorov.graphs.storage.Edge
import com.vchernogorov.graphs.storage.Graph
import com.vchernogorov.graphs.storage.Vertex
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class FindShortestPathWithDijkstraTest {

    @Test
    fun emptyGraph() {
        val graph = Graph<Int>()
        Assertions.assertTrue(findShortestPathWithDijkstra(graph, Vertex(0), Vertex(1)).isEmpty())
    }

    @Test
    fun sameVertex() {
        val graph = Graph<Int>()
        val vertex = Vertex<Int>(0)
        graph.vertices.add(vertex)
        Assertions.assertTrue(findShortestPathWithDijkstra(graph, vertex, vertex).isEmpty())
    }

    @Test
    fun unconnectedVertices() {
        val graph = Graph<Int>()
        val vertex1 = Vertex<Int>(0)
        val vertex2 = Vertex<Int>(1)
        graph.vertices.add(vertex1)
        graph.vertices.add(vertex2)
        Assertions.assertTrue(findShortestPathWithDijkstra(graph, vertex1, vertex2).isEmpty())
    }

    @Test
    fun singlePath() {
        val graph = Graph<Int>()
        val vertex1 = Vertex<Int>(0)
        val vertex2 = Vertex<Int>(1)
        graph.vertices.add(vertex1)
        graph.vertices.add(vertex2)
        val edge = Edge<Int>(vertex1, vertex2, 1)
        graph.edges.add(edge)
        Assertions.assertEquals(1, findShortestPathWithDijkstra(graph, vertex1, vertex2).size)
        Assertions.assertTrue(findShortestPathWithDijkstra(graph, vertex2, vertex1).isEmpty())
        val edge1 = Edge<Int>(vertex2, vertex1, 1)
        graph.edges.add(edge1)
        Assertions.assertEquals(1, findShortestPathWithDijkstra(graph, vertex2, vertex1).size)
    }

    @Test
    // TODO
    fun multiplePaths() {
        val graph = Graph<Int>()
        val vertex1 = Vertex<Int>(0)
        val vertex2 = Vertex<Int>(1)
        val vertex3 = Vertex<Int>(2)
        val vertex4 = Vertex<Int>(3)
        graph.vertices.add(vertex1)
        graph.vertices.add(vertex2)
        graph.vertices.add(vertex3)
        graph.vertices.add(vertex4)
        val edge12 = Edge<Int>(vertex1, vertex2, 4)
        val edge24 = Edge<Int>(vertex1, vertex2, 2)
        val edge13 = Edge<Int>(vertex1, vertex2, 3)
        val edge34 = Edge<Int>(vertex1, vertex2, 1)
        graph.edges.add(edge12)
        graph.edges.add(edge24)
        graph.edges.add(edge13)
        graph.edges.add(edge34)
        val shortestPath = findShortestPathWithDijkstra(graph, vertex1, vertex2)
        val pathCost = shortestPath.sumBy { it.cost }
        Assertions.assertEquals(4, pathCost)
    }
}