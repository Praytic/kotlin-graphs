package com.vchernogorov.graphs.algorithm

import com.vchernogorov.graphs.storage.AdjacencyMatrix
import com.vchernogorov.graphs.storage.Graph
import com.vchernogorov.graphs.storage.Vertex

internal class FloydSearch<T>(graph: Graph<T>, val start: Vertex<T>,
                             var onFindShortestPath: (Vertex<T>, Vertex<T>, Vertex<T>) -> Unit = { k, i, j -> })
    : GraphAlgorithm<T, AdjacencyMatrix<T>>(graph) {

    override var result = AdjacencyMatrix(graph)

    override fun run() {
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