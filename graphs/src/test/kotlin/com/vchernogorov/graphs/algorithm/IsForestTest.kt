package com.vchernogorov.graphs.algorithm

import com.vchernogorov.graphs.storage.Edge
import com.vchernogorov.graphs.storage.Graph
import com.vchernogorov.graphs.storage.Vertex
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.util.*

class IsForestTest {

    @Test
    fun zeroTrees() {
        val graph = Graph<Int>()
        Assertions.assertFalse(isForest(graph))
    }

    @Test
    fun oneTree() {
        val graph = createTree()
        Assertions.assertTrue(isForest(graph))
    }

    @Test
    fun oneNotTree() {
        val graph = createNotTree()
        Assertions.assertFalse(isForest(graph))
    }

    @Test
    fun oneTreeAndNotTree() {
        val graph = createTree()
        graph.addComponent(createNotTree())
        Assertions.assertFalse(isForest(graph))
    }

    @Test
    fun twoTrees() {
        val graph = createTree()
        graph.addComponent(createTree())
        Assertions.assertTrue(isForest(graph))
    }

    fun createTree(): Graph<Int> {
        val graph = Graph<Int>()
        val random = Random()
        graph.vertices.add(Vertex<Int>(random.nextInt()))
        return graph
    }

    fun createNotTree(): Graph<Int> {
        val graph = Graph<Int>()
        val random = Random()
        val vertex1 = Vertex<Int>(random.nextInt())
        val vertex2 = Vertex<Int>(random.nextInt())
        val vertex3 = Vertex<Int>(random.nextInt())
        graph.vertices.add(vertex1)
        graph.vertices.add(vertex2)
        graph.vertices.add(vertex3)
        val edge1 = Edge<Int>(vertex1, vertex2)
        val edge2 = Edge<Int>(vertex1, vertex3)
        val edge3 = Edge<Int>(vertex2, vertex3)
        graph.edges.add(edge1)
        graph.edges.add(edge2)
        graph.edges.add(edge3)
        return graph
    }
}