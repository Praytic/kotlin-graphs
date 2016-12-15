package com.vchernogorov.graphs.algorithm

import com.vchernogorov.graphs.storage.Graph
import com.vchernogorov.graphs.storage.Vertex
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class FindShortestPathsToAllTest {

    @Test
    fun singleVertexGraph() {
        val vertex = Vertex(0)
        val graph = Graph<Int>()
        graph.vertices.add(vertex)
        val algorithm = BellmanFordSearchAlgorithm<Int>(graph)
        val actualResult = findShortestPathsToAll(algorithm)
        Assertions.assertTrue(actualResult.isEmpty())
    }
}