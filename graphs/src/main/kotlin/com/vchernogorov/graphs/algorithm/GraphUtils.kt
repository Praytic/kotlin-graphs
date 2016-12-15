package com.vchernogorov.graphs.algorithm

import com.vchernogorov.graphs.storage.Edge
import com.vchernogorov.graphs.storage.Graph
import com.vchernogorov.graphs.storage.Vertex

val INF = Int.MAX_VALUE / 2

fun <T> isForest(graph: Graph<T>) = run(IsForest(graph))

fun <T> isTree(graph: Graph<T>) = run(IsTree(graph))

fun <T, R> areIsomorphic(graph1: Graph<T>, graph2: Graph<R>) = run(AreIsomorphic(graph1, graph2))

fun <T> findAllPathsWithDfs(graph: Graph<T>, from: Vertex<T>, to: Vertex<T>) = run(FindAllPathsWithDfs(graph, from, to))

fun <T> findShortestPathWithDijkstra(graph: Graph<T>, from: Vertex<T>, to: Vertex<T>) = run(FindShortestPathWithDijkstra(graph, from, to))

fun <T> findShortestPathsToAll(algorithm: FindShortestPathsAlgorithm<T>):
        Set<Set<Edge<T>>> {
    return run(algorithm)
}

fun <T> findAllCycles(graph: Graph<T>) = run(FindAllCycles(graph))

fun <T> findMinimumSpanningTree(graph: Graph<T>) = run(FindMinimumSpanningTree(graph))

internal fun <T> run(algorithm: Algorithm<T>): T {
    algorithm.run()
    return algorithm.result
}