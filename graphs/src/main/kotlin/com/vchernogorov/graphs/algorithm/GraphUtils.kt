package com.vchernogorov.graphs.algorithm

import com.vchernogorov.graphs.storage.Graph
import com.vchernogorov.graphs.storage.Vertex

fun <T> isForest(graph: Graph<T>) = run(IsForest(graph))

fun <T> isTree(graph: Graph<T>) = run(IsTree(graph))

fun <T, R> areIsomorphic(graph1: Graph<T>, graph2: Graph<R>) = run(AreIsomorphic(graph1, graph2))

fun <T> findAllPaths(graph: Graph<T>, from: Vertex<T>, to: Vertex<T>) = run(FindAllPaths(graph, from, to))

fun <T> findAllShortestCycles(graph: Graph<T>) = run(FindAllShortestCycles(graph))

fun <T> findMinimumSpanningTree(graph: Graph<T>) = run(FindMinimumSpanningTree(graph))

internal fun <T> run(algorithm: Algorithm<T>): T {
    algorithm.run()
    return algorithm.result
}