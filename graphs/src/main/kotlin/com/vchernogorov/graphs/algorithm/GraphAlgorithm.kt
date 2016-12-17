package com.vchernogorov.graphs.algorithm

import com.vchernogorov.graphs.model.ExtendedGraph

abstract class GraphAlgorithm<T, R>() {
    abstract fun start(graph: ExtendedGraph<T>): R
}