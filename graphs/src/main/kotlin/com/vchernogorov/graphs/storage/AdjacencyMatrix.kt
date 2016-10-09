package com.vchernogorov.graphs.storage

/**
 * Created by vchernogorov on 07/09/16.
 */
class AdjacencyMatrix<T>(val storage: MutableMap<T, MutableMap<T, Number?>>) {
    constructor(): this(mutableMapOf())
    constructor(adjacencyMatrix: AdjacencyMatrix<T>): this(adjacencyMatrix.storage)
    constructor(graph: Graph<T>): this() {
        for (i in graph.verticies) {
            val mutableRow = mutableMapOf<T, Number?>()
            for (j in graph.getOutgoingEdges(i)) {
                mutableRow.put(j.to.data, j.cost)
            }
            storage.put(i.data, mutableRow)
        }
    }
}