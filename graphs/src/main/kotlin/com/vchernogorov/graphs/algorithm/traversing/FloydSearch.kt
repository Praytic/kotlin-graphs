package com.vchernogorov.graphs.algorithm.traversing

import com.vchernogorov.graphs.model.ExtendedGraph
import com.vchernogorov.graphs.model.Graph
import com.vchernogorov.graphs.model.Vertex
import com.vchernogorov.graphs.model.storage.AdjacencyMatrix

internal class FloydSearch<T>(var onFindShortestPath: (Vertex<T>, Vertex<T>, Vertex<T>) -> Unit = { k, i, j -> })
    : TraversingAlgorithm<T>() {

    override fun start(graph: ExtendedGraph<T>) {
        val result = AdjacencyMatrix(graph)
        for (k in result.storage.keys) {
            for (i in result.storage.keys) {
                for (j in result.storage.keys) {
                    if (result[i, k] + result[k, j] > 0) {
                        result.storage[i]?.set(j, Math.min(result[i, k], result[i, k] + result[k, j]));
                        onFindShortestPath(i, j, k)
                    }
                }
            }
        }
    }
}