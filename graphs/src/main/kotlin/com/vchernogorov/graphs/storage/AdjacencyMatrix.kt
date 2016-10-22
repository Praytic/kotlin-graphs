package com.vchernogorov.graphs.storage

data class AdjacencyMatrix<T>(val storage: MutableMap<T, MutableMap<T, Number?>>) {
    constructor(): this(mutableMapOf())
    constructor(adjacencyMatrix: AdjacencyMatrix<T>): this(adjacencyMatrix.storage)
    constructor(graph: Graph<T>): this() {
        for (i in graph.vertices) {
            val mutableRow = mutableMapOf<T, Number?>()
            for (j in graph.getOutgoingEdges(i)) {
                mutableRow.put(j.to.data, j.cost)
            }
            storage.put(i.data, mutableRow)
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
}