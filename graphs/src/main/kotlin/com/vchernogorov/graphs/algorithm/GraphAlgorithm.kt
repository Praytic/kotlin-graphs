package com.vchernogorov.graphs.algorithm

import com.vchernogorov.graphs.storage.Graph

abstract class GraphAlgorithm<T, R>(var graph: Graph<T>) : Algorithm<R>() {

    val n = graph.vertices.size
    val m = graph.edges.size
}