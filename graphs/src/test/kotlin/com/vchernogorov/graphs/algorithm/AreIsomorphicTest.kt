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
//        Assertions.assertTrue(areIsomorphic(graph1, graph2))
    }
}
