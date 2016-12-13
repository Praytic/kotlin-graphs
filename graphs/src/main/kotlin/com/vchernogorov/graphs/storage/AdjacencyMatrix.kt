package com.vchernogorov.graphs.storage

import com.vchernogorov.graphs.algorithm.INF

data class AdjacencyMatrix<T>(val storage: MutableMap<Vertex<T>, MutableMap<Vertex<T>, Int?>>) {
    constructor(): this(mutableMapOf())
    constructor(adjacencyMatrix: AdjacencyMatrix<T>): this(adjacencyMatrix.storage)
    constructor(graph: Graph<T>): this() {
        for (i in graph.vertices) {
            val mutableRow = mutableMapOf<Vertex<T>, Int?>()
            mutableRow.put(i, 0)
            for (j in graph.getOutgoingEdges(i)) {
                mutableRow.put(j.to, j.cost)
            }
            storage.put(i, mutableRow)
        }
    }

    fun getIncidenceMatrix(): Array<IntArray> {
        val matrixSize = this.storage.size
        val doubleArray = Array<IntArray>(matrixSize, { IntArray(matrixSize) })
        var i = 0
        for (row in this.storage.values) {
            var j = 0
            for (value in row.values) {
                if (value != null) doubleArray[i][j++] = 1
            }
            i++
        }
        return doubleArray
    }

    operator fun get(i: Vertex<T>, j: Vertex<T>): Int {
        return storage.get(i)?.get(j) ?: INF
    }
}