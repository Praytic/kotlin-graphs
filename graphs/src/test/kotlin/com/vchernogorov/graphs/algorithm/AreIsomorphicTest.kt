package com.vchernogorov.graphs.algorithm

import com.vchernogorov.graphs.storage.Edge
import com.vchernogorov.graphs.storage.Graph
import com.vchernogorov.graphs.storage.Vertex
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.util.*

class AreIsomorphicTest {

    @Test
    fun equalGraphs() {
        val graph1 = Graph<Int>()
        Assertions.assertTrue(areIsomorphic(graph1, graph1))
        val graph2 = Graph<Double>()
        Assertions.assertTrue(areIsomorphic(graph1, graph2))
    }

    @Test
    fun equalVerticesSize() {
        val random = Random()
        val graph1 = Graph<Int>()
        val graph2 = Graph<Double>()
        graph1.vertices.add(Vertex<Int>(random.nextInt()))
        Assertions.assertFalse(areIsomorphic(graph1, graph2))
        graph2.vertices.add(Vertex<Double>(random.nextDouble()))
        Assertions.assertTrue(areIsomorphic(graph1, graph2))
        graph1.vertices.add(Vertex<Int>(random.nextInt()))
        graph2.vertices.add(Vertex<Double>(random.nextDouble()))
        Assertions.assertTrue(areIsomorphic(graph1, graph2))
    }

    @Test
    fun equalEdgesSize() {
        val random = Random()
        val graph1 = Graph<Int>()
        val graph2 = Graph<Double>()
        val vertex11 = Vertex<Int>(random.nextInt())
        val vertex12 = Vertex<Int>(random.nextInt())
        val vertex21 = Vertex<Double>(random.nextDouble())
        val vertex22 = Vertex<Double>(random.nextDouble())
        val edge1 = Edge<Int>(vertex11, vertex12)
        val edge2 = Edge<Double>(vertex21, vertex22)
        graph1.vertices.add(vertex11)
        graph1.vertices.add(vertex12)
        graph2.vertices.add(vertex21)
        graph2.vertices.add(vertex22)
        graph1.edges.add(edge1)
        Assertions.assertFalse(areIsomorphic(graph1, graph2))
        graph2.edges.add(edge2)
        Assertions.assertTrue(areIsomorphic(graph1, graph2))
    }

    @Test
    fun isomorphicGraphs() {
        val random = Random()
        val graph1 = {
            val graph = Graph<Int>()
            val vertex1 = Vertex<Int>(random.nextInt())
            val vertex2 = Vertex<Int>(random.nextInt())
            val vertex3 = Vertex<Int>(random.nextInt())
            val edge1 = Edge<Int>(vertex1, vertex2)
            val edge2 = Edge<Int>(vertex1, vertex3)
            graph.vertices.add(vertex1)
            graph.vertices.add(vertex2)
            graph.vertices.add(vertex3)
            graph.edges.add(edge1)
            graph.edges.add(edge2)
            graph
        }.invoke()
        val graph2 = {
            val graph = Graph<Double>()
            val vertex1 = Vertex<Double>(random.nextDouble())
            val vertex2 = Vertex<Double>(random.nextDouble())
            val vertex3 = Vertex<Double>(random.nextDouble())
            val edge1 = Edge<Double>(vertex3, vertex2)
            val edge2 = Edge<Double>(vertex3, vertex1)
            graph.vertices.add(vertex1)
            graph.vertices.add(vertex2)
            graph.vertices.add(vertex3)
            graph.edges.add(edge1)
            graph.edges.add(edge2)
            graph
        }.invoke()
        Assertions.assertTrue(areIsomorphic(graph1, graph2))
    }
}
