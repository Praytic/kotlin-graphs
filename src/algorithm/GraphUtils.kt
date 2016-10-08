package algorithm

import storage.Graph
import storage.Vertex

fun <T> isForest(graph: Graph<T>): Boolean {
    return run(IsForest<T>(graph))}

fun <T> isTree(graph: Graph<T>): Boolean {
    return run(IsTree<T>(graph))}

fun <T> areIsomorphic(graph1: Graph<T>, graph2: Graph<T>): Boolean {
    return run(AreIsomorphic<T>(graph1, graph2))}

fun <T> findAllPaths(from: Vertex<T>, to: Vertex<T>): Set<Vertex<T>> {
    return run(FindAllPaths<T>(from, to))
}

internal fun <T> run(algorithm: Algorithm<T>): T {
    algorithm.run()
    return algorithm.result
}