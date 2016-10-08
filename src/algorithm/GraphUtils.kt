package algorithm

import storage.*

fun <T> areIsomorphic(graph1: Graph<T>, graph2: Graph<T>): Boolean {
    val algorithm = AreIsomorphicAlgorithm<T>(graph1, graph2)
    algorithm.run()
    return algorithm.result
}

fun <T> findAllPaths(from: Vertex<T>, to: Vertex<T>): Set<Vertex<T>> {
    val algorithm = FindAllPathsAlgorithm<T>(from, to)
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