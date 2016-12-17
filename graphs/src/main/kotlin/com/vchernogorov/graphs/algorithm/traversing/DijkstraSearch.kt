package com.vchernogorov.graphs.algorithm.traversing

import com.vchernogorov.graphs.model.Edge
import com.vchernogorov.graphs.model.ExtendedGraph
import com.vchernogorov.graphs.model.Vertex

class DijkstraSearch<T>(var onFindShortestPathForVertex: (Vertex<T>, Edge<T>) -> Unit = { vertex, edge -> })
    : TraversingAlgorithm<T>() {

    override fun start(graph: ExtendedGraph<T>) {

    }
}