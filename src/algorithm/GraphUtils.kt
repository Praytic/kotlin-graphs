package algorithm

import storage.*

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

fun <T> getAsAdjacencyMatrix(graph: Graph<T>): AdjacencyMatrix<T> {
    val mutableColumn = mutableMapOf<T, MutableMap<T, Number?>>()
    for (i in graph.verticies) {
        val mutableRow = mutableMapOf<T, Number?>()
        for (j in graph.verticies) {
            val edge = (graph.edges.find { x -> x.to == j } ?: Edge(i, j, 0))
            mutableRow.put(edge.to.data, edge.cost)
        }
        mutableColumn.put(i.data, mutableRow)
    }
    return AdjacencyMatrix<T>(mutableColumn)
}

fun <T> getAsAdjacencyList(graph: Graph<T>): AdjacencyList<T> {
    val mutableColumn = mutableMapOf<T, MutableMap<T, Number?>>()
    for (i in graph.verticies) {
        val mutableRow = mutableMapOf<T, Number?>()
        for (j in i.outgoingEdges) {
            mutableRow.put(j.to.data, j.cost)
        }
        mutableColumn.put(i.data, mutableRow)
    }
    return AdjacencyList<T>(mutableColumn)
}