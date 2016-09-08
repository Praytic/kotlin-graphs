package algorithm

import storage.AdjacencyList
import storage.AdjacencyMatrix
import storage.Edge
import storage.Graph

fun <T> areIsomorphic(graph1: Graph<T>, graph2: Graph<T>): Boolean {
    if (graph1 === graph2) return true
    if (graph1.verticies.size == 0 && graph1.verticies.size == 0) return true
    if (graph1.verticies.size == graph2.verticies.size && graph1.edges.size == 0 && graph2.edges.size == 0) return true
    if (graph1.verticies.size != graph2.verticies.size) return false
    if (graph1.edges.size != graph2.edges.size) return false

    return areIsomorphic<T>(getAsAdjacencyMatrix(graph1), getAsAdjacencyMatrix(graph2))
}

fun <T> areIsomorphic(thisMatrix: AdjacencyMatrix<T>, otherMatrix: AdjacencyMatrix<T>): Boolean {
    for (row in thisMatrix.storage.values) {
        for (cell in row.values) {

        }
    }
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

